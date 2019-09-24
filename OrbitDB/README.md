# OrbitDB (Haja Networks)
## JavaScript

Decentralised database. Highly usable API for quickly storing data on IPFS.

Great for in-browser and Node.js applications, or anything that needs decentralised storage.

## Get Started

Install: `npm install orbit-db ipfs`

Start: see `orbit.js`.

### 5 Database Types

- Key-Value
- Log (append-only log)
- Feed (same as log database but entries can be removed)
- Documents (store indexed JSON documents)
- Counters

Use in JS: `orbitdb.[db_type]('name')`

For full usge details, see the [API reference](https://github.com/orbitdb/orbit-db/blob/master/API.md).

It is also possible to [create your own database type](https://github.com/orbitdb/orbit-db/blob/master/GUIDE.md#custom-stores).

## Wait, this readme seems kind of short?

It really is that simple - thank the Haja Networks team.

Check out the full docs and some example uses of OrbitDB [here](https://github.com/orbitdb/orbit-db)