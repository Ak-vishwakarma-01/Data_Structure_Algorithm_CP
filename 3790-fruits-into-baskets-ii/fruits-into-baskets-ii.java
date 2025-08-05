class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for(int j: fruits){
            for(int i=0;i<n;i++){
                if(baskets[i]!=-1 && baskets[i]>=j) {
                    baskets[i] = -1;
                    count++;
                    break;
                }
            }
        }
        return n-count;
    }
}