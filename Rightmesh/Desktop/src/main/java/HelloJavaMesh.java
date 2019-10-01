/** HelloMesh: A sample RightMesh app for Java platforms.
    Copyright (C) 2018 RightMesh AG

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import io.left.rightmesh.id.MeshId;
import io.left.rightmesh.mesh.JavaMeshManager;
import io.left.rightmesh.mesh.MeshManager;

import java.io.Console;
import java.util.HashSet;

import static io.left.rightmesh.mesh.MeshManager.DATA_RECEIVED;
import static io.left.rightmesh.mesh.MeshManager.PEER_CHANGED;
import static io.left.rightmesh.mesh.MeshManager.REMOVED;

/*
 * "Hello RightMesh" for Java - a simple application example for using RightMesh in pure Java.
 */
public class HelloJavaMesh {
    private static final int HELLO_PORT = 9876;
    private JavaMeshManager mm;
    private HashSet<MeshId> users;

    public HelloJavaMesh() {
        users = new HashSet<>();
    }

    /**
     * Entry method. Creates a new instance of the app and starts it.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        HelloJavaMesh app = new HelloJavaMesh();
        app.start();
    }

    /**
     * App logic - starts and configures RightMesh, then transmits every string the user enters
     * until the user enters an empty line.
     */
    public void start() {
        // Attempt to connect to console for user input.
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            return;
        }

        //start up a non-superpeer right mesh
        mm = new JavaMeshManager(false, "rightmesh.json");

        // Bind to a Mesh Port.
        mm.bind(HELLO_PORT);

        // Register event handlers.
        mm.on(PEER_CHANGED, this::handlePeerChanged);
        mm.on(DATA_RECEIVED, this::handleDataReceived);

        // User input loop.
        System.out.println("Enter messages to send to all other peers:");
        String message;
        do {
            // Accept input.
            message = c.readLine();
            if (message == null || message.equals("")) {
                break;
            }

            // Send data to all peers.
            byte[] testData = message.getBytes();
            for (MeshId peer : users) {
                mm.sendDataReliable(peer, HELLO_PORT, testData);
            }
        } while (!message.equals(""));

        System.out.println("Shutting down RightMesh");
        mm.stop();
    }

    /**
     * Handles peer update events from the mesh - maintains a list of peers and updates the display.
     *
     * @param e event object from mesh
     */
    private void handlePeerChanged(MeshManager.RightMeshEvent e) {
        // Update peer list.
        MeshManager.PeerChangedEvent event = (MeshManager.PeerChangedEvent) e;

        if (event.state != REMOVED && !users.contains(event.peerUuid)) {
            users.add(event.peerUuid);
            System.out.println("PEER JOINED: " + event.peerUuid);
        } else if (event.state == REMOVED && users.contains(event.peerUuid)) {
            users.remove(event.peerUuid);
            System.out.println("PEER LEFT: " + event.peerUuid);
        }
    }

    /**
     * Handles incoming data events from the mesh - prints the contents of the data.
     * @param e event object from mesh
     */
    private void handleDataReceived(MeshManager.RightMeshEvent e) {
        MeshManager.DataReceivedEvent event = (MeshManager.DataReceivedEvent) e;
        String message = new String(event.data);
        System.out.println("Received from " + event.peerUuid + ":" + message);
    }
}
