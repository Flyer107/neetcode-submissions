class MinStack {
    private ArrayList<Integer> stack;
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new ArrayList<>();
    }
    
    public void push(int val) {
        if (val < this.min) {
            this.min = val;
        }
        this.stack.add(val);
        
    }
    
    public void pop() {
        int len = this.stack.size();
        int pop_val = this.stack.get(len-1);
        this.stack.remove(len-1);

        // return pop_val;
        
    }
    
    public int top() {
        int len = this.stack.size();
        return this.stack.get(len-1);
        
    }
    
    public int getMin() {
        // return this.min;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.stack.size(); i++) {
            if (this.stack.get(i) < min) {
                min = this.stack.get(i);
            }
        }
        return min;
    }
}
