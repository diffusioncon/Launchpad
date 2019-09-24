# FOAM
## `JavaScript`, `Haskell`, `PureScript`

Proof of location. A highly visual Convergence technology great for building map and location-focused apps.

To throw yourself in at the deep end, jump to the JavaScript API at the bottom.

## Points vs Signals

There are two key types of objects on the FOAM Map: Points and Signals.

Both types of objects added by FOAM Cartographers who must stake FOAM Tokens to make each object appear on the FOAM Map.

### Points

Points of Interest mark interesting places on the map, like local attractions or restaurants. Fields:
 - Name
 - Address
 - Description
 - Geohash (lat/long)
 - Owner
 - Stake
 - … and more

### Signals

Signals indicate demand for dynamic proof of location services. Fields:
 - Geohash (lat/long)
 - Owner
 - Stake
 - Creation date

### Registering points of interest and signals

You will need some FOAM tokens in MetaMask (or any other web3 browser wallet). Register points and singals at [map.foam.space](https://map.foam.space). 

Prototypes can be built using existing points of interest without the need for tokens using the map API (below).

### Map API

#### Example 1: search an area for Points

```
https://map-api-direct.foam.space/poi/map?swLng=-180&swLat=-90&neLng=180&neLat=90&sort=newest&limit=100&offset=0
```
Example response object:
```JSON
{"state":{"status":{"endDate":"2019-05-20T13:51:10Z","type":"applied"},"createdAt":"2019-05-17T13:51:10Z","deposit":"0x56bc75e2d63100000"},"listingHash":"0x076ed244d1eebd16219ba84df0c2467a1f1e930ffbe1e85ae7b61013bb8a8d11","owner":"0xe7518c7ea87d7e9ae3d81677b12e8e095c5205c2","geohash":"dr5rukudrr9e","name":"United States Postal Service","tags":["Government","Scavenger Hunt","Retail"]}
```

Key fields:
- createdAt - when the point was created - 2019-05-17T13:51:10Z
- geohash - location of the point (decode geohash to lat/long as needed) - dr5rukudrr9e
- listingHash - unique identifier of the point - 0x076ed244d1eebd16219ba84df0c2467a…
- owner - owner of the point - 0xe7518c7ea87d7e9ae3d81677b12e8e095c5205c2


#### Example 2: search an area for Signals
```
https://map-api-direct.foam.space/signal/map?swLng=-180&swLat=-90&neLng=180&neLat=90&sort=newest&limit=100&offset=0
```
Example response object:
```JSON
{"cst":"0x0661a22088f60194c64aeb4ff6dccf0c870b277db95111e17135140a7bbaebdb","createdAt":"2018-12-04T17:24:57Z","radius":"0x3e8","stake":"0x21e19e0c9bab2400000","tokenId":"0x1","owner":"0xab2a19c49ea7422b2889566b96767b67436f582e","geohash":"dr5rs8vrcqm5","nftAddress":"0x36f16a0d35b866cdd0f3c3fa39e2ba8f48b099d2"}
```

Key fields:
- geohash - location of the signal (decode to lat/long as needed) - dr5rs8vrcqm5
- radius - size of the signal (meters) - 0x3e8
- stake - tokens staked in the signal (18 decimals) - 0x21e19e0c9bab2400000
- owner - owner of the signal - 0xab2a19c49ea7422b2889566b96767b67436f582e

### JavaScript API

You can draw rich maps, including 3D and journeys between points, using the FOAM JavaScript API.

These require you to [register a MapBox account](https://account.mapbox.com/auth/signup/) and then get your access token [here](https://www.mapbox.com/install/js/cdn-add/).

To get started, paste your access token into each of the example files where indicated. *Never git commit an access token you intend to use in production! Load it in by other means, e.g. a header or `.js` file.*

Get started with points and 3D rendering in `points.html`.

Get started with journeys in `journey.html`.

Example hackathon submission: [key recovery using locations you remember](https://devpost.com/software/mapcovery).
