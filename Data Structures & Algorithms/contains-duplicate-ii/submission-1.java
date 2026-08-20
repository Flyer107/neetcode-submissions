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

/*
Time complexity: 
O(n^2)
Space complexity: 
O(1)

n is the number of elements in the input array nums.*/