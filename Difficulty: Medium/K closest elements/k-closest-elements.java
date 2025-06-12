class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;

        int low = 0, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int i, j;
        if (arr[mid] == x) {
            i = mid - 1;
            j = mid + 1;
        } else {
            i = high;
            j = low;
        }

        int[] ans = new int[k];
        int ansi = 0;

        while ((i >= 0 || j < n) && k > 0) {
            if (i >= 0 && j < n) {
                int left = Math.abs(arr[i] - x);
                int right = Math.abs(arr[j] - x);

                if (left < right) {
                    ans[ansi++] = arr[i--];
                } else if (right < left) {
                    ans[ansi++] = arr[j++];
                } else {
                    if (arr[i] > arr[j]) {
                        ans[ansi++] = arr[i--];
                    } else {
                        ans[ansi++] = arr[j++];
                    }
                }
            } else if (i >= 0) {
                ans[ansi++] = arr[i--];
            } else if (j < n) {
                ans[ansi++] = arr[j++];
            }
            k--;
        }

        return ans;
    }
}
