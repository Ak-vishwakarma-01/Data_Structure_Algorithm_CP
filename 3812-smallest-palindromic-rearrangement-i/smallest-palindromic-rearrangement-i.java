class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n<=2) return s;
        Map<Character ,Integer>  mp = new TreeMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0)+1);
        }
        List<Character> li = new ArrayList<>();
        String ans  = "";
        for(Map.Entry<Character,Integer> ent: mp.entrySet()){
            char c = ent.getKey();
            int v = ent.getValue();
            if(v%2==0){
                for(int i=0;i<v/2;i++){
                    ans += c;
                }
            }else{ 
                if(v>1){
                    for(int i=0;i<v/2;i++){
                        ans += c;
                    }
                }
                li.add(c);
            }
        }
            StringBuilder sb = new StringBuilder(new String(ans));
             sb = sb.reverse();
            if(li.size()>0) ans += li.get(0);
            return ans+sb.toString();
    }
}