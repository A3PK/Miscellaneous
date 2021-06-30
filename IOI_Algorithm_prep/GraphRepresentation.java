package IOI_Algorithm_prep;

import IOI_Algorithm_prep.Graph.AdjacencyMatrix;
import IOI_Algorithm_prep.Graph.DirectedAdjacencyMatrix;
import edu.princeton.cs.algs4.StdRandom;

public class GraphRepresentation {
    public static void main(String[] args) {
        AdjacencyMatrix a
                = new DirectedAdjacencyMatrix();
        a.addNode(5);
        a.addNode(1);
        a.addNode(7);
        for (int i = 0; i < 16; i++) {
            a.addEdge(StdRandom.uniform(6), StdRandom.uniform(6));
        }
        a.printMatrix();
    }
}
