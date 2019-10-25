package TreesAndGraphs;

import java.util.Stack;

public class AddTwoNumbersII {
	 static class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();
        
        while(l1 != null) {
            l1Stack.push(l1);
            l1 = l1.next;
        }
        
        Stack<ListNode> l2Stack = new Stack<>();
        
        while(l2 != null) {
            l2Stack.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode dummy = null;
        
        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() ||  carry != 0) {
            int f = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
            int s = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;
            
            int t = f + s + carry;
            
            ListNode newNode = new ListNode(t % 10);
            
            newNode.next = dummy;
            dummy = newNode;
            carry = t/10;
            
        }
        
        return dummy;
        
    }
	
	 public ListNode addTwoNumbersSingleStack(ListNode l1, ListNode l2) {
	        int n1 = 0, n2 = 0;
	        for (ListNode i = l1; i != null; i = i.next) n1++;
	        for (ListNode i = l2; i != null; i = i.next) n2++;
	        
	        Stack<Integer> st = new Stack();
	        int totn = Math.max(n1, n2);
	        for (ListNode i = l1, j = l2; totn > 0; totn--) {
	            int a = 0, b = 0;
	            if (totn <= n1) {
	                a = i.val;
	                i = i.next;
	            }
	            if (totn <= n2) {
	                b = j.val;
	                j = j.next;
	            }
	            st.push(a + b);
	        }
	        
	        int c = 0;
	        ListNode ans = null;
	        while (!st.empty()) {
	            ListNode i = new ListNode(st.pop());
	            int c1 = (c + i.val) / 10;
	            i.val = (c + i.val) % 10;
	            i.next = ans;
	            ans = i;
	            c = c1;
	        }
	        
	        if (c > 0) {
	            ListNode i = new ListNode(c);
	            i.next = ans;
	            ans = i;
	        }
	        
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
