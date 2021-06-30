/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package IOI_Algorithm_prep.Graph;

import java.util.ArrayList;

public class WeightedUndirectedAdjacencyMatrix implements WeightedAdjacencyMatrix {
    private int edges = 0;

    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

    private void checkBounds(int parameter, int bound) {
        if (parameter >= bound) {
            throw new IllegalArgumentException();
        }
    }

    public void addNode(int node) {
        if (node <= 0) {
            throw new IllegalArgumentException("Illegal negative input value");
        }
        if (node > matrix.size()) {
            for (int i = 0; i < node; i++) {
                if (i == matrix.size()) {
                    matrix.add(new ArrayList<Integer>());
                }
                int nodesToAdd = (node - (matrix.get(i)).size());
                for (int j = 0; j < nodesToAdd; j++) {
                    matrix.get(i).add(0);
                }
            }
        }
    }

    public void addEdge(int source, int destination, int weight) {
        checkBounds(source, matrix.size());
        checkBounds(destination, matrix.size());
        matrix.get(source).set(destination, weight);
        matrix.get(destination).set(source, weight);
        edges++;
    }

    public boolean isConnected(int source, int destination) {
        checkBounds(source, matrix.size());
        checkBounds(destination, matrix.size());
        return matrix.get(source).get(destination) == 1;
    }

    public int edgeWeight(int source, int destination) {
        if (isConnected(source, destination)) {
            return matrix.get(source).get(destination);
        }
        throw new IllegalArgumentException("No edge exists");
    }

    public int numberOfNodes() {
        return matrix.size();
    }

    public int numberOfEdges() {
        return edges;
    }

    public void printMatrix() {
        for (ArrayList<Integer> a : matrix) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
