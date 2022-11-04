package DSA.Algorithms.Graphs;

import java.util.*;
import java.util.function.Predicate;

public class BFS {
    public static <T> boolean bfs(Map<T, List<T>> graph, T startingNode, Predicate<T> testFunc) {
        LinkedList<T> queue = new LinkedList<>(graph.get(startingNode));
        LinkedList<T> searched = new LinkedList<>();

        while (!queue.isEmpty()) {
            T item = queue.getFirst();
            queue.removeFirst();
            if (!searched.contains(item)) {
                if (testFunc.test(item)) {
                    return true;
                } else {
                    if (graph.get(item) != null) {
                        queue.addAll(graph.get(item));
                    }
                    searched.add(item);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("you", Arrays.asList("Peggi", "Ben", "Sven", "Pudge"));
        map.put("Ben", Arrays.asList("Dan", "Silvi", "Nell"));
        map.put("Sven", Arrays.asList("Tom", "Bred", "Angel"));

        Predicate<String> func = name -> name.equals("Peggi");

        System.out.println(bfs(map, "you", func));
    }
}
