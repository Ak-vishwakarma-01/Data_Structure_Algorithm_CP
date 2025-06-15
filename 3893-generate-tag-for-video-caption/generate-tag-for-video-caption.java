class Solution {
    public String generateTag(String caption) {
        StringBuilder tag = new StringBuilder("#");
        String[] words = caption.split(" ");
        
        boolean firstWord = true;
        for (String word : words) {
            if (word.isEmpty()) continue; 
            StringBuilder cleanWord = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    cleanWord.append(Character.toLowerCase(c));
                }
            }

            if (cleanWord.length() == 0) continue; 
            
            if (firstWord) {
                tag.append(cleanWord);
                firstWord = false;
            } else {
                tag.append(Character.toUpperCase(cleanWord.charAt(0)));
                tag.append(cleanWord.substring(1));
            }
        }

        if (tag.length() > 100) {
            return tag.substring(0, 100);
        }

        return tag.toString();
    }
}
