class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sorted_s = s.toCharArray();
        char[] sorted_t = t.toCharArray();

        Arrays.sort(sorted_s);
        Arrays.sort(sorted_t);

        return Arrays.equals(sorted_s, sorted_t);

    }

    /*
    Comparison based sort takes O(n log(n))...usually it'll take O(n) space but people assume O(1) so discuss with interviewer about that
    Time: O (s log(s) + t log(t)) b/c sorted twice
    Space: O(1) or O(s + t) depending on the sorting algo

    */
}
