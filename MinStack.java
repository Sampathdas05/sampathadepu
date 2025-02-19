package Design;

import java.util.Stack;

public class MinStack {
	   Stack<Integer> stack;
	    int min;
	    /** initialize your data structure here. */
	    public MinStack() {
	        stack = new Stack<Integer>();
	        min = Integer.MAX_VALUE;
	    }
	    
	    public void push(int x) {
	        if(x<=min){
	            stack.push(min);
	            min = x;
	        }
	        stack.push(x);
	    }
	    
	    public void pop() {
	        if(min == stack.pop()){
	            min = stack.pop();
	        }
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return min;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
