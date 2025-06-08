class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> mHeap = new PriorityQueue<>((p1,p2)->{
            if(p1.c==p2.c) return p2.ind - p1.ind;
            return p1.c - p2.c;
        });
        int n  = s.length();
        boolean checks[] = new boolean[n];
        Arrays.fill(checks, true);
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='*' ){
                checks[i] = false;
                if(!mHeap.isEmpty()){
                    Pair p = mHeap.poll();
                    checks[p.ind] = false;
                }
            }else{
                mHeap.add(new Pair(s.charAt(i),i));
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<n;i++){
            if(checks[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

class Pair{
    char c;
    int ind;
    public Pair(char c, int ind){
        this.c = c ;
        this.ind = ind;
    }
}