class Solution {

    public boolean isPalindrome(String s) {
        int str_len = s.length();
        int left = 0;
        int right = str_len -1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left <right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }

        return true;
    }

    /*
    Space: O(1) -> We don't really create anything in the heap
    Time: O(n) 
    */


    // public boolean isPalindrome(String s) {
    //     if (s == null) return false;

    //     if (s.isEmpty()) return true;

    //     int str_len = s.length();
    //     int left = 0;
    //     int right = str_len -1;

    //     for (int i = 0; i < str_len /2 ; i++) {
    //         if (s.charAt(i) != s.charAt(str_len -i -1)) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}
