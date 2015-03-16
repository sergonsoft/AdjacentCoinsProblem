package adjacentcoins;

/*

Consider N coins aligned in a row. Each coin is showing either heads
or tails. The adjacency of these coins is the number of adjacent pairs
of coins with the same side facing up.
Write a solution that, given a non-empty zero-indexed array A
consisting of N integers representing the coins, returns the maximum
possible adjacency that can be obtained by reversing exactly one coin
(that is, one of the coins must be reversed). Consecutive elements of
array A represent consecutive coins in the row. Array A contains only
0s and/or 1s:

0 represents a coin with heads facing up;
1 represents a coin with tails facing up.

For example, given array A consisting of eight numbers, such that:
  A[0] = 1
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 0
  A[5] = 0
  A[6] = 1
  A[7] = 1
----------------
Don't destroy these
(0,1)
(4,5)
(6,7)
---------------
Flip the rest...

------------------
  A[0] = 1
  A[1] = 1
  A[2] = 1
  A[3] = 1
  A[4] = 0
  A[5] = 0
  A[6] = 1
  A[7] = 1
the function should return 5. The initial adjacency is 3, as there are
three pairs of adjacent coins with the same side facing up, namely (0,
1), (4, 5) and (6, 7). After reversing the coin represented by A[2],
the adjacency equals 5, as there are five pairs of adjacent coins with
the same side facing up, namely: (0, 1), (1, 2), (2, 3), (4, 5) and
(6, 7), and it is not possible to obtain a higher adjacency.
The same adjacency can be obtained by reversing the coin represented
by A[3].
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage
(not counting the storage required for input arguments).
 */

/**
 * @author sergonsoft gmail
 */

public class Adjacency {
    public static int adjacency(int[] A) {

        int pairsFound = 0;
        int maxPairsAfterFlip = 0;

        final int lastItemIndex = A.length - 1;

        for (int i = 1; i < A.length; i++) {
            if (isPair(A[i-1], A[i])) {
                pairsFound++;
            }
            else {
                final int reversedCoin = reverseCoin(A[i]);
                if (lastItemIndex == i) { // is last array's item
                    if (isPair(A[i-1], reversedCoin)) {
                        maxPairsAfterFlip = max(maxPairsAfterFlip, 1);
                    }
                }
                else {
                    if (isTwoPairs(A[i-1], reversedCoin, A[i+1])) {
                        maxPairsAfterFlip = max(maxPairsAfterFlip, 2);
                    }
                    else if (isPair(A[i-1], reversedCoin)) {
                        maxPairsAfterFlip = max(maxPairsAfterFlip, 1);
                    }
                }
            }
        }

        return pairsFound + maxPairsAfterFlip;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int reverseCoin(int i) {
        return i == 0 ? 1 : 0;
    }

    private static boolean isPair(int a, int b) {
        return a == b;
    }

    private static boolean isTwoPairs(int a, int b, int c) {
        return a == b && b == c;
    }
}
