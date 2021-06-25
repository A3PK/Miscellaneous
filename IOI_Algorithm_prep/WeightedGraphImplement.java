package IOI_Algorithm_prep;

import java.util.HashMap;
import java.util.HashSet;

class WeightedGraphImplement<T> {
    HashMap<T, HashSet<Pair<T, Integer>>> vertices = new HashMap<>();
    HashMap<Pair<T, T>, Integer> edges = new HashMap<>();

    private class Pair<P, U> {
        P first;
        U second;

        public Pair(P f, U s) {
            first = f;
            second = s;
        }
    }

    public void addVertex(T n) {
        if (vertices.containsKey(n)) {
            throw new IllegalArgumentException("This key already exists.");
        }
        vertices.put(n, new HashSet<>());
    }

    public void addWeightedEdge(T source, T destination, int weight) {
        if (vertices.containsKey(source) && vertices.containsKey(destination) && weight > 0) {
            vertices.get(source).add(new Pair<T, Integer>(destination, weight));
            vertices.get(destination).add(new Pair<T, Integer>(source, weight));
            edges.put(new Pair<T, T>(source, destination), weight);
        }
        else if (weight < 0) {
            throw new IllegalArgumentException("Weight may not be negative");
        }
        else {
            throw new IllegalArgumentException("Source or Destination not present");
        }
    }


    public static void main(String[] args) {

    }
}
