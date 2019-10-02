# Enigma
## Rust, JavaScript

Private compute. Compute on data while keeping it private. Callable from Ethereum contracts or a JS API.

[GitHub](https://github.com/enigmampc) - [Website](https://enigma.co/) - [Docs](https://enigma.co/discovery-documentation/) - [Chat](https://discord.gg/SJK32GY)


## Summary

Enigma is a computation network that achieves somewhat homomorphic encryption through multi-party computation. Secure compute is ensured by Intel SGX and occurs on-chain.

Compute tasks are written as Secret Contracts in Rust. These are deployed using the Discovery CLI. Private data is encrypted by EnigmaJS and fed into Secret Contracts. Tasks are initiated by being called from Ethereum contracts.

Network components:

1. Discovery CLI: contract deployment CLI, dApp manager and node starter/stopper. Enigma's Truffle. You will be working with this.
2. EnigmaJS: JS library for task submissions.
3. Enigma Core: node software for running a trusted compute environment (SGX).
4. Enigma P2P: network communication.

## Requirements

- Docker
- Node.js
- Rust

## Install

```
npm install -g @enigmampc/discovery-cli
```

You do *not* need an Intel SGX-compatible CPU to write Enigma apps. For local deployments, Enigma includes an emulator.

## Deploy a Secret Contract

1. Initialise your dApp: `discovery init`. Select software mode if you don't have an SGX CPU.
2. Boot up the network: `discovery start`. 
3. Write a secret contract in Rust and put it in the `secret_contracts` folder. See `calculator.rs` for an example contract.
4. Compile your contract: `discovery compile`.
5. Deploy: `discovery migrate`. Will run any migrations in the `migrations` folder. 

Note you can add tests to the `tests` folder and run `discovery test` to test your code.

### Secret Contract specs

Secret contracts are written in Rust.

The data size limit is 1MB for contract inputs.

Supported types and their mapping in Solidity contracts:
- i32 => int32
- i64 => int64
- u32 => uint32
- u64 => uint64
- H160 => address
- H256 => bytes32
- U128 => uint128
- U256 => uint256
- Vec => bytes
- String => string
- Bool => bool

In general, stick to core Rust without dependencies and you can compute pretty much anything privately.
