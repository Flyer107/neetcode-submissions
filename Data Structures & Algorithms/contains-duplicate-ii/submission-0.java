class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean isNearDuplicate = false;

        for (int i = 0 ; i < nums.length; i++) {
            for(int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && Math.abs(i-j) <= k) {
                    isNearDuplicate = true;
                }
            }
        }

        return isNearDuplicate; 
    }
}