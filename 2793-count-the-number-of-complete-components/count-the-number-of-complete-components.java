class Pair<T,S>{
    T nodes;
    S adj;
    public Pair(T nodes,S adj){
        this.nodes = nodes;
        this.adj = adj;
    }
}
class Solution{
    private Pair<Integer, Integer> dfs(int node, List<Integer> adj[], boolean visit[]) {
        visit[node] = true;
        int nodes = 1;
        int adja = 0;

        for (int nod : adj[node]) {
            adja++;  
            if (visit[nod]) continue; 
            Pair<Integer, Integer> p = dfs(nod, adj, visit);
            nodes += p.nodes;
            adja += p.adj;
            
        }
        return new Pair<>(nodes, adja);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        for(int i[]:edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        boolean visit[] = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            Pair<Integer, Integer> de = dfs(i, adj, visit);
            int totalEdges = de.adj / 2; 
            if (totalEdges == de.nodes * (de.nodes - 1) / 2) ans++;
            
        }
        return ans;
    }
}