# Enigma
## Rust, JavaScript

Private compute. Compute on data while keeping it private. Callable from Ethereum contracts or a JS API.

[GitHub](https://github.com/enigmampc) - [Website](https://enigma.co/) - [Docs](https://enigma.co/discovery-documentation/) - [Chat](https://discord.gg/SJK32GY)


## Summary

Enigma is a computation network that achieves somewhat homomorphic encryption through multi-party computation. Secure compute is ensured by Intel SGX.

Compute tasks are written as secret contracts in Rust. These are deployed using EnigmaJS. Tasks are called from Ethereum contracts.

Network components:
1. Enigma Core: nodes running a trusted compute environment (SGX).
2. Enigma Contract (contains EnigmaJS): JS library for contract submissions + network Solidity contracts.
3. Enigma P2P: network communication.

## Requirements

- Docker
- Node.js
- Rust

## Install

You do *not* need an Intel SGX-compatible CPU to write Enigma apps. For local deployments, Enigma includes an emulator.

## Deploy a Secret Contract

The data size limit is 1MB for contract inputs.
