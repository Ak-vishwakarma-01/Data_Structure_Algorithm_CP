class Solution {
    public int minFlips(String str) {
        int n = str.length();
        int ans = Integer.MAX_VALUE;

        str = str + str;
        char[] first = new char[2 * n];
        char[] second = new char[2 * n];

        int check = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (check == 0) {
                first[i] = '0';
                second[i] = '1';
            } else {
                first[i] = '1';
                second[i] = '0';
            }
            check = check == 1 ? 0 : 1;
        }

        int f = 0;
        int sec = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != first[i]) f++;
            if (str.charAt(i) != second[i]) sec++;
        }

        ans = Math.min(f, sec);

        for (int i = n; i < 2 * n; i++) {
            char de = str.charAt(i);

            if (de != first[i]) f++;
            if (de != second[i]) sec++;

            if (str.charAt(i - n) != first[i - n]) f--;
            if (str.charAt(i - n) != second[i - n]) sec--;

            ans = Math.min(ans, Math.min(f, sec));
        }

        return ans;
    }
}