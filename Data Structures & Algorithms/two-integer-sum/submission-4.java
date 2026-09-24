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
}
