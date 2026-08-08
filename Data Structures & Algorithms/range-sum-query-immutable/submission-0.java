class NumArray {


    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
        // Arrays.sort(this.nums); // ruins the ordering.
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;

        
        for (int i = left; i <= right; i++) {
            sum += this.nums[i];
        }

        return sum;
    }

    public int[] getNums() {
        return this.nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */