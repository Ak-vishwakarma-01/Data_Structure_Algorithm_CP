class Solution {
    public int minSwaps(int[] nums, int[] fb) {
        int n = nums.length;
        Map<Integer,Integer> nmp = new HashMap<>();
        Map<Integer,Integer> fmp = new HashMap<>();
        Map<Integer,Integer> match = new HashMap<>();
        for(int i =0;i<n;i++){
            nmp.put(nums[i],nmp.getOrDefault(nums[i],0)+1);
            fmp.put(fb[i],fmp.getOrDefault(fb[i],0)+1);
            if(nums[i]==fb[i])match.put(fb[i],match.getOrDefault(fb[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> iter: nmp.entrySet()){
            int sum = iter.getValue();
            if(fmp.containsKey(iter.getKey())){
                sum += fmp.get(iter.getKey());
            }
            if(sum>n) return -1;
        }
        int ans = 0;
        List<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer,Integer> iter: match.entrySet()){
            li.add(iter.getValue());
        }
        Collections.sort(li);
        n = li.size();
        int curr = 0;
        ans = 0;
        for(int i=n-1;i>=0;i--){
            ans += Math.min(curr,li.get(i));
            curr = Math.abs(curr-li.get(i));
        }
        return ans+curr;
    }
}