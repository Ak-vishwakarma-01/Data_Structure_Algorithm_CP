class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i = 0, j=0;
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = 1;
        while(j<n){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0)+1);
            while(mp.size()>2){
                int inum = mp.get(fruits[i]);
                if(inum==1) mp.remove(fruits[i]);
                else mp.put(fruits[i],inum-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}