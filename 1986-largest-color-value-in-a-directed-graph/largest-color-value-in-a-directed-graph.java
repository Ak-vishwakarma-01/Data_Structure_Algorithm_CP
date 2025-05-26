class Solution {
    boolean cycle = false;
    boolean[] visit;
    boolean[] instack;
    int ans = 0;

    private void dfs(int node, List<Integer>[] adj, char[] colors, int[][] count) {
        visit[node] = true;
        instack[node] = true;

        int colorIdx = colors[node] - 'a';
        count[node][colorIdx] = 1;

        for (int child : adj[node]) {
            if (instack[child]) {
                cycle = true;
                return;
            }
            if (!visit[child]) {
                dfs(child, adj, colors, count);
                if (cycle) return;
            }
            for (int i = 0; i < 26; i++) {
                int add = (i == colorIdx) ? 1 : 0;
                count[node][i] = Math.max(count[node][i], count[child][i] + add);
            }
        }

        instack[node] = false;

        for (int val : count[node]) {
            ans = Math.max(ans, val);
        }
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edg : edges) adj[edg[0]].add(edg[1]);

        visit = new boolean[n];
        instack = new boolean[n];
        int[][] count = new int[n][26]; // count[i][c]: max occurrences of char c at node i

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, adj, colors.toCharArray(), count);
                if (cycle) return -1;
            }
        }

        return ans;
    }
}
