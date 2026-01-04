class Solution {
    public int findMaxVal(int n, int[][] restn, int[] diff) {
        int ans = Integer.MIN_VALUE;
        int a[] = new int[n];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0] = 0;
        for(int de[]: restn){
            a[de[0]] = de[1];
        }
        
        for(int i=0;i<n-1;i++){
            a[i+1] = Math.min(a[i+1],a[i] + diff[i]);
        }

        for(int i=n-2;i>0;i--){
            a[i] = Math.min(a[i],a[i+1]+diff[i]);
        }
        a[0] = 0;
        int max =  0;
        for(int de: a) max = Math.max(max,de);
        return max;
    }
}