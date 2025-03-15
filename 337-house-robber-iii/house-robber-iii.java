import java.util.*;

class Solution {
    Map<TreeNode, int[]> dp; // roobed value , notroobedvalue;

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0,0};
        if(dp.containsKey(root)) return dp.get(root);
        int left[] = dfs(root.left);   // robbed, notrobbed
        int right[] = dfs(root.right); // robbed, notrobbed
        
        int robbed = root.val + left[1] + right[1]; //we can not take the robbed left and robbed right
        int notrobbed = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        dp.put(root, new int[]{robbed, notrobbed});
        return new int[]{robbed, notrobbed};
    }

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        dp = new HashMap<>();
        int de[] = dfs(root);
        return Math.max(de[0],de[1]);
    }
}
