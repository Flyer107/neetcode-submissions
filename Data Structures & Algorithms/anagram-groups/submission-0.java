class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Building off of the easy that showed us that we could determine by sorting

        Map<String, List<String>> grpAnagrams = new HashMap<>();

        for (String s: strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);

            String sorted_s = new String(charArr);

            // sorted_s is the key that maps to the bucket that contains all anagrams
            grpAnagrams.putIfAbsent(sorted_s, new ArrayList<>());
            grpAnagrams.get(sorted_s).add(s);
        }

        return new ArrayList<>(grpAnagrams.values());
    }

    /*
    Time: O(m * nlogn) b/c sorted each time per string
    */
}
