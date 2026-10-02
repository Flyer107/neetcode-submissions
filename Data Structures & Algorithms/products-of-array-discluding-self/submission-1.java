class Solution {
    // https://www.youtube.com/watch?v=bNvIQI2wAjk
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] postf = new int[n];

        pref[0] = 1;
        postf[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            postf[i] = nums[i + 1] * postf[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * postf[i];
        }
        return res;
    }
}  


/*

input:  [1, 2, 3, 4]

prefix  [1, 2, 6, 24]  // up until that point, what is multiplied by what at the ith
postfix [24, 24, 12, 4] // same thing but in reverse order where we go right to left
output  [] // you multiple everything from the prefix and the postfix

if start of array keep prefix as 1 so that it stays neutral
1: 1 * 24 = 24      // assume 1 for prefix
2: 1 * 12 = 12
3: 2 * 4 = 8
4: 6 * 1 = 6        // assume 1 for postfix

Time: O (n)
Space: O(n) if we have the prefix and postfix arrays allocated as it says output array does not count to memory count

So to use O(1) time
Left to right storing the prefix in output but 1 spot to the right
Right to left multiplying the reverse prefix 1 spot to the left
*/
