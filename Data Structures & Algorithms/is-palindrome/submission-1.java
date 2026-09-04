class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }
}

/*
This is also a neat solution, but it uses more space.

Time: O(n)
Space: O(n) because of the string builder

*/
