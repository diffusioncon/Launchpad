# Hyperledger / Sovrin
## Rust, Python, JavaScript, Java, C#, iOS

Hyperledger Indy (Sovrin) is a blockchain for self-sovereign identity and digital credentials. It is an excellent platfrom for building anything to do with digital identity and credentials such as passports.

Using the Hyperledger Indy SDK requires knowledge of *one* of Rust, Python, JavaScript, Java, C# or iOS.


## How it works (worth the read)

### DIDs and Self-Sovereign Identity

The blockchain is a Public Key Infrastructure (PKI). Each person has a public key on the ledger called a Decentralised Digital Identifier (DID).

DIDs point to personal information on the end-user's device. The end-user is in control of their own personal data and what gets revealed to whom. This form of identity is called Self-Sovereign Identity (SSI).

### Proofs and Credentials

End users make proofs regarding their personal information, which can reveal an item in full, or as a predicate, for example proving you're over 18 without revealing your actual age.

Multiple pieces of personal information can be combined into credentials. Credentials are given by issuers. For example, a university may issue you with a degree credential. You can then prove to an employer that you have a certain degree from a cerain institution.

The [Hyperledger Indy SDK](https://github.com/hyperledger/indy-sdk) lets you register people's DIDs, issue credentials and verify personal information in Rust, Python, JavaScript, Java, C# and iOS.

### Onboarding

The Sovrin network is the public network of nodes for Hyperledger Indy, run by Cisco, IBM and over 70 other enterprises. The node owners are called Stewards. To use the network, you have to be onboarded.

Request that a Steward onboard you (Sovrin, Evernym and Outlier Ventures are able and at Diffusion), after which you will be able to onboard others.

In a local test network, you will have to boot up a Steward from a seed and then onboard any other individuals and issuers. See `credentials.py` for an example.

### Summary

- DIDs on the blockchain point to personal data on end-user devices.
- People make proofs about their personal info.
- Personal info is combined into credentials like degrees.
- Credentials are given by issuers and can be verified by anyone.
- To use the network, you need to be onboarded by someone already on it.


## Hyperledger, Indy, Sovrin, Evernym - what's the difference?

- Hyperledger is a collection of open-source enterprise blockchain technologies governed by the Linux Foundation.
- Hyperledger Indy is one of many Hyperledger projects. Indy is focused on digital identity and credentials.
- Sovrin (the Sovrin Foundation) donated the Indy codebase to Hyperledger and continues to maintain it. Sovrin organises the public network of nodes for the blockchain, some of which are run by IBM, Cisco and Outlier Ventures. *For all intents and purposes, Hyperledger Indy and Sovrin are synonymous.*
- Evernym is the original company that started work on digital identity. It founded the Sovrin Foundation to focus on the digital identity platform. Evernym now focuses on enterprise and user products on top of Hyperledger Indy.
