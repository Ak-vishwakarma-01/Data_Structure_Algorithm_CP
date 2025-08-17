class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        int n = arr.length;
        ArrayList<Pair> de = new ArrayList<>();
        for(int val: arr){
            de.add(new Pair(val, Math.abs(val-x)));
        }
        Collections.sort(de,(a,b)->{
            return a.du - b.du;
            
        });
        for(int i=0;i<n;i++){
            arr[i] = de.get(i).or;
        }
    }
}


class Pair{
    int or;
    int du;
    public Pair(int or, int du){
        this.or = or;
        this.du = du;
    }
}
