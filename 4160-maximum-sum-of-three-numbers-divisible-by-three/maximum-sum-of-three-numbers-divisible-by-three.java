import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 3 == 0) zero.add(nums[i]);
            else if (nums[i] % 3 == 1) one.add(nums[i]);
            else two.add(nums[i]);
        }

        Collections.sort(zero);
        Collections.sort(one);
        Collections.sort(two);

        int ans = Integer.MIN_VALUE;

        int zerosize = zero.size();
        if (zerosize >= 3) {
            ans = Math.max(ans,
                    zero.get(zerosize - 1) +
                    zero.get(zerosize - 2) +
                    zero.get(zerosize - 3));
        }

        int onesize = one.size();
        if (onesize >= 3) {
            ans = Math.max(ans,
                    one.get(onesize - 1) +
                    one.get(onesize - 2) +
                    one.get(onesize - 3));
        }

        int twosize = two.size();
        if (twosize >= 3) {
            ans = Math.max(ans,
                    two.get(twosize - 1) +
                    two.get(twosize - 2) +
                    two.get(twosize - 3));
        }

        if (onesize >= 1 && twosize >= 1 && zerosize >= 1) {
            ans = Math.max(ans,
                    one.get(onesize - 1) +
                    two.get(twosize - 1) +
                    zero.get(zerosize - 1));
        }

        return ans < 0 ? 0 : ans;
    }
}
