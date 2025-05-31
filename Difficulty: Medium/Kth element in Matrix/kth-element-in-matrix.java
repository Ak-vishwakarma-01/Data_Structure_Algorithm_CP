class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        List<Integer> de = new ArrayList<>();
        for(int i[] : matrix){
            for(int le: i){
                de.add(le);
            }
        }
        Collections.sort(de);
        return de.get(k-1);
    }
}