//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution{
    private void dfs(int node, List<Integer>[] adj, boolean visited[]){
        visited[node] = true;
        for(int nodes: adj[node]){
            if(visited[nodes]) continue;
            dfs(nodes, adj, visited);
        }
    }
    private boolean isConnected(int n, List<Integer>[] adj){
        int indegree = -1;
        for(int i=0;i<n;i++){
            if(adj[i].size()>0){
                indegree = i;
                break;
            }
        }
        boolean visited[] = new boolean[n];
        dfs(indegree , adj, visited);
        
        for(int i=0;i<n;i++){
            if(visited[i]==false && adj[i].size()>0) return false;
        }
        return true;
    }
    public int isEulerCircuit(int v, List<Integer>[] adj) 
    {
        if(isConnected(v, adj)==false) return 0;
        
        int oddDegree = 0;
        for(int i=0;i<v;i++){
            if(adj[i].size()%2!=0) oddDegree++;
        }
        
        if(oddDegree>2) return 0;
        
        if(oddDegree==2) return 1;
        
        return 2;
            
    }
}