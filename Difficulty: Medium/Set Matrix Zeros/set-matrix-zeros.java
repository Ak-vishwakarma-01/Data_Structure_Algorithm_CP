class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] row0 = new int[n];
        int[] col0 = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    row0[i] = 1;
                    col0[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (row0[i] == 1) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (col0[j] == 1) {
                for (int i = 0; i < n; i++) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
