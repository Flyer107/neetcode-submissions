class Solution {
    // Size of window is <= k is what they are looking for.
    // Really calls for sliding window technique
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();

        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R-L > k) {
                window.remove(nums[L]);
                L += 1;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }

// Time O(n) b/c loop through array one e
// Space O(min(n, k)) where ke is the max distane between two equal numbers
    // Only need to check for duplicates within a sliding window of size K
}