class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int presum = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            presum += arr[i];
            if(presum==k) ans++;
            if(mp.containsKey(presum-k)){
                ans += mp.get(presum-k);
            }
            mp.put(presum,mp.getOrDefault(presum,0)+1);
        }
        return ans;
    }
}