class Solution {
    public int countSubarrays(int[] arr, int k) {
        
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        return findAtMostSubarray(arr, k) - findAtMostSubarray(arr, k - 1);
    }
    
    private int findAtMostSubarray(int [] arr, int k) {
        int length = arr.length;
        int oddNumberCount = 0;
        int left = 0;
        int right = 0;
        int countSubarray = 0;
        while (right < length) {
            int currentNum = arr[right];
            oddNumberCount += currentNum % 2 == 0 ? 0 : 1;
            while (oddNumberCount > k) {
                int leftNum = arr[left];
                oddNumberCount -= leftNum % 2 == 0 ? 0 : 1;
                left++;
            }
            countSubarray += right - left + 1;
            right++;
        }
        return countSubarray;
    }
}