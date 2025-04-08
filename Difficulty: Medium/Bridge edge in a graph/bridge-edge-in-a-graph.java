//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    
    private boolean dfs(int node, int parent,  List<Integer> adj[], boolean visit[]){
        visit[node] = true;
        for(int child: adj[node]){
            if(child==parent) return true;
            if(!visit[child]){
               if(dfs(child, parent, adj, visit)) return true; 
            }
        }
        return false;
    }
    
    public boolean isBridge(int v, int[][] edges, int c, int d) {
        // code here
        boolean check = false;
        List<Integer> adj[] = new ArrayList[v];
        for(int i=0;i<v;i++) adj[i] = new ArrayList<>();
        for(int edge[]: edges){
            if((edge[0]==c && edge[1]==d) || (edge[0]==d && edge[1]==c)){
                check =  true;
            }else{
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }
        boolean visit[] = new boolean[v];
        
        if(dfs(c, d, adj, visit)) return false;
        
        return true;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends