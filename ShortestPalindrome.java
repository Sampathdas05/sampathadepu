package ArraysAndStrings;
//https://leetcode.com/problems/shortest-palindrome/submissions/
public class ShortestPalindrome {
	   public String shortestPalindrome(String s) {
	        if (s == null || s.length() < 2) {
	            return s;
	        }
	        int len = s.length();
	        int start = 0;
	        for (int index = len - 1; index >= 0; index --) {
	            if (s.charAt(start) == s.charAt(index)) {
	                start ++;
	            }
	        }
	        if (start == len) {
	            return s;
	        }
	        String remain = s.substring(start);
	        String rev = reverse(remain);
	        return rev + shortestPalindrome(s.substring(0, start)) + remain;
	    }
	    public String reverse (String str) {
	        int start = 0;
	        int end = str.length() - 1;
	        char [] array = str.toCharArray();
	        while (start < end) {
	            swap (array, start, end);
	            start ++;
	            end --;
	        }
	        return String.valueOf(array);
	    }
	    public void swap (char[] array, int i, int j) {
	        char tmp = array[i];
	        array[i] = array[j];
	        array[j] = tmp;
	    }
	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		sp.shortestPalindrome("adcba");
	}

}
