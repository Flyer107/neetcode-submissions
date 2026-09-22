class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            // So that it maps frequency to number
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        // sorts in descending order of frequency
        // a[0] = frequency of first element; b[0] is frequencey of the second element
        // lambda returns b[0]-a[0] = highest frequency first
        // arr.sort((a, b) -> b[0] - a[0]);
        arr.sort((a, b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}



