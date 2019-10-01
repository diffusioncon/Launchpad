import { makeMint } from './ERTP/core/issuers';

// Create currency and mint 1M tokens
const token = makeMint('SafeToken');
const purse = token.mint(1000000, 'treasury');

// Send 10 tokens to Alice
const paymentForAlice = purse.withdraw(10, 'for alice');

/* Now all you have to do is pass the payment object to Alice, who
is also an object, as a message. Alice might implement her own
payment receipt method, so just call that method in your reference
to her and pass the payment object, e.g. alice.receive(payment). */

// Alice can verify the payment:
const verifiedPayment = token.claimAll(payment);

// Now, wasn't that simple?
