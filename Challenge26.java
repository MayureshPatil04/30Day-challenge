import java.util.*;

public class Challenge26 {
    public static int shortestPathLength(int V, int[][] edges, int start, int end) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (start == end) return 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test case 1
        int V1 = 5;
        int[][] edges1 = { {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4} };
        System.out.println(shortestPathLength(V1, edges1, 0, 4)); 
        // Test case 2
        int V2 = 3;
        int[][] edges2 = { {0, 1}, {1, 2} };
        System.out.println(shortestPathLength(V2, edges2, 0, 2));
        // Test case 3
        int V3 = 4;
        int[][] edges3 = { {0, 1}, {1, 2} };
        System.out.println(shortestPathLength(V3, edges3, 2, 3)); 
        // Edge case 1
        int V4 = 1;
        int[][] edges4 = {};
        System.out.println(shortestPathLength(V4, edges4, 0, 0)); 
        // Edge case 2
        int V5 = 2;
        int[][] edges5 = {};
        System.out.println(shortestPathLength(V5, edges5, 0, 1));
        // Edge case 3
        int V6 = 4;
        int[][] edges6 = { {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3} };
        System.out.println(shortestPathLength(V6, edges6, 0, 3)); 
    }
}