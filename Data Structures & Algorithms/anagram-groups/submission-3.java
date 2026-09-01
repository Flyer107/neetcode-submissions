class Solution {
    // https://www.youtube.com/watch?v=vzdNOK2oB2E
    public List<List<String>> groupAnagrams(String[] strs) {
        // (a-z) all lowercase. At most 26 characters
        Map<String, List<String>> grpAnagrams = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];
            /*
            Imagine when it comes to ascii:
            a = 80; a - a = 0
            b = 81; b - a = 1
            ...*/
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            } // so for every character in the 26 limited count array we increment the counts

            String key = Arrays.toString(count);
            grpAnagrams.putIfAbsent(key, new ArrayList<>());
            grpAnagrams.get(key).add(s); // actually add the string
        }

        return new ArrayList<>(grpAnagrams.values());
    }
}
