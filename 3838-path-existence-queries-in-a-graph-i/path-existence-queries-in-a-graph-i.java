
class DSU{
    int components;
    int parent[];
    int rank[];

    public DSU(int n){
        components = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    void union(int x, int y){
        int xp = find(x);
        int yp = find(y);

        if(xp==yp) return;
        if(rank[xp]>rank[yp]){
            parent[yp] = xp;
        }else if(rank[xp]<rank[yp]){
            parent[xp] = yp;
        }else{
            parent[yp] = xp;
            rank[xp]++;
        }

        components--;
    }

}

class Solution {


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int len = nums.length;
        if (len < 2) {
            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                if (queries[i][0] == queries[i][1]) ans[i] = true;
            }
            return ans;
        }

        DSU dsu = new DSU(n);

        int i = 0, j = 1;
        while (i < len && j < len) {
            int diff = Math.abs(nums[i] - nums[j]);
            if (diff <= maxDiff) {
                dsu.union(i, j);
                j++;
            } else {
                i++;
                if (i == j) j++;
            }
        }

        len = queries.length;
        boolean ans[] = new boolean[len];
        for (i = 0; i < len; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                ans[i] = true;
                continue;
            }
            int up = dsu.find(u);
            int vp = dsu.find(v);
            if(up==vp) ans[i] = true;
        }
        return ans;
    }

}
