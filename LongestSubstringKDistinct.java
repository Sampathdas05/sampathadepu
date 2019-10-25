package AmazonOnline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringKDistinct {

	public List<String> subStringWithKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        if( n * k == 0) {
            return result;
        } 
        
        int left = 0, right = 0;
        
        while(right < n) {
            map.put(s.charAt(right), right++);
            
            if(map.size() == k) {
                if(right - left == k) {
                    result.add(s.substring(left,right));
                }
            }
            
            if(map.size() > k) {
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }
        }  
        return result; 
    }
	
	List function(String s,int k) {
	    List result= new ArrayList();
	    if(s == null || s.length() == 0 || s.length() < k)
	        return result;

	    int charCount[]= new int[26];
	    int len=s.length();
	    // tracks unique counts
	    int count=0;        

	    for(int i = 0; i < len; i++) {
	        // if unique, inc count
	        if(charCount[s.charAt(i)-'a'] == 0)     
	            count++;
	        // inc char count value in count tracker arr
	        charCount[s.charAt(i)-'a']++;
	        // if i is min of k-1 unique chars
	        if(i >= k-1) {
	            // holds the start index
	            int startIndex = i-k+1;
	            // if you've found k-1 unique chars, add to result
	            if(count == k -1){ //change to count == k if needed.
	            	String s1 = s.substring(startIndex,i+1);
	                if(!result.contains(s1)){
	                	result.add(s1);
	                }
	            }
	            // remove the count of start index from arr
	            charCount[s.charAt(startIndex)-'a']--;
	            // if start index element was unique, dec the count
	            if(charCount[s.charAt(startIndex)-'a'] == 0)
	                count--;
	        }	
	    }
	    return result;
	}
	public static void main(String[] args) {
		LongestSubstringKDistinct lgs = new LongestSubstringKDistinct();
		//List<String> list = lgs.subStringWithKDistinct("awaglknagawunagwkwagl", 4);
		System.out.println(lgs.function("awaglknagawunagwkwagl", 4));
		//System.out.println(list);
	}

}
