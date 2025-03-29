import java.util.*;

class Solution {
    final int MOD = (int) 1e9 + 7;

    private long findPower(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    private int getPrimeScore(int num) {
        int score = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                score++;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) score++;
        return score;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];
        for (int i = 0; i < n; i++) {
            primeScores[i] = getPrimeScore(nums.get(i));
        }

        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && primeScores[stack.peek()] <= primeScores[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums.get(i), i});
        }

        long score = 1;
        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0], i = curr[1];

            long subarrayCount = (long) (nextGreater[i] - i) * (i - prevGreater[i]);
            long operations = Math.min(subarrayCount, k);

            score = (score * findPower(num, operations)) % MOD;
            k -= operations;
        }

        return (int) score;
    }
}
