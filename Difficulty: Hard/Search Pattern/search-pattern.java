class Solution {
    private int[] getLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0; 
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    ArrayList<Integer> search(String pat, String txt) {
        int[] lps = getLPS(pat);
        int n = txt.length();
        int m = pat.length();
        int i = 0; 
        int j = 0; 
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                ans.add(i - j); 
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}
