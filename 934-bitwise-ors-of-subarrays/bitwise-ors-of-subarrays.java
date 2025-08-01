class Solution {
    int dp[];
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> curr = new HashSet<>();
            curr.add(arr[i]);
            res.add(arr[i]);
            for(int x: prev){
                curr.add(arr[i]|x);
                res.add(arr[i]|x);
            }
            prev = curr;

        }
        return res.size();
    }
}