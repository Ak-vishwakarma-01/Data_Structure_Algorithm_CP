class Solution {
    private int func(String s, int k){
        int n = s.length();
        int l = 0, r = 0, count = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while (r < n) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);

            while (mp.size() > k) {
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                if (mp.get(s.charAt(l)) == 0) {
                    mp.remove(s.charAt(l));
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int countSubstr(String s, int k) {
        if (k == 0) return 0;  // edge case
        return func(s, k) - func(s, k - 1);
    }
}
