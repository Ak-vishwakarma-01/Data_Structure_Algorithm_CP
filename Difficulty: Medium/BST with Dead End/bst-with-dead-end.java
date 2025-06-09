/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    Set<Integer> seenNode ;
    private boolean dfs(Node root, int min, int max){
        seenNode.add(root.data);
        if(root.left==null && root.right==null){
            for(int i=min;i<=max;i++){
                if(!seenNode.contains(i)) return false;
            }
            return true;
        }
        boolean result = false;
        if(root.left!=null) result = dfs(root.left, min, Math.min(max,root.data));
        if(root.right!=null) result = dfs(root.right, Math.max(min, root.data), max) || result ? true : false;
        return result;
    }
    public boolean isDeadEnd(Node root) {
        // Code here.
        seenNode = new HashSet<>();
        return dfs(root, 1, 100000);
        
    }
}