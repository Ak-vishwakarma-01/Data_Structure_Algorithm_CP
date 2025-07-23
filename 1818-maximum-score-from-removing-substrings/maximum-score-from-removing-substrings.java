class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return process(s, 'a', 'b', x, y);
        } else {
            return process(s, 'b', 'a', y, x);
        }
    }

    private int process(String s, char first, char second, int firstVal, int secondVal) {
        Stack<Character> stack1 = new Stack<>();
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c == second) {
                if (!stack1.isEmpty() && stack1.peek() == first) {
                    stack1.pop();
                    result += firstVal;
                } else {
                    stack1.push(c);
                }
            } else {
                stack1.push(c);
            }
        }

        StringBuilder remaining = new StringBuilder();
        for (char c : stack1) {
            remaining.append(c);
        }

        Stack<Character> stack2 = new Stack<>();
        for (char c : remaining.toString().toCharArray()) {
            if (c == first) {
                if (!stack2.isEmpty() && stack2.peek() == second) {
                    stack2.pop();
                    result += secondVal;
                } else {
                    stack2.push(c);
                }
            } else {
                stack2.push(c);
            }
        }

        return result;
    }
}
