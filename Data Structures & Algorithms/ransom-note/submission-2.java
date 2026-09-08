class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countR = new int[26];
        int[] countM = new int[26];

        for(Character ch: ransomNote.toCharArray()) {
            // We have seen this before, this is manipulating the ascii
            // Ex: Let's sat 'a' = 64; 'a' - 'a' = 64 -64 = 0
            //    but b = 65. so 65 - 64 = 1... and so on. So converting it into numbers by taking advantage of ascii
            countR[ch - 'a']++;
        }

        for (Character ch: magazine.toCharArray()) {
            countM[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // We are checking if magazine contains enough for the note
            // So if magazine is less than R at any point in alphabet return false
            if (countM[i] < countR[i]) return false;
        }

        return true;
    }

    /*
    Time: O(m + n) Loop through each
    Space: O(1) since two 26 characters is really just O(1)
    */
}