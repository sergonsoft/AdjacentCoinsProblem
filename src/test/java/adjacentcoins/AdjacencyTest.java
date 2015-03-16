package adjacentcoins;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdjacencyTest {

    @Parameterized.Parameters
    public static Iterable<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{5}, {1, 1, 0, 1, 0, 0, 1, 1}},
                {{7}, {0, 0, 0, 0, 0, 0, 0, 0}},
                {{4}, {1, 1, 0, 0, 1, 0, 1, 0}},
                {{3}, {0, 1, 0, 0, 1, 0, 1, 0}},
                {{4}, {1, 0, 0, 0, 1, 0, 1, 0}}
        });
    }

    private int expectedAdjacency;
    private int[] coins;

    public AdjacencyTest(int[] expectedAdjacency, int[] coins) {
        this.expectedAdjacency = expectedAdjacency[0];
        this.coins = coins;

    }

    @Test
    public void testAdjacency() throws Exception {
        assertEquals(expectedAdjacency, Adjacency.adjacency(coins));
    }
}
