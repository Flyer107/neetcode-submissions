class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mag_count = new HashMap<>();

        for (Character ch: magazine.toCharArray()) {
            mag_count.put(ch, mag_count.getOrDefault(ch, 0) + 1);
        }

        for (Character ch: ransomNote.toCharArray()) {

            if (!mag_count.containsKey(ch) || mag_count.get(ch) == 0 ) {
                return false;
            }
            if (mag_count.containsKey(ch)) {
                mag_count.put(ch, mag_count.get(ch) - 1);
            }
        }
        return true;
    }

    /*
    Brute force approach

    Time: O(m * n) for each len(ransomeNote) we have to check len(magazine)
    Space: O(n) b/c of the hashmap

    Interesting implementation with a list:
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> mag = new ArrayList<>();
        for (char c : magazine.toCharArray()) {
            mag.add(c);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!mag.contains(c)) return false;
            mag.remove((Character) c);
        }

        return true;
    }
    
    */
}