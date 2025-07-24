class Solution {
    public int subarraySum(int[] arr) {
        
        int n = arr.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += (arr[i] * (i + 1) * (n - i));
        }

        return result;
    }
}
