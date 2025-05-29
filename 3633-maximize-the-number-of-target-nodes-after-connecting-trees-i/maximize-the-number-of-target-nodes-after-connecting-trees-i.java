class Solution {

    private int dfs(int node, int level, int k, ArrayList<Integer>[] adj, boolean[] visit) {
        if(level>k) return 0;
        visit[node] = true;
        int currans = 0;
        for (int child : adj[node]) {
            if (!visit[child]) {
                currans += dfs(child, level + 1, k, adj, visit);
            }
        }
        return currans + 1;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = 0, m = 0;
        for (int[] edg : edges1)
            n = Math.max(n, Math.max(edg[0], edg[1]));
        for (int[] edg : edges2)
            m = Math.max(m, Math.max(edg[0], edg[1]));

        n++;
        m++;

        ArrayList<Integer>[] adj1 = new ArrayList[n];
        ArrayList<Integer>[] adj2 = new ArrayList[m];

        for (int i = 0; i < n; i++)
            adj1[i] = new ArrayList<>();
        for (int i = 0; i < m; i++)
            adj2[i] = new ArrayList<>();

        for (int[] edg : edges1) {
            adj1[edg[0]].add(edg[1]);
            adj1[edg[1]].add(edg[0]);
        }
        for (int[] edg : edges2) {
            adj2[edg[0]].add(edg[1]);
            adj2[edg[1]].add(edg[0]);
        }

        int maxIn2ndTree = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            boolean[] visit = new boolean[m];
            int de = dfs(i, 1, k, adj2, visit); 
            maxIn2ndTree = Math.max(maxIn2ndTree, de);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++) {
            boolean[] visit1 = new boolean[n];
            int de = dfs(i, 0, k, adj1, visit1); 
            ans[i] = de + maxIn2ndTree;
        }

        return ans;
    }

}
