import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); 
        int ans = 0;
        int n = meetings.length;

        if (meetings[0][0] > 1) ans += meetings[0][0] - 1; 

        int lastOcc = meetings[0][1];
        
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] <= lastOcc + 1) { 
                lastOcc = Math.max(lastOcc, meetings[i][1]); 
            } else { 
                ans += meetings[i][0] - lastOcc - 1;
                lastOcc = meetings[i][1]; 
            }
        }
        
        if (lastOcc < days) ans += days - lastOcc; 
        
        return ans;
    }
}
