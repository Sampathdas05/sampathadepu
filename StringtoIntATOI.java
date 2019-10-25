package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author SA044034
 *
 */
public class StringtoIntATOI {
	  public static int myAtoi(String str) {
		  if (str == null || str.length() == 0)
				return 0;//
			str = str.trim();
			char firstChar = str.charAt(0);
			int sign = 1, start = 0, len = str.length();
			long sum = 0;
			if (firstChar == '+') {
				sign = 1;
				start++;
			} else if (firstChar == '-') {
				sign = -1;
				start++;
			}
			for (int i = start; i < len; i++) {
				if (!Character.isDigit(str.charAt(i)))
					return (int) sum * sign;
				sum = sum * 10 + str.charAt(i) - '0';
				if (sign == 1 && sum > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}

			return (int) sum * sign;
	    }
	  
	   public static int[] findErrorNums(int[] nums) {
	        Map < Integer, Integer > map = new HashMap();
	        int dup = -1, missing = 1;
	        for (int n: nums) {
	            map.put(n, map.getOrDefault(n, 0) + 1);
	        }
	        for (int i = 1; i <= nums.length; i++) {
	            if (map.containsKey(i)) {
	                if (map.get(i) == 2)
	                    dup = i;
	            } else
	                missing = i;
	        }
	        return new int[]{dup, missing};
	    }
	    public static boolean isPalindrome(int x) {
	        int rev = 0;
	        int temp = x;
	        while(x>0){
	            rev = (rev * 10) + x%10;
	            x = x/10;
	        }
	        if(rev == temp){
	            return true;
	        }
	        return false;
	    }
	    
	    public static int myAtoi2(String str) {
	        if(str == null  || str.isEmpty()){
	            return 0;
	        }
	        int i = 0;
	        long value = 0;
	        while(i < str.length() && str.charAt(i) == ' '){
	            i++;
	        }
	        boolean sign = true;
	        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
	            sign = str.charAt(i) == '+';
	            i++;
	        }
	       // int sum = 0;
	        while(i < str.length() && Character.isDigit(str.charAt(i))){
	        	int sum = str.charAt(i) - '0';
	        	value = (10 * value) + sum;
	            if(sign && value > Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            }
	            else if(!sign && (-1*value) < Integer.MIN_VALUE){
	            	return  Integer.MIN_VALUE;
	            } 
	            i++;
	        }
	        return (int) (sign == true ? value : (-1 * value));
	    }
	    public static int myAtoisub(String str) {
	         int i = 0;
	        boolean sign = false;
	        long sum = 0;
	        if(str == null||str.length() == 0){
	            return 0;
	        }

	           while(i<str.length() && str.charAt(i) == ' ' ){
	               i++;
	           }
	           if(i<str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')){
	               sign = str.charAt(i) == '-';
	               i++;
	           }
	           while(i<str.length()&& Character.isDigit(str.charAt(i))){
	               int val = str.charAt(i) - '0'; 
	               sum = (sum *10) + val;
	               if(!sign && sum>Integer.MAX_VALUE){
	                   return Integer.MAX_VALUE;
	               }
	               else if(sign && -1 *sum < Integer.MIN_VALUE){
	                   return Integer.MIN_VALUE;
	               }
	               i++;
	           }
	           if(!sign){
	               return (int)sum;
	           }
	           else{
	               return (int) (-1 * sum);
	           }  
	    }
	public static void main(String[] args) {
		String s = "-91283472332";
		int[] i = new int[]{2,2};
		findErrorNums(i);
		System.out.println(myAtoi2("-91283472332"));
		System.out.println(isPalindrome(121));
	}

}
