//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int[] dijkstra(int v, int[][] edges, int src) {
        // code here
        ArrayList<int[]> adj[] = new ArrayList[v];
        for(int i=0;i<v;i++) adj[i] = new ArrayList<>();
        for(int edg[]: edges){
            adj[edg[0]].add(new int[]{edg[1],edg[2]});
            adj[edg[1]].add(new int[]{edg[0],edg[2]});
        }
        Queue<int[]> q  = new LinkedList<>();
        q.add(new int[]{src,0});
        int lengths[] = new int[v];
        Arrays.fill(lengths,Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int de[] = q.peek();
            int node = de[0];
            int cost = de[1];
            q.poll();
            if(lengths[node]>cost){
                lengths[node] = cost;
                for(int child[]: adj[node]){
                    q.add(new int[]{child[0] , cost+child[1]});
                }
            }
        }
        return lengths;
    }
    
}