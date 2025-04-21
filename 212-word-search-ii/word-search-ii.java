class Solution {

    class Trie{
        boolean endsWith;
        Trie children[] = new Trie[26];
        String word = null;
    }

    private void insert(Trie root, String word){
        Trie iter = root;
        for(char check: word.toCharArray()){
            int ch = check - 'a';
            if(iter.children[ch]==null){
                iter.children[ch] = new Trie();
            }
            iter = iter.children[ch];
        }
        iter.word = word;
        iter.endsWith = true;
    }
    boolean visited[][]; 
    private void dfs(int i, int j, char [][]board, Trie root,List<String> ans,  int r, int c){
        if(i<0 || i>=r || j<0 || j>=c || visited[i][j]) return;
        if(root.endsWith==true){
            ans.add(new String(root.word));
            root.endsWith= false; // the reason
        }
        int ch = board[i][j] - 'a';
        if(root.children[ch]==null)return;
        if(root.children[ch].endsWith){
            ans.add(new String(new String(root.children[ch].word)));
            root.children[ch].endsWith = false;
        }
        visited[i][j]=true;
        //top
        dfs(i-1, j, board,root.children[ch], ans, r, c);
        //right
        dfs(i, j+1, board,root.children[ch], ans, r, c);
        //bottom
        dfs(i+1, j, board,root.children[ch], ans, r, c);
        //left
        dfs(i, j-1, board,root.children[ch], ans, r, c);
        visited[i][j] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word: words){
            insert(root, word);
        }
        int r = board.length;
        int c = board[0].length;
        List<String> ans = new ArrayList<>();
        visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(i, j, board, root, ans, r,c);
            }
        }
        return ans;
    }
}