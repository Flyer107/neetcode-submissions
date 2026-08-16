class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for (Integer num: nums) {
            if (numToFreq.containsKey(num)) {
                return true;
            } else {
                numToFreq.put(num, 1);
            }
        }

        return false;
    }
}