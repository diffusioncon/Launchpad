# IOTA
## Java, JavaScript, Go, Python, C#

DAG-based cryptocurrency. Excellent for building machine-to-machine payments applications, particularly for low-power device transaction submitters such as phones and IoT devices.

[GitHub](https://github.com/iotaledger) - [Website](https://www.iota.org/) - [Docs](https://docs.iota.org/) - [Chat](https://discord.iota.org/)

## The DAG and Trinary

IOTA uses a Directed Acyclic Graph (DAG) rather than a blockchain. This is a graph where each transaction is a point appended to the existing graph.

Adding a transaction to the DAG involves verifying two existing transactions. This makes the network highly spam-resistant and scalable. The DAG may be visualised as a set of points where each points backward at two previous points.

Much of IOTA's architecture makes use of trinary rather than binary (3 values rather than just 0 and 1). Trytes rather than bytes are used for encoding messages.

## Get Started

### Requirements

- Java 8
- Maven
- Language of your client library of choice: Java, JavaScript, Go, Python or C#.

### Setup

1. Create a seed to work with accounts:
    - Linux: `cat /dev/urandom |tr -dc A-Z9|head -c${1:-81}`
    - macOS: `cat /dev/urandom |LC_ALL=C tr -dc 'A-Z9' | fold -w 81 | head -n 1`
    - Windows:
        A. Download [KeePass](https://keepass.info/) and open it.
        B. Go to NEW > ADD ENTRY > GENERATE A PASSWORD.
        C. Set length 81, upper case, also include the following characters: 9.
        D. Click OK.
    *Save your seed somwhere it won't get lost.*
2. [Clone, build and boot up a node](https://github.com/iotaledger/iri).
3. Pick up a client library of choice:
    - [Java](https://docs.iota.org/docs/iota-java/0.1/introduction/overview)
    - [JavaScript](https://docs.iota.org/docs/iota-js/0.1/introduction/overview)
    - [Go](https://docs.iota.org/docs/iota-go/0.1/introduction/overview)
    - [Python](https://github.com/iotaledger/iota.py)
    - [C#](https://github.com/iota-community/tangle-.net)
4. Choose your application(s) of the IOTA API: core node communications, transactions (accounts module), and/or masked authenticated messaging (JavaScript client only). Once chosen, follow your client guide linked above. A JavaScript walkthrough of sending transactions is included below.

## JavaScript walkthrough: sending transactions

1. `npm install @iota/core @iota/converter --save`
2. Copy `data-transaction.js` to your working folder.
3. Put the address to send to and your seed in `data-transaction.js` and run it.
4. If using the devnet (default in the file), check your transaction went through using the [DevNet Tangle Explorer](https://devnet.thetangle.org/).