class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n = prices.length;
        Arrays.sort(prices);
        int count  = n/(k+1);
        count += n%(k+1)>0 ? 1 : 0;
        int low = 0;
        for(int i=0;i<count;i++){
            low += prices[i];
        }
        
        int high = 0;
        for(int i=n-1;i>=n-count;i--){
            high += prices[i];
        }
        return new ArrayList<>(Arrays.asList(low, high));
    }
}
