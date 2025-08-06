class Solution {
    public int romanToDecimal(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int n = s.length();
        int total = 0;

        for (int i = 0; i < n - 1; i++) {
            int curr = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i + 1));
            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }
        
        total += romanMap.get(s.charAt(n - 1));
        return total;
    }
}
