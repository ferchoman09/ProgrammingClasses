package class2.sampleTest;

import java.util.*;

public class BFSExample {
    // Representamos el grafo como lista de adyacencia
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Agregar arista (grafo no dirigido para este ejemplo)
    public void addEdge(int src, int dest) {
        graph.putIfAbsent(src, new ArrayList<>());
        graph.putIfAbsent(dest, new ArrayList<>());
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    // BFS desde un nodo inicial
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();  // Para no visitar dos veces
        Queue<Integer> queue = new LinkedList<>(); // Cola para BFS

        visited.add(start);
        queue.offer(start);

        System.out.println("Recorrido BFS desde " + start + ":");

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Sacamos de la cola
            System.out.print(node + " ");

            // Visitamos todos los vecinos
            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSExample g = new BFSExample();

        // Creamos un grafo simple
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);

        // BFS desde el nodo 1
        g.bfs(1);
    }
}