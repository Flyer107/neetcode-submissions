class Solution {
    public int singleNumber(int[] nums) {
        int res = -99999;
        HashMap<Integer, Integer> numToCount = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++) {
            if (numToCount.get(nums[i]) != null) {
                numToCount.put(nums[i], 2);
            } else {
                numToCount.put(nums[i], 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (numToCount.get(nums[i]) == 1) {
                res= nums[i];
            }
        }
        return res;

    }
}
