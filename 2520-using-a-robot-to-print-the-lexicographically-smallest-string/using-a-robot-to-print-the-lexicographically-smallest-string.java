class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char smallNext[] = new char[n];
        smallNext[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            smallNext[i] = (char) Math.min(s.charAt(i), smallNext[i + 1]);
        }

        StringBuilder paper = new StringBuilder();
        Stack<Character> t = new Stack<>();
        int i = 0;
        while (i < n) {
            t.push(s.charAt(i));
            char minChar = i+1<n ?  smallNext[i+1] : s.charAt(i); 
            while (!t.isEmpty() && t.peek() <= minChar) {
                paper.append(t.pop());
            }
            i++;
        }

        while (!t.isEmpty()) {
            paper.append(t.pop());
        }

        return paper.toString();
    }
}
