class Solution {
    
    private boolean isVowel(char ch){
        if(ch=='a') return true;  
        if(ch=='e') return true; 
        if(ch=='i') return true; 
        if(ch=='o') return true; 
        if(ch=='u') return true;
        return false;
    }

    public String sortVowels(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        Map<Character,int[]> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            if(isVowel(ch[i])){
                mp.putIfAbsent(ch[i],new int[]{0,i});
                mp.get(ch[i])[0]++;
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
            if(mp.get(b)[0] != mp.get(a)[0] ) return Integer.compare(mp.get(b)[0],mp.get(a)[0]);
            else return Integer.compare(mp.get(a)[1],mp.get(b)[1]);
        });
        for(char de: mp.keySet()){
            pq.add(de);
        }
        List<Character> list = new ArrayList<>();
        while(!pq.isEmpty()){
            char c = pq.poll();
            int iter = mp.get(c)[0];
            while(iter-->0){
                list.add(c);
            } 
        }
        for(int i=0;i<n;i++){
            char de = ch[i];
            if(isVowel(de)){
                ch[i] = list.get(0);
                list.remove(0);
            }
        }
        return new String(ch);
    }
}