package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	   public int romanToInt(String s) {
	        if(s == null || s.isEmpty()){
	            return 0;
	        }
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        map.put('M', 1000);
	        map.put('D', 500);
	        map.put('C', 100);
	        map.put('L', 50);
	        map.put('X', 10);
	        map.put('V', 5);
	        map.put('I', 1);
	        
	        int prev = map.get(s.charAt(0));
	        int next = 0;
	        int sum = 0;
	        
	        for(int i=1; i<s.length(); i++){
	            next = map.get(s.charAt(i));
	            if(next > prev){
	                sum -= prev;
	            }
	            else{
	                sum += prev;
	            }
	            prev = next;
	        }
	        sum += prev;
	        return sum;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
