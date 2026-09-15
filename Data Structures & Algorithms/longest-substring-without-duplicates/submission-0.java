class Solution {
    // Burte Force soln
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();

            // DO NOT make the mistake of starting from 0, start from i
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break; // Break out of this loop for curr chat
                }
                // Otherwise add it to the char set to see if longer
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }
}

/*
Why the inner for loop starts at i
The outer loop picks a starting point i for a substring. The inner loop then extends the substring to the right, one character at a time, until it hits a duplicate.

So when i = 2, you're asking: "What's the longest substring that begins at index 2?" That means your window is s[2..j]. If you started the inner loop at 0:

You'd be checking substrings that don't begin at i at all — your "starting point" would be meaningless.
You'd re-scan characters before i that you already decided to skip.
Concretely, with s = "zxyzxyz" and i = 1:

i = 1:  s[1..j] → "x", "xy", "xyz", then hits "x" again → stop
That tries every substring starting at index 1. Starting j at 0 would try substrings like s[0..j], which is the job of i = 0, not i = 1. It would also create an infinite loop issue if you reset — you'd never make forward progress.

In short: i = where the substring begins, j = where it ends. Starting j at i means "the substring begins as just the single character at i, then grows."
__________________________________________
The line res = Math.max(res, charSet.size());
This updates your running best answer. Let's break it down:

res — the longest valid substring length found so far (across all starting points).
charSet.size() — the length of the current substring. Since every character in the set is distinct (you break on duplicates), the set's size equals the length of the valid window just built for this i.
Math.max(...) — keeps whichever is larger.
So after each i, charSet holds exactly the longest duplicate-free substring starting at i, and this line records it if it beats the previous record.
*/
