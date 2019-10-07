const Iota = require('@iota/core');
const Converter = require('@iota/converter');

// Create a new instance of the IOTA object
// Use the `provider` field to specify which IRI node to connect to
const iota = Iota.composeAPI({
    provider: 'https://nodes.devnet.iota.org:443'
});

// 81 char address
const address =
'ADDRESS-TO-SEND TO-81-CHARS';

// 81 char seed
const seed =
'YOUR-SEED-81-CHARS';

// A message to go with the transfer
const message = Converter.asciiToTrytes('Hello World!');
const transfers = [
    {
        value: 0, // Number of tokens
        address: address,
        message: message
    }
];

// Prepare the bundle
iota.prepareTransfers(seed, transfers)
    .then(trytes => {
        return iota.sendTrytes(trytes, 3/*depth*/, 9/*minimum weight magnitude*/)
    })
    .then(bundle => {
    console.log(`Bundle: ${JSON.stringify(bundle, null, 1)}`)
})
.catch(err => {
    // Catch any errors
    console.log(err);
});