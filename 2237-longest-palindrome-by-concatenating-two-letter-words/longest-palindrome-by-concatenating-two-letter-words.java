import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int ans = 0;
        boolean hasCenter = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            
            if (freq.containsKey(rev) && freq.get(rev) > 0) {
                freq.put(rev, freq.get(rev) - 1);
                ans += 4; 
            } else {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : freq.keySet()) {
            if (key.charAt(0) == key.charAt(1) && freq.get(key) > 0) {
                hasCenter = true;
                break;
            }
        }

        if (hasCenter) ans += 2;

        return ans;
    }
}
