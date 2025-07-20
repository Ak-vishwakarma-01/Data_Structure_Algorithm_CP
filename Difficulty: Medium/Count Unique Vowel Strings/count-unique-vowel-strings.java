import java.util.*;

class Solution {
    public int vowelCount(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');


        for (char c : s.toCharArray()) {
            if (vowels.contains(c))
                freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int uniqueVowelCount = freq.size();
        if (uniqueVowelCount == 0) return 0; 

        int ways = 1;
        for (int count : freq.values())
            ways *= count;

        int ans = ways * factorial(uniqueVowelCount);
        return ans;
    }

    private int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }
}
