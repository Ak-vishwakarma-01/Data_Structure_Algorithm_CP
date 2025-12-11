class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        List<Integer>[] rowlist = new ArrayList[n+1];
        List<Integer>[] collist = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            rowlist[i] = new ArrayList<>();
            collist[i] = new ArrayList<>();
        }

        for (int[] par : buildings) {
            int r = par[0];
            int c = par[1];
            rowlist[r].add(c); 
            collist[c].add(r); 
        }


        for (int i = 0; i <= n; i++) {
            Collections.sort(rowlist[i]);
            Collections.sort(collist[i]);
        }

        int ans = 0;
        for (int[] par : buildings) {
            int r = par[0];
            int c = par[1];

            if (rowlist[r].get(0) < c && rowlist[r].get(rowlist[r].size() - 1) > c
             && collist[c].get(0) < r && collist[c].get(collist[c].size() - 1) > r) {
                ans++;
            }
        }
        return ans;
    }
}
