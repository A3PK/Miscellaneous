/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep.GraphTests;

import IOI_Algorithm_prep.Graph.AdjacencyMatrix;
import IOI_Algorithm_prep.Graph.UndirectedAdjacencyMatrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class GeneralAdjacencyMatrixTest {
    private AdjacencyMatrix adjacencyMatrix;

    @BeforeEach
    public void setUp() {
        adjacencyMatrix = new UndirectedAdjacencyMatrix();
    }

    @Test
    @DisplayName("Adding nodes should work")
    public void testNodeAddition() {
        adjacencyMatrix.addNode(10);
        assertEquals(10, adjacencyMatrix.numberOfNodes(),
                     "Node addition should work first");
    }

    @Test
    @DisplayName("Adding edges should work")
    public void testEdgeAddition() {
        adjacencyMatrix.addNode(10);
        adjacencyMatrix.addEdge(5, 6);
        assertTrue(adjacencyMatrix.isConnected(5, 6), "Edge addition is essential");
    }

    @Test
    @DisplayName("Iterator should return all connected nodes")
    public void testConnectedNodeIterator() {
        adjacencyMatrix.addNode(10);
        adjacencyMatrix.addEdge(0, 5);
        adjacencyMatrix.addEdge(0, 8);
        adjacencyMatrix.addEdge(0, 3);
        adjacencyMatrix.addEdge(0, 4);
        adjacencyMatrix.addEdge(4, 5);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : adjacencyMatrix.connectedEdges(0)) {
            arr.add(i);
        }
        assertArrayEquals(arr.stream().mapToInt(i -> i).toArray(), new int[] { 3, 4, 5, 8 },
                          "Iterator failed to return correct nodes");
    }

    @Test
    @DisplayName("Node addition should throw an exception on illegal values")
    public void testNodeAdditionWithIllegalValues() {
        try {
            adjacencyMatrix.addNode(-5);
            fail("Did not throw IllegalArgumentException");
        }
        catch (IllegalArgumentException i) {
            // yay, the test passed!
        }
    }

    @Test
    @DisplayName("Edge addition should throw an exception on illegal values")
    public void testEdgeAdditionWithIllegalValues() {
        try {
            adjacencyMatrix.addNode(20);
            adjacencyMatrix.addEdge(-1, 19);
            fail("Did not throw Exception");
        }
        catch (Exception i) {
            // ignored
        }
    }

}
