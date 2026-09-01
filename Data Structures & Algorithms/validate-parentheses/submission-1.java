class Solution {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}

/*
Ideally, understand the use of the stack for this problem, but this is a brute force solution.
Time: O(n^2)
Space: O(n)
*/
