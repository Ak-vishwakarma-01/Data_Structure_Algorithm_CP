import java.math.BigInteger;

class Solution {
    public int compareVersion(String v1, String v2) {
        int len1 = v1.length();
        int len2 = v2.length();
        int ind1 = 0, ind2 = 0;

        while (ind1 < len1 || ind2 < len2) {
            StringBuilder sb1 = new StringBuilder();
            while (ind1 < len1 && v1.charAt(ind1) != '.') {
                sb1.append(v1.charAt(ind1));
                ind1++;
            }

            StringBuilder sb2 = new StringBuilder();
            while (ind2 < len2 && v2.charAt(ind2) != '.') {
                sb2.append(v2.charAt(ind2));
                ind2++;
            }

            BigInteger num1 = sb1.length() == 0 ? BigInteger.ZERO : new BigInteger(sb1.toString());
            BigInteger num2 = sb2.length() == 0 ? BigInteger.ZERO : new BigInteger(sb2.toString());

            int cmp = num1.compareTo(num2);
            if (cmp != 0) return cmp > 0 ? 1 : -1;

            ind1++;
            ind2++;
        }
        return 0;
    }
}
