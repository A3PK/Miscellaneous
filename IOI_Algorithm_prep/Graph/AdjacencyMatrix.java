/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep.Graph;

public interface AdjacencyMatrix {
    void addNode(int node);

    void addEdge(int source, int destination);

    boolean isConnected(int source, int destination);

    int numberOfNodes();

    int numberOfEdges();

    void printMatrix();

    Iterable<Integer> connectedEdges(int node);
}
