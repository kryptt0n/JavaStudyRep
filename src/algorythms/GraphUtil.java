package algorythms;

import java.util.*;

public class GraphUtil {

    public static <T> void printWide(Graph<T> graph) {
        HashSet<Graph<T>> visited = new HashSet<>();
        Queue<Graph<T>> graphs = new ArrayDeque<>();
        graph.neighbors.forEach((key, value) -> graphs.offer(key));
        System.out.println(graph.getVal());
        visited.add(graph);
        while (!graphs.isEmpty()) {
            Graph<T> local = graphs.poll();
            if (visited.contains(local))
                continue;
            System.out.println(local.getVal());
            visited.add(local);
            Map<Graph<T>, Integer> map = local.getNeighbors();
            if (map == null)
                continue;
            local.getNeighbors().forEach((key, value) -> graphs.offer(key));
        }

    }

    public static <T> void printDeep(Graph<T> graph) {
        HashSet<Graph<T>> visited = new HashSet<>();
        Deque<Graph<T>> graphs = new ArrayDeque<>();
        graph.neighbors.forEach((key, value) -> graphs.push(key));
        System.out.println(graph.getVal());
        visited.add(graph);
        while (!graphs.isEmpty()) {
            Graph<T> local = graphs.pop();
            if (visited.contains(local))
                continue;
            System.out.println(local.getVal());
            visited.add(local);
            Map<Graph<T>, Integer> map = local.getNeighbors();
            if (map == null)
                continue;
            local.getNeighbors().forEach((key, value) -> graphs.push(key));
        }
    }
}
