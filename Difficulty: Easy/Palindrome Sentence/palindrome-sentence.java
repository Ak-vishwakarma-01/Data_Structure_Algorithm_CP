class Solution {
    public boolean isPalinSent(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c)); 
            }
        }

        String cleaned = sb.toString();
        String reversed = sb.reverse().toString();

        return cleaned.equals(reversed);
    }
}
