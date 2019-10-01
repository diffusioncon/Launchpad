import { makeMint } from './ERTP/core/issuers';

const baytownBucksMint = makeMint('BaytownBucks');
const purse = baytownBucksMint.mint(1000, 'community treasury');