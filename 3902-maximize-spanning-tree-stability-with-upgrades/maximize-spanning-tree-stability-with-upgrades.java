class Solution {
    int n;
    DSU spanDsu;

    private boolean cycle(int mid, int[][] edges, int k) {

    spanDsu = new DSU(n);
    List<int[]> candidates = new ArrayList<>();
    int upgrades = 0;

    for (int edge[] : edges) {

        int u = edge[0];
        int v = edge[1];
        int st = edge[2];
        int must = edge[3];

        if (must == 1) {

            if (st < mid)
                return false;

            spanDsu.union(u, v);
        }

        else {

            if (st >= mid) {
                spanDsu.union(u, v);
            }
            else if (st * 2 >= mid) {
                candidates.add(new int[]{u, v});
            }
        }
    }

    for (int edg[] : candidates) {

        int s = edg[0];
        int d = edg[1];

        if (spanDsu.find(s) != spanDsu.find(d)) {

            if (upgrades >= k)
                return false;

            spanDsu.union(s, d);
            upgrades++;
        }
    }

    return spanDsu.components == 1;
}

    public int maxStability(int n, int[][] edges, int k) {
        this.n = n;
        DSU de = new DSU(n);
        for (int edge[] : edges) {
            int s = edge[0];
            int d = edge[1];
            int strength = edge[2];
            int must = edge[3];
            if(must==1){
                if(de.union(s,d)==false) return -1;
            }
        }
        int l = 0, r = 200000;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (cycle(mid,edges,k)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

class DSU {
    int rank[];
    int parent[];
    int components;
    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        Arrays.fill(rank,1);
        components=n;
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp)
            return false;

        if (rank[xp] > rank[yp]) {
            parent[yp] = xp;
        } else if (rank[yp] > rank[xp]) {
            parent[xp] = yp;
        } else {
            parent[xp] = yp;
            rank[yp]++;
        }
        components--;
        return true;
    }
}