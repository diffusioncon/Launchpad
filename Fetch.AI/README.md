# Fetch.AI
## `C++`, `Python`, `Java/Kotlin`

An Open Economic Framework (OEF) for AI agents acting on behalf of humans. An excellent technology for machine learning and agent-based projects.

Fetch.AI has two parts: a smart contract platform and an automated buying / selling framework.

[GitHub](https://github.com/fetchai) - [Website](https://fetch.ai/) - [Docs](https://docs.fetch.ai/) - [Chat](https://app.slack.com/client/TCK9CHC5V)

### Requirements

## Requirements

- Linux or MacOS
- Docker
- Latest `protobuf`: install binary [from source](https://github.com/protocolbuffers/protobuf/releases)

### Two components: Ledger and OEF

#### The Ledger (Smart Contracts)

The Fetch.AI ledger runs smart contracts in its own native language, `Etch`. Functionality is similar to Ethereum, with a [hosted in-browser debugger](http://etch-playground.fetch.ai/).

Node: [here](https://github.com/fetchai/ledger).

Deployments are done using the Ledger API in Python: `pip3 install fetchai-ledger-api`. Get started [here](https://docs.fetch.ai/etch-language/getstarted/).

See `smart_contract.py` for how to deplopy smart contracts to your node.

#### The Open Economic Framework (OEF)

The OEF is an agent framework that runs on top of the ledger layer. It is highly developed and excellent for automated buying and selling.

The OEF is composed of Automous Economic Agents (AEAs). These are configured as a class `OEFAgent`. When working with agents, you simply extend this class - it includes a range of messaging, negotiation and trading functions.

Requires: `Bazel`

Node: requires a pair of nodes from [here](https://github.com/fetchai/oef-mt-core) and [here](https://github.com/fetchai/oef-search-pluto).

Get started in Python with `pip3 install oef`, in C++ [here](https://github.com/fetchai/oef-sdk-cpp) and in Java/Kotlin [here](https://docs.fetch.ai/oef/java-kotlin-API/). Docs can be found can be found [here](https://docs.fetch.ai/oef/).

See `aea_buyer.py` and `aea_seller.py` for an example pair of AEAs trading weather data.

### Decentralised Machine Learning Example

[CNNs in a decentralised network]().