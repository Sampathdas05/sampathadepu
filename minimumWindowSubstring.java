package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
	 public String minWindow(String s, String t) {
	        if(t.length()> s.length()) return "";
	        Map<Character, Integer> map = new HashMap<>();
	        for(char c : t.toCharArray()){
	            map.put(c, map.getOrDefault(c,0) + 1);
	        }
	        int counter = map.size();
	        
	        int begin = 0, end = 0;
	        int head = 0;
	        int len = Integer.MAX_VALUE;
	        
	        while(end < s.length()){
	            char c = s.charAt(end);
	            if( map.containsKey(c) ){
	                map.put(c, map.get(c)-1);
	                if(map.get(c) == 0) counter--;
	            }
	            end++;
                // begin char could be in table or not, 
                // if not then good for us, it was a wasteful char and we shortened the previously found substring.
                
                // if found in table increment count in table, as we are leaving it out of window and moving ahead, 
                // so it would no longer be a part of the substring marked by begin-end window
                // table only has count of chars required to make the present substring a valid candidate
                // if the count goes above zero means that the current window is missing one char to be an answer candidate	            
	            while(counter == 0){
	                char tempc = s.charAt(begin);
	                if(map.containsKey(tempc)){
	                    map.put(tempc, map.get(tempc) + 1);
	                    if(map.get(tempc) > 0){
	                        counter++;
	                    }
	                }
	                if(end-begin < len){
	                    len = end - begin;
	                    head = begin;
	                }
	                begin++;
	            }
	            
	        }
	        if(len == Integer.MAX_VALUE) return "";
	        return s.substring(head, head+len);
	    }
	public static void main(String[] args) {
		minimumWindowSubstring min = new minimumWindowSubstring();
		String s = "ADOBECODEBANC";
		
		String t = "ADOBE";
		System.out.println(min.minWindow(s, t));
		
	}

}
