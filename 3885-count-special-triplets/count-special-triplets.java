class Solution {
    public int specialTriplets(int[] nums) {
        int n  = nums.length;
        int ltwice[] = new int[n];
        int rtwice[] = new int[n];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            ltwice[i] = mp.getOrDefault(nums[i]*2, 0);
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        mp = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            rtwice[i] = mp.getOrDefault(nums[i]*2, 0);
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        long ans =  0;
        for(int i=1;i<n-1;i++){
            int l = ltwice[i];
            int r = rtwice[i];
            if(l==0|| r==0) continue;
            ans += (long)r*l;
            ans = ans % 1000000007;
        }
        return (int)ans;
    }
}