class Solution {
    // Sliding WINDOW!
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++) {
            // While loop checks if the next r character already in the charSet. If true continuously decrease the window by removing the character and incrementing l pointer
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }

            // After confirmed no duplicates, add the character at the r pointer
            charSet.add(s.charAt(r));
            // get the largest substring so far by comparing res to what the length is between the r and l pointers.
            res = Math.max(res, r-l + 1);
        }
        return res;
    }
}

/*
Time: O(n) We loop through the array once. n= the elength of the string
Space: O(m) m is the total number of unque characters in the string.
*/
