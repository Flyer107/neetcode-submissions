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
}