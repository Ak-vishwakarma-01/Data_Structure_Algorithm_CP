class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int n = arr.length;
        int l = 0;
        int ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            while(mp.size()>k){
                if(mp.get(arr[l])<=1) mp.remove(arr[l]);
                else mp.put(arr[l],mp.get(arr[l])-1);
                l++;
            }
            ans += i-l+1;
        }
        return ans;
    }
}
