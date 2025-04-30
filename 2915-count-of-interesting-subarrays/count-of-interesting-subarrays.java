class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L); 
        
        long result = 0;
        int runningSum = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                runningSum++;
            }

            int mod = runningSum % modulo;
            
            int target = (mod - k + modulo) % modulo;

            result += countMap.getOrDefault(target, 0L);
            countMap.put(mod, countMap.getOrDefault(mod, 0L) + 1);
        }

        return result;
    }
}
