//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    private static void dfs(int node, List<Integer> adj[] , boolean visit[], Stack<Integer> st){
        
        visit[node] = true;
        for(int i: adj[node]){
            if(!visit[i]){
                dfs(i , adj, visit, st);
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(int n, int[][] edges) {
    List<Integer> adj[] = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    
    for (int edg[] : edges) {
        adj[edg[0]].add(edg[1]);
    }
    
    Stack<Integer> st = new Stack<>();
    boolean visit[] = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (!visit[i]) {
            dfs(i, adj, visit, st);
        }
    }
    
    ArrayList<Integer> ans = new ArrayList<>();
    while (!st.isEmpty()) {
        ans.add(st.pop());
    }
    
    return ans;
}

}