class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();   
    }
    
    public void push(int val) {
        stack.push(val);
        // Note <=, the "=" part, so we are repeating if equal
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int topOfStack = stack.pop();

        // So if the top of regular stack is the current min at that point in time, pop from minStack too
        if (topOfStack == minStack.peek()) {
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }

    /*
    Neetcode explains using two stacks. One stack is to record the minimum at that point in time 
    Add a value, insert into both stacks
    Pop a value, pop from both stacks
    Top just looks at the top of the main stack -> O(1)
    getMin looks at the top of the min stack -> O(1)

    */
}
