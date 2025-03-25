class Solution {
    private boolean merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int size = 1;
        int first = intervals[0][0];
        int second = intervals[0][1];
        for(int i =1;i<n;i++){
            if(intervals[i][0]<second){
                second = second<intervals[i][1] ? intervals[i][1] : second;
            }else{
                first = intervals[i][0];
                second = intervals[i][1];
                size++;
            }
        }
        return size>=3;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int len = rectangles.length;
        int[][] intervals = new int[len][2];
        for(int i=0;i<len;i++){
            intervals[i][0] = rectangles[i][0];
            intervals[i][1] = rectangles[i][2];
        }
        if(merge(intervals)) return true;
        for(int i=0;i<len;i++){
            intervals[i][0] = rectangles[i][1];
            intervals[i][1] = rectangles[i][3];
        }
        if(merge(intervals)) return true;
        return false;
    }
}