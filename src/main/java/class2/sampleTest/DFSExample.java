package class2.sampleTest;

import java.util.*;

public class DFSExample {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());
    }

    // 1. Recursive DFS
    public static void dfsRecursive(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        System.out.println(node); // process node
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            dfsRecursive(neighbor, visited);
        }
    }

    // 2. Iterative DFS with Stack
    public static void dfsIterative(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                System.out.println(node); // process node
                visited.add(node);

                // push neighbors in reverse to match recursive order
                List<Integer> neighbors = graph.get(node);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Recursive DFS:");
        dfsRecursive(1, new HashSet<>());

        System.out.println("\nIterative DFS:");
        dfsIterative(1);
    }
}