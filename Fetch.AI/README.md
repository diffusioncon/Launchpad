# Fetch.AI
## `C++`, `Python`, `Java/Kotlin`

An Open Economic Framework (OEF) for AI agents acting on behalf of humans. An excellent technology for machine learning and agent-based projects.

Fetch.AI has two parts: a smart contract platform and an automated buying / selling framework.

### Two components: Ledger and OEF

The Ledger and OEF run separate node software and everything is containerised. You will need Docker.

All your work with Fetch.AI will require Protocol Buffers.

Linux:
```
sudo apt-get install protobuf-compiler
```

MacOS:
```
brew install protobuf
```

#### The Ledger (Smart Contracts)

The Fetch.AI ledger runs smart contracts in its own native language, `Etch`. Functionality is similar to Ethereum, with a [hosted in-browser debugger](http://etch-playground.fetch.ai/).

Node: [here](https://github.com/fetchai/ledger).

Deployments are done using the Ledger API in Python: `pip3 install fetchai-ledger-api. Get started [here](https://docs.fetch.ai/etch-language/getstarted/).

#### The Open Economic Framework (OEF)

The OEF is an agent framework that runs on top of the ledger layer. It is highly developed and excellent for automated buying and selling.

The OEF is composed of Automous Economic Agents (AEAs). These are configured as a class `OEFAgent`. When working with agents, you simply extend this class - it includes a range of messaging, negotiation and trading functions.

Requires: `Bazel`
Node: [here](https://github.com/fetchai/oef-mt-core).

Get started in Python with `pip3 install oef`, in C++ [here](https://github.com/fetchai/oef-sdk-cpp) and in Java/Kotlin [here](https://docs.fetch.ai/oef/java-kotlin-API/). Docs can be found can be found [here](https://docs.fetch.ai/oef/).
