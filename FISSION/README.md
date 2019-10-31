# Fission
Welcome! We’re happy to be here helping out with the Web 2.5 track at the first [Diffusion](https://diffusion.events) hackathon in Berlin!.

We're also thrilled to show off a new piece of technology enabled by IPFS called **Fission Live**.

Our service lets you instantly update files, directories and obviously websites directly to IPFS and serve them anywhere. This lets us all quickly collaborate on projects, instantly share files from the CLI all in a way that's open by default, fast and available across the planet.

# What is Fission?

Fission is a backend-as-a-service that lets you deploy apps quickly. We enable you to include hosting, file storage -- and in the future logins and databases -- from your local machine or distributed across the world.

We build on top of decentralized web technologies like the InterPlanetary File System (IPFS) to enable all of these dev friendly features.

# Fission Live: Apps that go live from your laptop

Live from laptop is the Fission service that lets you host your app — whether it’s a static website or a Single Page App — directly from your laptop.

Following the steps below, you’ll be able to use our command line interface (CLI) to watch any folder and send its contents live to the world.

_Our API is also open and readily available to let you upload and host user files on IPFS simply and easily._

# Installation

Fission is your toolkit for easily interfacing with IPFS. To get started, you'll need to install IPFS as well as the Fission CLI tool.

## Installing IPFS

We recommend the [ipfs-desktop client](https://github.com/ipfs-shipyard/ipfs-desktop) especially if you are new to IPFS. You can drag and drop files, browse your local IPFS files visually, and even integrate a shortcut for taking screenshots and auto-uploading them to IPFS.

The IPFS daemon starts automatically when you run the desktop.

If you're on Mac with Homebrew, the simple one-liner for installing ipfs is:

```bash
brew install ipfs
```

To start the local IPFS daemon:

```bash
brew services start ipfs
```

Check the [Fission Installation Guide](https://guide.fission.codes/installation) for extended instructions for all platforms.

## Installing Fission

### MacOS
```bash
brew tap fission-suite/fission
brew install fission-cli
```

### Linux / Windows Subsystem

```bash
# Download our binary
curl -L \
 https://github.com/fission-suite/web-api/releases/download/1.16.0/deb-cli \
 -o fission-cli

# Give it executable permission
sudo chmod +x ./fission-cli

# And move the file to your PATH:
sudo mv ./fission-cli /usr/local/bin/fission
```

That's it! Double check that it's installed correctly:

```bash
fission --help
```

# Going Live

_Lets make a file accessible to anyone on the internet_

## Get your free account setup

```bash
fission register
```

_We issue you a username and password and create a `.fission.yaml` in your home directory that stores them for you._

## Create a simple site

```bash
mkdir my-sweet-fission-app
cd my-sweet-fission-app
echo "Hello Diffusion\!" >> index.html
curl https://i.imgur.com/MhUt8uB.gif --output john.gif
echo "<br/><img src=\"john.gif\"/>" >> index.html
```

## Let it loose

_In all the examples below, `ipfs.runfission.com` is our IPFS gateway. You can use any public ipfs gateway -- or even your localhost gateway!_


```bash
fission watch
```

## Other neat things

### Serving individual files

Underneath an existing IPFS directory

```bash
open https://ipfs.runfission.com/ipfs/Qmerj2V9i7Qq4JKoM1pKtv1wDaRgcp3E6mMPcZEEBx5Uij/john.gif
```

On it's own:

```bash
fission up john.gif
open https://ipfs.runfission.com/ipfs/QmdHyoX2WaG9ud2zp9YmkK2HVw7UJkXJ3GViuFTVTCaHMX
```

### Serving directories

As soon as you remove your index.html file the folder is served as a browsable directory!

```bash
rm index.html
fission up
```

# Why Fission Live?

Remember when we could simply upload files over FTP and be in production? Deployment can be a complicated process that involves a lot of education and learning and decision making.

With Fission Live, we want to make it the fastest, most "batteries included" way of bringing your apps live, directly from your development environment. Using IPFS, we can use the p2p network to serve files directly from your dev environment, while our supported Fission servers "pin" your files so they remain online even when you close your laptop.

With DNS integration, you can have a "regular" Web2 domain name, which always has the latest version of your files streamed from your desktop.

Serve files as today's Web2 users expect, while also enabling native IPFS support as more and more users have it included by default. Brave, Opera, and the Chrome/Firefox/Edge [ipfs-companion extension](https://github.com/ipfs-shipyard/ipfs-companion#ipfs-companion) are a great way to experiment with native browser support today.

And -- stay tuned for our IPFS service worker that installs native IPFS support into local client browsers WITHOUT special browsers or extensions!

# Come see us at Diffusion

We'll be helping to run the IPFS Help Desk to lend a hand with all your IPFS and Fission Live questions. Stop by and see more demos that we're working on -- Fission Login, Fission DB, and more for completely decentralized apps served from your desktop.

[Join our Discord server to chat with us](https://fission.codes/discord), or leave a comment below if you have more questions or trouble with any of the setup.
