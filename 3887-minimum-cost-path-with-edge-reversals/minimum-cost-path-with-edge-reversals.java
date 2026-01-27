class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        for(int ed[]: edges){
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,2*w});
        }   
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(0);
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            int w = dist[node];
            for(int edge[]: adj[node]){
                int point = edge[0];
                int we = edge[1];
                if((w+we)<dist[point]){
                    dist[point] = w+we;
                    q.add(point);
                }
            }
        }
        if(dist[n-1]==Integer.MAX_VALUE) return -1;
        return dist[n-1];
    }
}