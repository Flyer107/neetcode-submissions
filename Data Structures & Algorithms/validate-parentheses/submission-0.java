class Solution {
    // https://www.youtube.com/watch?v=WTzjTskDFMg
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c: s.toCharArray()) {

           // check if it is even a parentheses to process at all
           if (closeToOpen.containsKey(c)) {
                // Check top of stack and if that matches the close value
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    // If it is NOT a match, then it is not valid at all
                    return false;
                }
           } else {
            stack.push(c);
           }
        }
        return stack.isEmpty();
    }
}

/*
Have to start with an opening.
We can continue to add  openings (((((( as long as we close them eventually ))))))
Ex: ((((( ) <- We have a matching close so then we can remove the latest open that existed
So if empty, then we know it is valid

Key: A hasmap to determine which closing matches the opening to remove.

Time O(n) - iterate through each character in the string
Space O(n) - the stack
*/
