import java.util.*;

public class Challenge25 {

    public static boolean hasCycle(int V, List<int[]> edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Use a set to handle parallel edges directly
        Set<String> edgeSet = new HashSet<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // If parallel edge already exists, cycle of length 2 exists
            String key1 = u + "," + v;
            String key2 = v + "," + u;

            if (edgeSet.contains(key1) || edgeSet.contains(key2)) {
                return true;
            }

            edgeSet.add(key1);
            edgeSet.add(key2);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check each connected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited neighbor that is not parent means cycle
                return true;
            }
        }

        return false;
    }

    // Driver code for testing
    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2},
            new int[]{2, 3},
            new int[]{3, 4},
            new int[]{4, 0}
        );
        System.out.println("Test 1: " + hasCycle(5, edges1)); // true

        List<int[]> edges2 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2}
        );
        System.out.println("Test 2: " + hasCycle(3, edges2)); // false

        List<int[]> edges3 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2},
            new int[]{2, 0}
        );
        System.out.println("Test 3: " + hasCycle(4, edges3)); // true

        List<int[]> edges4 = new ArrayList<>();
        System.out.println("Test 4 (no edges): " + hasCycle(3, edges4)); // false

        List<int[]> edges5 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 0}
        );
        System.out.println("Test 5 (parallel edges): " + hasCycle(2, edges5)); // true
    }
}
