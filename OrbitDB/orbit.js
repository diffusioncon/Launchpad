const IPFS = require('ipfs')
const OrbitDB = require('orbit-db')

// Pubsub muist be passed to all IPFS functions
const ipfsOptions = {
EXPERIMENTAL: {
        pubsub: true
    }
}

// Create IPFS instance
const ipfs = new IPFS(ipfsOptions)

ipfs.on('error', (e) => console.error(e))
ipfs.on('ready', async () => {
    const orbitdb = await OrbitDB.createInstance(ipfs)

    // Create / Open a database
    // Log is one of five types of database available
    const db = await orbitdb.log('hello')
    await db.load()

    // Listen for updates from peers
    db.events.on('replicated', (address) => {
        console.log(db.iterator({ limit: -1 }).collect())
    })

    // Add an entry
    const hash = await db.add('world')
    console.log(hash)

    // Query
    const result = db.iterator({ limit: -1 }).collect()
    console.log(JSON.stringify(result, null, 2))
})