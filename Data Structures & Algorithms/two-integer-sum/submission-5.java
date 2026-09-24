class Solution {
    // Hashmap of VALUE: INDEX; Note: we visit/process first THEN add to hashmap so that it doesn't reuse the same index (i != j)
    // https://www.youtube.com/watch?v=KLlXCFG5TnA
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> valToIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (valToIdx.containsKey(diff)) {
                res[0] = valToIdx.get(diff);
                res[1] = i;
            }

            valToIdx.put(nums[i], i);
        }

        return res;
    }
    /*
    Time: O(n) -> one pass. One-pass becuase as sooon as we reah the matching pair in the array, we are assured that we have already hit the initial pair already.
    Space: O(n) because the hashmap might grow to fill every single value in the array.
    */
}
