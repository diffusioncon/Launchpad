# IOTA
## Java, JavaScript, Go, Python, C#

DAG-based cryptocurrency. Excellent for building machine-to-machine payments applications, particularly for low-power device transaction submitters such as phones and IoT devices.

[GitHub](https://github.com/iotaledger) - [Website](https://www.iota.org/) - [Docs](https://docs.iota.org/) - [Chat](https://discord.iota.org/)

## The DAG

IOTA uses a Directed Acyclic Graph (DAG) rather than a blockchain. This is a graph where each transaction is a point appended to the existing graph.

Adding a transaction to the DAG involves verifying two existing transactions. This makes the network highly spam-resistant and scalable.

The DAG may be visualised as a set of points where each points backward at two previous points.

