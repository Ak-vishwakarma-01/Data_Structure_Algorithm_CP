class Solution {
    
    private int trailingZeros(int[] row, int n) {
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (row[i] == 0) count++;
            else break;
        }
        return count;
    }
    
    private int findrow(int from, int[][] grid, int n) {
        for (int row = from; row < n; row++) {
            int zeros = trailingZeros(grid[row], n);
            if (zeros >= n - from - 1) {
                return row;
            }
        }
        return -1;
    }
    
    private int swap(int row_num, int from, int[][] grid) {
        int swaps = 0;
        while (row_num > from) {
            int[] temp = grid[row_num];
            grid[row_num] = grid[row_num - 1];
            grid[row_num - 1] = temp;
            row_num--;
            swaps++;
        }
        return swaps;
    }
    
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int row_number = findrow(i, grid, n);
            if (row_number == -1) return -1;
            
            count += swap(row_number, i, grid);
        }
        
        return count;
    }
}