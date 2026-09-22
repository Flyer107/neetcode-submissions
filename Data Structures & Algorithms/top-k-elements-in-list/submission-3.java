class Solution {
    // Bucket sort: https://www.youtube.com/watch?v=YPTqKIgVk-k
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}

/*
So to do it linearlly, we make  i (count)   [  0 |     1    | 2  |  | ...]
                                values      [    |  [2, 5]  |    |  | ]
so after counting with a hashmap we see that the value 2 occures exactly once, so we put it to the list that maps to 1

so after filled, start from end of array and go backwards
*/
