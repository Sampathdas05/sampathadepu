package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubString {

	   public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int max = 0;
	        for(int i=0; i<n; i++){
	            for(int j = i+1; j<=n; j++){
	                if(isUnique(i, j, s)){
	                    max = Math.max(max, j-i);
	                }
	            }
	        }
	        return max;
	    }
	    public static boolean isUnique(int start, int end, String s){
	        Set<Character> set = new HashSet<>();
	        for(int i= start; i<end; i++){
	            if(!set.add(s.charAt(i))){
	                return false;        
	            }   
	        }
	        return true;
	    }
	    public static int lengthOfLongestSubstringNew(String s) {
	        int n = s.length();
	        int max = 0; //int i =0; int j =0;
	        Set<Character> set = new HashSet<Character>();
	            for(int i=0; i<s.length(); i++){
	                if(!set.add(s.charAt(i))){
	                    max = Math.max(max, set.size());
	                    set.clear();
	                    set.add(s.charAt(i));
	                }
	            }
	        return Math.max(max, set.size());
	    }
	    public static int lengthOfLongestSubstringTwoDistinct(String s) {
	        if(s == null || s.isEmpty()){
	            return 0;
	        }
	        int n = s.length();
	        if(n < 3){
	            return n;
	        }
	        int[] distinct = new int[256];
	        int right = 0;
	        int left = 0;
	        int max = 0;
	        int count = 0;
	        //s = s.toLowerCase();
	        while(right<n){
	            if(distinct[s.charAt(right) - 'A']++ == 0){
	                count++;
	            }
	            while(count > 2){
	                if(--distinct[s.charAt(left++) - 'A'] == 0){
	                    count--;
	                }
	            }
	            max = Math.max(max, (right - left) + 1);
	            right++;
	        }
	        return max;
	    }
	public static void main(String[] args) {
		int d = 8;
		System.out.println((int)Math.pow(2, d) - 1);
		System.out.println((int) (1<<d)-1);
		System.out.println(lengthOfLongestSubstringTwoDistinct("abcabcbb"));
	}

}
