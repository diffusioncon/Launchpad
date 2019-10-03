# Fission
## JavaScript, Solidity, Haskell, Clojure, C#, Elixir, Elm, Erlang, Go, Java, Kotlin, PHP, Python, Rust, Scala, Swift, TypeScript

Quickly deploy websites to IPFS, work with IPFS storage from Heroku, plus status codes for smart contracts.

[GitHub](https://github.com/fission-suite) - [Website](https://fission.codes/) - [Docs](https://docs.fission.codes/) - [Chat](https://discord.gg/daDMAjE)

## Components

1. IPFS-deploy: quickly deploy a website to IPFS.
2. Get-IPFS: quickly load IPFS in a webpage.
3. IPFS-API: use IPFS like regular cloud storage in most popular languages.
4. FISSION Codes: status codes for smart contracts (the equivalent of 404, 500, 503 etc for HTTP) for easy runtime debugging and contract interoperability.

# #FISSION Codes

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



