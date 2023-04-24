package algorythms;

import java.util.Map;
import java.util.Objects;

public class Graph<T> {
    T val;
    Map<Graph<T>, Integer> neighbors;

    public Graph(T val, Map<Graph<T>, Integer> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public T getVal() {
        return val;
    }

    public Map<Graph<T>, Integer> getNeighbors() {
        return neighbors;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public void setNeighbors(Map<Graph<T>, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph<?> graph = (Graph<?>) o;
        return val.equals(graph.val) && Objects.equals(neighbors, graph.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, neighbors);
    }
}
