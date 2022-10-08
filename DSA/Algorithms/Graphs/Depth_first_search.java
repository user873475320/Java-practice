package DSA.Algorithms.Graphs;

import java.util.*;
import java.util.function.Predicate;

public class Depth_first_search {
    public static <T> void visit(T vertex) {
        System.out.print(vertex.toString() + " ");
    }

    public static <T> void dfs(Map<T, List<T>> graph, T vertex, Map<T, Boolean> marked) {
        visit(vertex);
        marked.put(vertex, true);

        if (graph.get(vertex) == null) {
            return;
        }

        for (var w : graph.get(vertex)) {
            if (marked.get(w) == null) {
                dfs(graph, w, marked);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("you", Arrays.asList("Peggi", "Ben", "Sven", "Pudge"));
        map.put("Ben", Arrays.asList("Dan", "Silvi", "Nell"));
        map.put("Sven", Arrays.asList("Tom", "Bred", "Angel"));

        Predicate<String> func = name -> name.equals("Peggi");

        HashMap<String, Boolean> marked = new HashMap<>();
        dfs(map, "you", marked);
    }
}
