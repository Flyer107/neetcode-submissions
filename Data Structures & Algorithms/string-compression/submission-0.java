class Solution {
    public int compress(char[] chars) {
        int res = -999;
        int charsLen = chars.length;
        StringBuilder s = new StringBuilder();

        int i = 0;
        while (i < charsLen) {
            s.append(chars[i]);

            int j = i + 1;
            while (j < charsLen && chars[i] == chars[j]) {
                j++;
            }

            if (j -i > 1) {
                // Otherwise append the character followed by the group's length
                s.append(String.valueOf(j -i));
            }
            i = j;
        }
        // Loop through the original array and replace the characters
        for( i = 0 ; i < s.length(); i++) {
                chars[i] = s.charAt(i);
        }

        res = s.length();
        return res;
    }
}