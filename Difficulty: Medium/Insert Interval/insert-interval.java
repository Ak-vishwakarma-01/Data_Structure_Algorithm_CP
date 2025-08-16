import java.util.*;

class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newi) {
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        
        int i = 0;
        
        while (i < n && newi[0] > intervals[i][1]) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        int firstval = newi[0];
        int secondval = newi[1];
        if (i < n) firstval = Math.min(intervals[i][0], newi[0]);
        
        while (i < n && intervals[i][0] <= secondval) {
            secondval = Math.max(secondval, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{firstval, secondval});
        
        while (i < n) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        return ans;
    }
}
