class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a,b)->{
            return a.compareTo(b);
        });
        Set<String> st = new HashSet<>();
        for(String s: folder){
            StringBuilder sb = new StringBuilder("");
            boolean flag = false;
            for(char c: s.toCharArray()){
                if(c=='/' && sb.length()>0 && st.contains(sb.toString())){
                    flag = true;
                    break;
                }
                sb.append(c+"");
            }
            if(!flag) st.add(sb.toString());
        }
        return new ArrayList<>(st);
    }
}