# SEED
## JavaScript, Python

Marketplace for chatbots and voice assistants. Keeps the use of voice data trustworthy though blockchain.

[GitHub](https://github.com/seedvault) - [Website](https://www.seedtoken.io/) - [Dev portal](https://developers.seedtoken.io/) - [Chat](https://discord.gg/Suv5bFT)


## Components

1. Greenhouse: REST API for the marketplace with a Vue frontend.
2. Rhizome: chatbot in python.
3. Hadron: front-end deployment tool for chatbots - UIs, text-to-speech, voice and 3D avatars.

## Get started

### Requirements

- Docker
- Python + pipenv
- Node.js

If you have issues with the `pipenv` install, try:
```
pip install --upgrade pip
pip install git+https://github.com/pypa/pipenv.git
```

### Greenhouse

#### Install

```
git clone https://github.com/SeedVault/greenhouse.git
cd greenhouse
npm install
ln -s ../dev-environment/.env
```

#### Use

Dev server:
```
npm run serve
```

Build:
```
npm run build
```

### Rhizome

#### Install

```
git clone https://github.com/SeedVault/rhizome
cd rhizome
./build.sh
cd docker && docker exec -it docker_mongo_1 bash /seed/seedmongo.sh rhizomedb && cd ..
```

#### Use

```
BBOT_ENV=development python -m channels.console.app <userId> <botIdOrName> <orgId> debug|nodebug
```

userId: Any alphanumeric ID to identify yourself.
botIdOrName: The bot ID or bot name you want to run. You can find this in dotbot collection in mongo database
orgId: Organization ID (not supported yet).
debug|nodebug: debug will show the raw json object returned by the bot engine. nodebug will just show text.

Try the included demo bot with:
```
BBOT_ENV=development python -m channels.console.app joe testbot 1 debug
```

For chatbot webservers and telegram bots, see the [Rhizome repository](https://github.com/SeedVault/rhizome#running-a-restful-web-server-and-a-simple-chatbot-web-widget-plain-text-only). 

### Hadron

#### Install

```
git clone https://github.com/SeedVault/Hadron.git
cd Hadron
npm install
```

#### Use

Run a dev server:
```
BBOT_ID=5d1627422047fc0006614969 BBOT_URL=http://localhost:5000/restful_channel npm run dev
```

Load the bot in HTML:
```HTML
<span 
    class="hadron-button quark"
    data-bot-show-debug="true"
    data-bot-uses-3d-avatar="false"
    data-bot-size-class="fullscreen"
    data-bot-placeholder=""
    data-bot-talks-first="true"
    data-bot-welcome="Hi!"
    data-bot-reset-on-load="true"
    data-bot-subtitle=""
    data-bot-recall-interactions="false"
    data-bot-title="Avataracious BETA"
    data-bot-voice-recognition-visible="true"
    data-bot-voice-recognition-continuous="true"        
    data-bot-load-font="Montserrat:300,400,600"        
    data-bot-external-css=""
    data-bot-launcher-external-css="s"
    data-bot-track-anonymous-user-id="false"
    data-bot-bbot-uri="http://domain:port/restful_channel"
    data-bot-id="5d132a422057fc0076714969"
></span>        
<script type="text/javascript" src="app.bundle.js"></script>
```

See the [Hadron repo](https://github.com/SeedVault/Hadron#settings) for configurable bot presentation settings.