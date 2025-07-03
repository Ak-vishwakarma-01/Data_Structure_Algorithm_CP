class Solution {
    public char kthCharacter(int k) {
        if (k == 1) return 'a';

        Map<Character, Character> mp = new HashMap<>();
        for (char ch = 'a'; ch < 'z'; ch++) {
            mp.put(ch, (char)(ch + 1));
        }
        mp.put('z', 'a'); 

        String s = "a";
        int size = 1;

        while (size < k) {
            String news = "";
            for (char c : s.toCharArray()) {
                news += c;
                news += mp.get(c);
            }
            s = news;
            size *= 2;
        }

        return s.charAt(k - 1);
    }
}
