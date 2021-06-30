/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep.Graph;

public interface WeightedAdjacencyMatrix {
    void addNode(int node);

    void addEdge(int source, int destination, int weight);

    boolean isConnected(int source, int destination);

    int edgeWeight(int source, int destination);

    int numberOfNodes();

    int numberOfEdges();

    void printMatrix();
}
