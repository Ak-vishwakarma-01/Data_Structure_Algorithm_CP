class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i =1;i<n;i++){
            int []de = ans.get(ans.size()-1);
            if(intervals[i][0]<=de[1]){
                de[1] = de[1]<intervals[i][1] ? intervals[i][1] : de[1];
            }else{
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}