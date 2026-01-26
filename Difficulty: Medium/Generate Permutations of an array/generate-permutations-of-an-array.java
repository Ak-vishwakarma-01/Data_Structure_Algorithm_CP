class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    private static void permutaions(int ind , int arr[], int n){
        if(ind==n){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++) list.add(arr[i]);
            ans.add(list);
            return ;
        }
        for(int i=ind;i<n;i++){
            int rand = arr[ind];
            arr[ind] = arr[i];
            arr[i] = rand;
            
            permutaions(ind+1,arr,n);
            
            arr[i] = arr[ind];
            arr[ind] = rand;
        }
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        int n = arr.length;
        ans = new ArrayList<>();
        permutaions(0,arr, n);
        return ans;
    }
};