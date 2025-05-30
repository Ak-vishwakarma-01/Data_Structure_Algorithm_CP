class Solution {

    private int dfs(int node, int level, ArrayList<Integer>[] adj, boolean[] visit) {
        visit[node] = true;
        int currans = level%2==0 ? 1 : 0;
        for (int child : adj[node]) {
            if (!visit[child]) {
                currans += dfs(child, level + 1, adj, visit);
            }
        }
        return currans ;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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

        // Maximum for tree 2
        int maxIn2ndTree = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(adj2[i].size()!=0){
                boolean[] visit = new boolean[m];
            
                int de = dfs(i, 1, adj2, visit); 
                maxIn2ndTree = Math.max(maxIn2ndTree, de);
                
                visit = new boolean[m];
                de = dfs(adj2[i].get(0), 1, adj2, visit); 
                maxIn2ndTree = Math.max(maxIn2ndTree, de);
                break;
            }
        }


        // even place maximum and odd place maximum for tree 1
        boolean[] visit = new boolean[n];
        int even = dfs(0, 0, adj1, visit); 
        visit = new boolean[n];
        int odd = dfs(adj1[0].get(0), 0, adj1, visit);


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int check = p.check;
            if(check==0) ans[node] = even + maxIn2ndTree;
            else ans[node] = odd + maxIn2ndTree;
            check = check==0?1:0;
            for(int child: adj1[node]){
                if(ans[child] == -1){
                    q.add(new Pair(child,check));
                }
            }
        }
        return ans;
    }
}

class Pair{
    int node;
    int check;
    public Pair(int node , int check){
        this.node =node;
        this.check = check;
    }
}
