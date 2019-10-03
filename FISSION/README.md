# Fission
## JavaScript, Solidity, Haskell, Clojure, C#, Elixir, Elm, Erlang, Go, Java, Kotlin, PHP, Python, Rust, Scala, Swift, TypeScript

Quickly deploy websites to IPFS, work with IPFS storage from Heroku, plus status codes for smart contracts.

[GitHub](https://github.com/fission-suite) - [Website](https://fission.codes/) - [Docs](https://docs.fission.codes/) - [Chat](https://discord.gg/daDMAjE)

## Components

1. IPFS-deploy: quickly deploy a website to IPFS.
2. Get-IPFS: quickly load IPFS in a webpage.
3. IPFS-API: use IPFS like regular cloud storage in most popular languages.
4. FISSION Codes: status codes for smart contracts (the equivalent of 404, 500, 503 etc for HTTP) for easy runtime debugging and contract interoperability.

## FISSION Codes

### Install

```
npm install --save fission-codes
```

### Use

In your JavaScript:
```js
const fission = require('fission-codes');
```

In your Solidity:
```js
pragma solidity ^0.5.0;
import { FISSION } from "/fission-codes/contracts/FISSION.sol";
```

Now access codes using:
```js
FISSION.Code(FISSION.Status.[PickStatusEgRevoked])
```
For a full list of codes, see the [FISSION Codes grid](https://docs.fission.codes/fission-codes/grid/).

See `codes.sol` for an example authorisation mechanism in Solidity using FISSION codes.


## IPFS-deploy

### Install

```
npm install -g ipfs-deploy
```

### Use

Build your site in your chosen framework and build the static pages. Go to the directory and type `ipd` to deploy. This will dynamically chose the directory to deploy based on populaar frameworks:

| Path            | Static generators                       |
| --------        | ---------------------------------       |
| `_site`         | jekyll, hakyll, eleventy                |
| `site`          | some others                             |
| `public`        | gatsby, hugo                            |
| `dist`          | nuxt                                    |
| `output`        | pelican                                 |
| `out`           | hexo                                    |
| `build`         | create-react-app, metalsmith, middleman |
| `website/build` | docusaurus                              |
| `docs`          | many others                             |

You can also manually specify the build directory manually, e.g. `ipd /public`.

IPFS-deploy will deploy your site via Infura and returns your IPFS URL at `ipfs.io`.

## Get-IPFS

### Install

```
npm install get-ipfs
```

### Use

Set up a config:
```js
{
  // `permissions` are enabled if the browser is ipfs-capable (Opera or extension)
  // passed to `window.ipfs.enable` if available
  // prevents a permission dialog from appearing for every action
  permissions: ['id', 'version', 'add', 'cat', 'dag', 'swarm'],

  // `peers` is a list of peer multiaddrs to connect to on load
  // to work with the `js-ipfs` fallback, these must have available websocket ports
  peers: []

  // `browserPeers` is a list of peer multiaddrs to connect to only on fallback to an in-browser js-ipfs daemon
  // note: these must be secure websocket or WebRTC addresses
  browserPeers: []

  // `localPeers` is a list of peer multiaddrs to connect to if using a local ipfs daemon (through ipfs companion for instance)
  localPeers: []
}
```

Use in JavaScript:
```js
import getIpfs from 'get-ipfs'
const ipfs = await getIpfs([config])
```