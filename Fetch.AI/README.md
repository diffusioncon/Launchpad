# Fetch.AI
## `C++`, `Python`, `Java/Kotlin`

An Open Economic Framework (OEF) for AI agents acting on behalf of humans. An excellent technology for machine learning and agent-based projects.

Fetch.AI has two parts: a smart contract platform and second layer of autonomous economic agents embeded in an open economic framework.

[GitHub](https://github.com/fetchai) - [Website](https://fetch.ai/) - [Docs](https://docs.fetch.ai/) - [Chat](https://app.slack.com/client/TCK9CHC5V)

## Requirements

Depending on the layer:

- Linux or MacOS
- Docker
- Latest `protobuf`: install binary [from source](https://github.com/protocolbuffers/protobuf/releases)

### Two layers: Ledger & OEF and AEAs

#### The Ledger (Smart Contracts)

The Fetch.AI [ledger](https://docs.fetch.ai/ledger/architecture/) runs smart contracts in its [own native language](https://docs.fetch.ai/etch-language/), `Etch`. The functionality is similar to Ethereum, with a [hosted in-browser debugger](https://build.fetch.ai).

To ease transition for developers familiar with the Ethereum ecosystem, Fetch.AI provides a Solidity to Etch [transpiler](https://build.fetch.ai/solidity/).

Deployments are done using the Ledger API in Python: `pip3 install fetchai-ledger-api`. Get started [here](https://docs.fetch.ai/getting-started/python-api-install/).

See `smart_contract.py` for how to deploy smart contracts to your node.

#### The Open Economic Framework (OEF) and Autonomous Economic Agents (AEAs)

The Open Economic Framework is the Fetch.AI decentralised virtual environment that supplies and supports APIs for autonomous third-party software agents, also known as Autonomous Economic Agents (AEAs).

For more details on the OEF check out the documentation [here](https://docs.fetch.ai/oef/).

#### SDK approach to building lightweight agents:

You can write simple agents by simply extending the `OEFAgent` class provided in the oef SDK - it includes a range of messaging, negotiation and trading functions.

See `aea_buyer.py` and `aea_seller.py` for an example pair of agents trading weather data.

Get started in Python with `pip3 install oef`, in C++ [here](https://github.com/fetchai/oef-sdk-cpp) and in Java/Kotlin [here](https://docs.fetch.ai/oef/java-kotlin-API/). Docs can be found can be found [here](https://docs.fetch.ai/oef/).

Node: requires a pair of nodes from [here](https://github.com/fetchai/oef-mt-core) and [here](https://github.com/fetchai/oef-search-pluto).

#### AEA framework for highly modular and composable agents:

The [AEA Framework](https://fetchai.github.io/agents-aea/) is a framework for developing autonomous economic agents in Python. Similar to web frameworks it helps the developer to focus on the business logic they want to implement in their agent and allows developers to share `skills` and other packages.

## Machine Learning with Fetch.AI

You can plug Python code natively into any OEF agent with the OEF Python SDK.

Create a class that extends `OEFAgent` and just plug any ML functions in as needed. See `aea_buyer.py` and `aea_seller.py` for examples.
