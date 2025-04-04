//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean[] visit) {
        visit[node] = true;

        for (int neighbor : adj[node]) {
            if (!visit[neighbor]) {
                if (dfs(neighbor, node, adj, visit)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int v, int[][] edges) {
        boolean[] visit = new boolean[v];
        List<Integer>[] adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                if (dfs(i, -1, adj, visit)) {
                    return true;
                }
            }
        }

        return false;
    }
}
