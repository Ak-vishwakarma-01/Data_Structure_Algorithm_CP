class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int left[] = new int[n];
        int right[] = new int[n];
        int lastr = -1;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                right[i] = i;
                lastr = i;
            } else if (dominoes.charAt(i) == '.') {
                right[i] = lastr;
            } else {
                right[i] = -1;
                lastr = -1;
            }
        }
        int lastl = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                left[i] = i;
                lastl = i;
            } else if (dominoes.charAt(i) == '.') {
                left[i] = lastl;
            } else {
                left[i] = -1;
                lastl = -1;
            }
        }
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == '.') {
                if (left[i] < 0 && right[i] < 0)
                    ans += '.';
                else if (left[i] >= 0 && right[i] < 0)
                    ans += 'L';
                else if (right[i] >= 0 && left[i] < 0)
                    ans += 'R';

                else {
                    int mid = right[i] + (left[i] - right[i]) / 2;
                    int check = left[i] - right[i];
                    System.out.println(check + "   i   " + i);
                    if (i == mid)
                        ans += check % 2 == 1 ? 'R' : '.';
                    else if (i < mid)
                        ans += 'R';
                    else
                        ans += 'L';
                }
            } else {
                ans += dominoes.charAt(i);
            }
        }
        return ans;
    }
}