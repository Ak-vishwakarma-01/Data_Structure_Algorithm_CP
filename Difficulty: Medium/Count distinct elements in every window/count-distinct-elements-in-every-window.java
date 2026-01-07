class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        Map<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        int n = arr.length;
        for(int i=k;i<n;i++){
            list.add(mp.size());
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            if(mp.get(arr[i-k])<=1) mp.remove(arr[i-k]);
            else mp.put(arr[i-k],mp.get(arr[i-k])-1);
        }
        list.add(mp.size());
        return list;
    }
}