class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    private int bs(int upper, int l, int r, int[] pre) {
        int ans = l - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (pre[mid] > upper) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    private void dfs(int l, int r, int[] pre) {
        if (l == r) {
            ans.add(pre[l]);
            return;
        }
        if (l > r) return;
        int mostRight = bs(pre[l], l + 1, r, pre);
        dfs(l + 1, mostRight, pre);
        dfs(mostRight + 1, r, pre);
    }

    public ArrayList<Integer> leafNodes(int[] preorder) {
        int n = preorder.length;
        dfs(0, n - 1, preorder);
        return ans;
    }
}
