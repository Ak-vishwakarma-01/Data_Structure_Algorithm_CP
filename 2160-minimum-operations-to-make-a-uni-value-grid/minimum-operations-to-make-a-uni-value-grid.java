class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i[]: grid){
            for(int j: i){
                list.add(j);
            }
        }
        Collections.sort(list);
        int ans = 0;
        int n = list.size();
        int target = list.get(n/2);
        for(int num: list){
            if(target%x != num%x) return -1;
            ans += Math.abs(target-num)/x;
        }
        return ans;
    }
}