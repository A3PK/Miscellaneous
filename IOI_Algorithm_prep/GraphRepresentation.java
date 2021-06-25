package IOI_Algorithm_prep;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRepresentation {
    public interface AdjacencyMatrix {
        void addNode(int node);

        void addEdge(int source, int destination);

        boolean isConnected(int source, int destination);

        int numberOfNodes();

        int numberOfEdges();

        void printMatrix();
    }

    public static class UndirectedAdjacencyMatrix implements AdjacencyMatrix {
        private int edges = 0;

        private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        private void checkBounds(int parameter, int bound) {
            if (parameter >= bound) {
                throw new IllegalArgumentException();
            }
        }

        public void addNode(int node) {
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

        public void addEdge(int source, int destination) {
            checkBounds(source, matrix.size());
            checkBounds(destination, matrix.size());
            matrix.get(source).set(destination, 1);
            matrix.get(destination).set(source, 1);
            edges++;
        }

        public boolean isConnected(int source, int destination) {
            checkBounds(source, matrix.size());
            checkBounds(destination, matrix.size());
            return matrix.get(source).get(destination) == 1;
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

    public static class DirectedAdjacencyMatrix implements AdjacencyMatrix {
        private int edges = 0;

        private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        private void checkBounds(int parameter, int bound) {
            if (parameter >= bound) {
                throw new IllegalArgumentException();
            }
        }

        public void addNode(int node) {
            if (node > matrix.size()) {
                for (int i = 0; i < node; i++) {
                    if (i == matrix.size()) {
                        matrix.add(new ArrayList<Integer>());
                    }
                    int nope = (node - (matrix.get(i)).size());
                    for (int j = 0; j < nope; j++) {
                        matrix.get(i).add(0);
                    }
                }
            }
        }

        public void addEdge(int source, int destination) {
            checkBounds(source, matrix.size());
            checkBounds(destination, matrix.size());
            matrix.get(source).set(destination, 1);
            edges++;
        }

        public boolean isConnected(int source, int destination) {
            checkBounds(source, matrix.size());
            checkBounds(destination, matrix.size());
            return matrix.get(source).get(destination) == 1;
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

        public int outDegree(int node) {
            int degree = 0;
            for (int i : matrix.get(node)) {
                if (i > 0) {
                    degree++;
                }
            }
            return degree;
        }

        public int inDegree(int node) {
            int degree = 0;
            for (ArrayList<Integer> a : matrix) {
                if (a.get(node) > 0) {
                    degree++;
                }
            }
            return degree;
        }
    }

    public static class BFS {

        // module partially cleaned
        // 40% clean : clean later
        public static ArrayList<Integer> pathToNode(AdjacencyMatrix matrix, int rt, int node) {
            ArrayList<Integer> path = new ArrayList<>();
            int currNode = rt;
            boolean[] visitedNodes = new boolean[matrix.numberOfNodes()];
            Arrays.fill(visitedNodes, false);
            int[] parentOfNode = new int[matrix.numberOfNodes()];
            parentOfNode[rt] = -1;
            Queue<Integer> nodesToVisit = new LinkedList<Integer>();
            while (currNode != node) {
                for (int nodeBeingConsidered = 0; nodeBeingConsidered < matrix.numberOfNodes();
                     nodeBeingConsidered++) {
                    if (matrix.isConnected(currNode, nodeBeingConsidered)
                            && !visitedNodes[nodeBeingConsidered]) {
                        nodesToVisit.add(nodeBeingConsidered);
                        parentOfNode[nodeBeingConsidered] = currNode;
                        visitedNodes[nodeBeingConsidered] = true;
                    }
                }
                if (nodesToVisit.isEmpty()) {
                    throw new RuntimeException("No path to node");
                }
                currNode = nodesToVisit.remove();
            }
            parentOfNode[rt] = -1;
            while (currNode != -1) {
                System.out.println(currNode);
                path.add(currNode);
                currNode = parentOfNode[currNode];
            }
            return path;
        }
    }

    public static class DFS {
        public static ArrayList<Integer> pathToNode(AdjacencyMatrix matrix, int rt, int node) {
            ArrayList<Integer> path = new ArrayList<>();
            int currNode = rt;
            boolean[] visitedNodes = new boolean[matrix.numberOfNodes()];
            Arrays.fill(visitedNodes, false);
            int[] parentOfNode = new int[matrix.numberOfNodes()];
            parentOfNode[rt] = -1;
            Stack<Integer> nodesToVisit = new Stack<Integer>();
            while (currNode != node) {
                for (int nodeBeingConsidered = 0; nodeBeingConsidered < matrix.numberOfNodes();
                     nodeBeingConsidered++) {
                    if (matrix.isConnected(currNode, nodeBeingConsidered)
                            && !visitedNodes[nodeBeingConsidered]) {
                        nodesToVisit.push(nodeBeingConsidered);
                        parentOfNode[nodeBeingConsidered] = currNode;
                        visitedNodes[nodeBeingConsidered] = true;
                    }
                }
                if (nodesToVisit.isEmpty()) {
                    throw new RuntimeException("No path to node");
                }
                currNode = nodesToVisit.pop();
            }
            parentOfNode[rt] = -1;
            while (currNode != -1) {
                System.out.println(currNode);
                path.add(currNode);
                currNode = parentOfNode[currNode];
            }
            return path;
        }
    }

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
        System.out.println(BFS.pathToNode(a, 0, 5));
    }
}
