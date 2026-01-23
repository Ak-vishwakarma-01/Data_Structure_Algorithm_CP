class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> first = new Stack<>();
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            while(!first.isEmpty() && arr[first.peek()]<=arr[i]){
                first.pop();
            }
            int de = first.isEmpty() ? i+1: i-first.peek();
            li.add(de);
            first.push(i);
        }
        return li;
    }
}