class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min = Math.min(min,arr[i]-arr[i-1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> de = new ArrayList<>();
        for(int i=1;i<n;i++){
            if((arr[i]-arr[i-1])==min){
                de.add(arr[i-1]);
                de.add(arr[i]);
                ans.add(de);
                de = new ArrayList<>();
            }
        }
        return ans;
    }
}