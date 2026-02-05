class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(nums[0],0);
        for(int i=1;i<n;i++){
            int de = (target - nums[i]);
            if(mp.containsKey(de)) return new int[]{mp.get(de),i};
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}