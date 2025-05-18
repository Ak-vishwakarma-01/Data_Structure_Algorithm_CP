class Solution {
    private int digitsum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Pair ele[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int digisum = digitsum(nums[i]);
            ele[i] = new Pair(digisum, nums[i], i);
        }
        Arrays.sort(ele, (a, b) -> {
            if (a.digisum == b.digisum)
                return Integer.compare(a.val, b.val);
            return Integer.compare(a.digisum, b.digisum);
        });
        int swap = 0;
        for (int i = 0; i < n; i++) {
            int ind = ele[i].ind;
            if (ind != i) {
                Pair rand = ele[i];
                ele[i] = ele[ind];
                ele[ind] = rand;
                swap++;
                i--;
            }
        }
        return swap;
    }
}

class Pair {
    int digisum;
    int val;
    int ind;

    public Pair(int dig, int v, int in) {
        digisum = dig;
        val = v;
        ind = in;
    }
}