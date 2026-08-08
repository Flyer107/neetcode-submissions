class Solution {
    public int singleNumber(int[] nums) {
        int res = 0; // Starting at 0 -> the first XOR just captures the first number 

        for (int num: nums) {
            res ^= num; // res = res ^ num;
            // System.out.println("res: " + res);
        }

        // So we are just left with the real number b/c all other numbers are duplicates and cancel each other out.
        return res; 
    }
}
