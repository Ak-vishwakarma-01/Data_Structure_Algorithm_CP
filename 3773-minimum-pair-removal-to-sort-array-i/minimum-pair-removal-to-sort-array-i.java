class Solution {
    private boolean isSorted(List<Integer> de){
        int n = de.size();
        for(int i=1;i<n;i++){
            if(de.get(i)<de.get(i-1)) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int de : nums) li.add(de);
        int ans = 0;
        while(!isSorted(li)){
            int n = li.size();
            int min = Integer.MAX_VALUE;
            int ind = -1;
            for(int i=0;i<n-1;i++){
                int curr = li.get(i)+li.get(i+1);
                if(curr<min){
                    min = curr;
                    ind = i;
                }
            }
            li.remove(ind+1);
            li.set(ind,min);
            ans++;
        }
        return ans;
    }
}