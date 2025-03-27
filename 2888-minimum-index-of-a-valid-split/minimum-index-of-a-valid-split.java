class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer,Integer>  mp = new HashMap<>();
        int check[][] = new int[n+1][2];
        int maxVal = 0;
        int maxValNumber = -1;
        for(int i=n-1;i>=0;i--){
            int num = nums.get(i);
            // System.out.print("num "+num+"\t");
            mp.put(num, mp.getOrDefault(num,0)+1);
            num = mp.get(num);
            if(num>maxVal){
                maxValNumber = nums.get(i);
                maxVal = num;
            }
            if(maxVal>((n-i)/2)){
                check[i][0] = 1;
            }
            check[i][1] = maxValNumber;
            // System.out.print("value "+num+"\tmaxvalue "+maxVal+"\tcheck[i][0] "+check[i][0]+"\tmaxvalNUm "+check[i][1]+"\t");
        }
        System.out.println();
        mp.clear();
        maxVal = 0;
        maxValNumber = -1;
        int le = n;
        for(int i=0;i<n-1;i++){
            int num = nums.get(i);
            // System.out.print("num "+num+"\t");
            mp.put(num, mp.getOrDefault(num,0)+1);
            num = mp.get(num);
            if(num>maxVal){
                maxValNumber = nums.get(i);
                maxVal = num;
            }
            if(maxVal>((i+1)/2) && check[i+1][0]==1 && maxValNumber==check[i+1][1]){
                return i;
            }
            // System.out.print("value "+num+"\tmaxvalue "+maxVal+"\tcheck[i][0] "+check[i][0]+"\tmaxvalNUm "+check[i][1]+"\t");
        }
        return -1;
    }
}