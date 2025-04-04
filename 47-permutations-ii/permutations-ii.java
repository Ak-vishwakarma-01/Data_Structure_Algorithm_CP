class Solution {
    private void perm(int nums[],Set<List<Integer>> ans, List<Integer> ds,boolean freq[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                perm(nums, ans, ds, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        perm(nums, ans, ds, freq);
        List<List<Integer>> dede = new ArrayList<>();
        for(List<Integer> list: ans){
            dede.add(list);
        }
        return dede;
    }
}