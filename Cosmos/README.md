# Cosmos
## Go

SDK for building PoS and PoA blockchains.

[GitHub](https://github.com/cosmos) - [Website](https://cosmos.network/) - [Docs](https://cosmos.network/docs/) - [Chat](https://web.telegram.org/#/im?p=@cosmosproject)

## Summary

Your blockchain runs as an application on top of [Tendermint](https://github.com/tendermint/tendermint). Your application communicates with Tendermint using an Application BlockChain Interface (ABCI).

A boilerplate ABCI called `baseapp` will handle the communication with Tendermint for you. In building a Cosmos application, you create a custom type `nameServiceApp` which embeds (inherits/extends) `baseapp`.

## Requirements

- Go (check your [$GOPATH](https://github.com/golang/go/wiki/SettingGOPATH))

## Get started

Create a project directory under your `$GOPATH`:
```sh
mkdir -p $GOPATH/src/github.com/{ .Username }/nameservice
cd $GOPATH/src/github.com/{ .Username }/nameservice
git init
```

The easiest way to build a Cosmos application is to follow the [tutorial](https://cosmos.network/docs/tutorial/app-design.html#state).

A core framework for your app can be found in `app.go`.

The completed application for the tutorial can be found [here](https://github.com/cosmos/sdk-application-tutorial).