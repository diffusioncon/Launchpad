# Chainlink
## Solidity, JavaScript

Trustworthy data feeds into smart contracts. Payments from contracts directly to FIAT accounts and services.

[GitHub](https://github.com/smartcontractkit) - [Website](https://chain.link) - [Docs](https://docs.chain.link/docs) - [Chat](https://gitter.im/smartcontractkit-chainlink/Lobby)

## Overview

Chainlink feeds external data into blockchains via adapters. It also allows payments to be made directly from contracts into FIAT, including bank accounts and Paypal.

Smart contracts with this functionality are called Chainlinked contracts.

Data is provided by Oracles. A full list of prebuilt data sources can be found [here](https://docs.chain.link/docs/available-oracles).

## Requirements

- Node.js
- Truffle
- Docker
- LINK tokens ([get testnet tokens free](https://docs.chain.link/docs/request-and-receive-data#section-requirements))

## Get started

For local testing, spin up an Ethereum + Chainlink node from [here](https://docs.chain.link/docs/running-a-chainlink-node).

New projects:
```
truffle unbox smartcontractkit/chainlink
```

Add to existing projects:
```
npm install chainlink --save
```

Create a contract:
```js
pragma solidity ^0.4.24;
import "chainlink/contracts/ChainlinkClient.sol";

// Inherit ChainlinkClient
contract MyContract is ChainlinkClient {
    constructor(address _link) public {
        // Set the address for the LINK token for the network.
        if(_link == address(0)) {
        // For public networks.
        setPublicChainlinkToken();
        } else {
        // For a local network.
        setChainlinkToken(_link);
        }
    }
    // Code here ...
}
```

Request data in the contract:
```js
function requestEthereumLastMarket(bytes32 _jobId) public returns ([RETURN_TYPE] [RETURN_VAR_NAME]) {
    Chainlink.Request memory req = buildChainlinkRequest(_jobId, this, this.fulfillEthereumLastMarket.selector);
    req.add("get", "URL");
    req.add("path", "PATH.TO.ELEMENT.IN.JSON.FROM.URL");
    // Sends the request with 1 LINK to the Oracle contract
    requestId = sendChainlinkRequest(req, 1 * LINK);
}
```

Receive data in the contract:
```js
function receive(bytes32 _requestId, [RETURN_TYPE] [RETURN_VAR_NAME]) public recordChainlinkFulfillment(_requestId)
{
    value = [RETURN_VAR_NAME];
}
```

See `ropsten.sol` for a full contract example running on the Ropsten testnet. The same contract for Kovan and Rinkeby can be found in the docs [here](https://docs.chain.link/docs/request-and-receive-data#section-complete-chainlink-contract-example).

## Full walkthrough

A full walkthrough of building a chainlinked project can be found [here](https://docs.chain.link/docs/example-walkthrough).
