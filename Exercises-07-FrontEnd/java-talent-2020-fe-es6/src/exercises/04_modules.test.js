import * as Mathy from '../common/Mathy';
import * as IndexImport from '../common/index';
import {sqrt as mySqrt, square as mySquare} from "../common/Mathy";
import  lodash from 'lodash';
// WRITE YOUR IMPORT STATEMENTS HERE

test('can import Mathy', () => {
    // this one's already done! You're welcome :)
    expect(Mathy.sqrt)
        .toBeDefined();
    expect(Mathy.square)
        .toBeDefined();
    expect(Mathy.diag)
        .toBeDefined();
});

test('can specify what to import, to only retain pieces of the import', () => {
    // Import `Mathy` again, but pull out only the `sqrt` as mySqrt, and `square` as mySquare
    expect(mySqrt)
        .toBeDefined();
    expect(mySquare)
        .toBeDefined();
    expect(mySqrt)
        .toBe(Mathy.sqrt);
    expect(mySquare)
        .toBe(Mathy.square);
});

test('can import from my node_modules', () => {
    // import `lodash`
    expect(lodash)
        .toBeDefined();
});

test('Index import', () => {
    //I have noticed that using index.js is pretty common pattern
    //If someone has been confused about that maybe this helps
    expect(IndexImport.variable1)
        .toBe('John');
    expect(IndexImport.variable2)
        .toBe('Doe');
    expect(IndexImport.variable3)
        .toBe(222);
    expect(IndexImport.variable4)
        .toBe(false);
});
