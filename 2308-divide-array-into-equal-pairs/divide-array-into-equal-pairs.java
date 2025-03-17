class Solution {
    public boolean divideArray(int[] nums) {
        int oddHash = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n  = nums.length/2;
        for(int i: nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
            if(mp.get(i)%2!=0) oddHash ++;
            else oddHash--;
        }
        if(oddHash != 0 || mp.size()>n) return false;
        return true;
    }
}