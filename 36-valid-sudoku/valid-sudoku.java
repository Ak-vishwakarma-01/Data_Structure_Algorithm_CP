class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer,Set<Character>> col = new HashMap<>();
        Map<Integer,Set<Character>> row = new HashMap<>();
        Map<Integer,Set<Character>> sq = new HashMap<>();

        for(int i=0;i<n;i++){
            col.put(i,new HashSet<>());
            row.put(i,new HashSet<>());
            sq.put(i,new HashSet<>());
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                
                if(board[r][c]=='.') continue;

                if(col.get(c).contains(board[r][c])) return false;
                else col.get(c).add(board[r][c]);

                if(row.get(r).contains(board[r][c])) return false;
                else row.get(r).add(board[r][c]);

                if(sq.get((r/3*(n/3))+(c/3)).contains(board[r][c])) return false;
                else sq.get((r/3*(n/3))+(c/3)).add(board[r][c]);

            }
        }
        return true;
    }
}