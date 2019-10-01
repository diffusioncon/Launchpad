# Rightmesh
## Java, Kotlin

Mesh networking. Excellent for building edge network applications.

[GitHub](https://github.com/rightmesh) - [Website](https://www.rightmesh.io/) - [Docs](https://developer.rightmesh.io/) - [Chat](https://web.telegram.org/#/im?p=@RightMesh_Official)

## Requirements

- Java 8

You can use this [prebuilt Ubuntu + Java Docker environment](https://github.com/RightMesh/docker-ubuntu-openjdk) for developing with Rightmesh.

Before going into code, you will need a developer account and API key from the Rightmesh [developer site](https://developer.rightmesh.io/).

## Get started

You will need a _superpeer_ (node) running to facilitate the network: [install from here](https://github.com/RightMesh/Superpeer).

RightMesh abstracts away the idea of IPv4, IPv6 addresses, MAC addresses etc., since any given device may have any number of connections into the mesh at a given moment. Instead every device has a MeshID which is used in place of these other types of addresses.

If you have an internet connection, your program will connect to a RightMesh superpeer and discover peers around the world who are also connected to a superpeer.

At this time, the Java library does not automatically join the local mesh network so it is up to the developer to manually join the network with the device the Java code is running on. For testing purposes you should be able to join any WiFi network being broadcast by a phone running RightMesh with an SSID following the pattern RM-XXXXXX using the password `m3sht3st`.

## Desktop

Rightmesh runs on any Java-supporting platform, including the Raspberry Pi. Check out the `Desktop` folder and see `build.gradle` in each for integrating with your own apps.

Use: `./gradlew installDist` `./gradlew run` or `./build/install/HelloJavaMesh/bin/HelloJavaMesh`

## Android

An android app is packaged in the `Android` folder (Java) and in th `Android-Kotlin` folder (Kotlin). See `build.gradle` for integrating with your own apps.

Use: `./gradlew installDist` `./gradlew run`


