class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int ans[] = new int[friends.length];
        Set<Integer> fr = new HashSet<>();
        for(int i: friends) fr.add(i);
        int i = 0;
        for(int j: order){
            if(fr.contains(j)){
                ans[i++] = j;
            }
        }
        return ans;
    }
}