import java.util.Arrays;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] secondsArr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = arr[i].split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            secondsArr[i] = hours * 3600 + minutes * 60 + seconds;
        }

        Arrays.sort(secondsArr);

        int minDiff = 86400;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, secondsArr[i] - secondsArr[i - 1]);
        }

        int wrapAroundDiff = 86400 - secondsArr[n - 1] + secondsArr[0];
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }
}
