class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int n = arr.length;
        int i = 0, j = n-1;
        int ans = 0;
        while(i<j){
            int lemin = Math.min(arr[i],arr[j]);
            ans = Math.max(ans,lemin*(j-i));
            if(arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}