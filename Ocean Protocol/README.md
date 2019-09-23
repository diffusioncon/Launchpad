# Ocean Protocol
## `JavaScript`, `Python`, `Java`

A data marketplace. Buy and sell datasets.

## Starting fast

Ocean can be quickly built on top of using Squid, its client library and API. For Python: `pip3 install squid-py`, for JavaScript: `npm i @oceanprotocol/squid` and for Java: [add squid as a Maven dependency](https://github.com/oceanprotocol/squid-java#installation).

Spin up a minimal node:
```
git clone https://github.com/oceanprotocol/barge.git
cd barge
./start_ocean.sh --latest --no-pleuston --no-brizo --local-spree-node --force-pull
```
Replace `spree` with `nile` or `pacific` for test and main-nets, respectively. See [here](https://github.com/oceanprotocol/barge#all-options) for the various flags you can add when starting Ocean, and see [here](https://docs.oceanprotocol.com/concepts/architecture/) for what each building block (Keeper, Brizo etc.) does.

You can now interact with your node using Squid. See `squid.py` for an example.

*Note that you will need a config file for Squid. See the indivdual langauge flavours for details:*
- [Python](https://github.com/oceanprotocol/squid-py)
- [JavaScript](https://github.com/oceanprotocol/squid-js)
- [Java](https://github.com/oceanprotocol/squid-java)

## Note to Python users

On first boot-up, you'll need to copy artifacts out of the container:
```
until docker cp ocean_keeper-contracts_1:/keeper-contracts/artifacts/. artifacts_path &> /dev/null
do
    sleep 5
done
```

## Data Commons

A large library of datasets, all running live on Ocean Protocol, is available at the [Commons Marketplace](https://commons.oceanprotocol.com/).


