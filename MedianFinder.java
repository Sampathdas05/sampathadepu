package Design;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>((a, b) -> b-a);
        large = new PriorityQueue<Integer>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }
        else{
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (double) (small.peek() + large.peek())/2;
        }
        else{
            return (double) small.peek();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
