class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n  = nums.length;
        if(n==1) return new ArrayList<>(Arrays.asList(nums[0]));
        int []maxright = new int[n];
        int []maxleft = new int[n];
        maxright[n-1] = nums[n-1];
        maxleft[0] = nums[0];
        for(int i=1;i<n;i++){
            maxleft[i] = Math.max(maxleft[i-1],nums[i]);
            maxright[n-i-1] = Math.max(maxright[n-i],nums[n-i-1]);
        }
        List<Integer> list= new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<n-1;i++){
            if(nums[i]>maxleft[i-1])list.add(nums[i]);
            else if(nums[i]>maxright[i+1])list.add(nums[i]);
        }
        list.add(nums[n-1]);
        return list;
    }
}