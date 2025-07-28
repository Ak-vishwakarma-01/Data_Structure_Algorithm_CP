class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length; // fixed: use mat[0].length instead of mat.length
        int max = 0;

        for (int i = 0; i < n; i++) {
            int lmax = 0;
            for (int j = 0; j < m; j++) {
                lmax += mat[i][j];
            }
            max = Math.max(max, lmax);
        }

        for (int i = 0; i < m; i++) {
            int lmax = 0;
            for (int j = 0; j < n; j++) { 
                lmax += mat[j][i];
            }
            max = Math.max(max, lmax);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int lmax = 0;
            for (int j = 0; j < m; j++) {
                lmax += mat[i][j];
            }
            ans += max - lmax;
        }

        return ans;
    }
}
