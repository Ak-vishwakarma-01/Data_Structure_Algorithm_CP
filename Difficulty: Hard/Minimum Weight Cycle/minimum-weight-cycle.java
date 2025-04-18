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

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {

    public int findMinCycle(int v, int[][] edges) {
        List<int[]>[] adj = new ArrayList[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();

        
        for (int[] edge : edges) {
            int u = edge[0], d = edge[1], w = edge[2];
            adj[u].add(new int[]{d, w});
            adj[d].add(new int[]{u, w});
        }

        int minCycle = Integer.MAX_VALUE;

       
        for (int[] edge : edges) {
            int u = edge[0], d = edge[1], w = edge[2];

            int dist = dijkstra(u, d, adj, u, d); // find shortest path from u to d skipping edge (u-d)
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w); // add removed edge weight to complete the cycle
            }
        }

        return (minCycle == Integer.MAX_VALUE) ? -1 : minCycle;
    }

    private int dijkstra(int start, int end, List<int[]>[] adj, int skipU, int skipV) {
        int[] dist = new int[adj.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (node == end) return d;

            for (int[] nei : adj[node]) {
                int next = nei[0], weight = nei[1];

                if ((node == skipU && next == skipV) || (node == skipV && next == skipU)) continue;

                if (dist[next] > d + weight) {
                    dist[next] = d + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return Integer.MAX_VALUE; 
    }
}

