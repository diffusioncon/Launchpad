package io.left.hellomesh

import android.app.Activity
import android.media.RingtoneManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import java.util.HashSet

import io.left.rightmesh.android.AndroidMeshManager
import io.left.rightmesh.id.MeshId
import io.left.rightmesh.mesh.MeshManager
import io.left.rightmesh.mesh.MeshManager.PeerChangedEvent
import io.left.rightmesh.mesh.MeshManager.RightMeshEvent
import io.left.rightmesh.mesh.MeshStateListener
import io.left.rightmesh.util.RightMeshException

import io.left.rightmesh.mesh.MeshManager.DATA_RECEIVED
import io.left.rightmesh.mesh.MeshManager.PEER_CHANGED
import io.left.rightmesh.mesh.MeshManager.REMOVED
import io.left.rightmesh.util.Logger

class MainActivity : Activity(), MeshStateListener {
    companion object {
        // TODO: this port must match the port assigned, on developer.rightmesh.io, to your key
        private const val HELLO_PORT = 9876
        private val LOG_TAG = MainActivity::class.java.canonicalName
    }

    // MeshManager instance - interface to the mesh network.
    private lateinit var mm: AndroidMeshManager

    // Set to keep track of peers connected to the mesh.
    private var users: HashSet<MeshId> = HashSet()

    /**
     * Called when app first opens, initializes [AndroidMeshManager] reference (which will
     * start the [MeshService] if it isn't already running.
     *
     * @param savedInstanceState passed from operating system
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: when testing, we suggest using rightmesh-library-dev in app:build.gradle,
        // and specifying a pattern as the third argument to this call. This will isolate
        // your devices so they won't try to connect to the network of the developer sitting
        // beside you :D
        mm = AndroidMeshManager.getInstance(this@MainActivity, this@MainActivity)
    }

    /**
     * Called when activity is on screen.
     */
    override fun onResume() {
        try {
            super.onResume()
            mm.resume()
        } catch (e: RightMeshException.RightMeshServiceDisconnectedException) {
            e.printStackTrace()
        }
    }

    /**
     * Called when the app is being closed (not just navigated away from). Shuts down
     * the [AndroidMeshManager] instance.
     */
    override fun onDestroy() {
        try {
            super.onDestroy()
            mm.stop()
        } catch (e: RightMeshException.RightMeshServiceDisconnectedException) {
            e.printStackTrace()
        }
    }

    /**
     * Called by the [MeshService] when the mesh state changes. Initializes mesh connection
     * on first call.
     *
     * @param uuid our own user id on first detecting
     * @param state state which indicates SUCCESS or an error code
     */
    override fun meshStateChanged(uuid: MeshId, state: Int) {
        if (state == MeshStateListener.SUCCESS) {
            try {
                // Binds this app to MESH_PORT.
                // This app will now receive all events generated on that port.
                mm.bind(HELLO_PORT)

                // Subscribes handlers to receive events from the mesh.
                mm.on(DATA_RECEIVED, { this.handleDataReceived(it) })
                mm.on(PEER_CHANGED, { this.handlePeerChanged(it) })

                // Enable buttons now that mesh is connected.
                val btnConfigure = findViewById<Button>(R.id.btnConfigure)
                val btnSend = findViewById<Button>(R.id.btnHello)
                btnConfigure.isEnabled = true
                btnSend.isEnabled = true
            } catch (e: RightMeshException) {
                val status = "Error initializing the library" + e.toString()
                Toast.makeText(this.applicationContext, status, Toast.LENGTH_SHORT).show()
                val txtStatus = findViewById<TextView>(R.id.txtStatus)
                txtStatus.text = status
                return
            }
        }

        // Update display on successful calls (i.e. not FAILURE or DISABLED).
        if (state == MeshStateListener.SUCCESS || state == MeshStateListener.RESUME) {
            updateStatus()
        }
    }

    /**
     * Update the [TextView] with a list of all peers.
     */
    private fun updateStatus() {
        val status = StringBuilder("uuid: " + mm.uuid.toString() + "\npeers:\n")
        for (user in users) {
            status.append(user.toString()).append("\n")
        }
        val txtStatus = findViewById<TextView>(R.id.txtStatus)
        txtStatus.text = status.toString()
    }

    /**
     * Handles incoming data events from the mesh - toasts the contents of the data.
     *
     * @param e event object from mesh
     */
    private fun handleDataReceived(e: RightMeshEvent) {
        val event = e as MeshManager.DataReceivedEvent

        runOnUiThread {
            // Toast data contents.
            val message = String(event.data)
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()

            // Play a notification.
            val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(this@MainActivity, notification)
            r.play()
        }
    }

    /**
     * Handles peer update events from the mesh - maintains a list of peers and updates the display.
     *
     * @param e event object from mesh
     */
    private fun handlePeerChanged(e: RightMeshEvent) {
        // Update peer list.
        val event = e as PeerChangedEvent
        if (event.state != REMOVED && !users.contains(event.peerUuid)) {
            users.add(event.peerUuid)
        } else if (event.state == REMOVED) {
            users.remove(event.peerUuid)
        }

        // Update display.
        runOnUiThread({ this.updateStatus() })
    }

    /**
     * Sends "hello" to all known peers.
     *
     * @param v calling view
     */
    @Throws(RightMeshException::class)
    fun sendHello(v: View) {
        for (receiver in users) {
            val msg = "Hello to: " + receiver + " from" + mm.uuid
            Logger.info(LOG_TAG, "MSG: $msg")
            val testData = msg.toByteArray()
            mm.sendDataReliable(receiver, HELLO_PORT, testData)
        }
    }

    /**
     * Open mesh settings screen.
     *
     * @param v calling view
     */
    fun configure(v: View) {
        try {
            mm.showSettingsActivity()
        } catch (ex: RightMeshException) {
            Logger.info(LOG_TAG, "Service not connected")
        }
    }
}