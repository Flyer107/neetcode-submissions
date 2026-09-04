class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;

        int compare_val;
        while (left < right) {
            compare_val = numbers[left] + numbers[right];
            if (compare_val < target) {
                left++;
            } else if (compare_val > target) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        return new int[0];
    }
}
