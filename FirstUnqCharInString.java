package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
First Unique Character in a String
  Go to Discuss
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 * @author SA044034
 *
 */
public class FirstUnqCharInString {
	   public int firstUniqChar(String s) {
		   
	        List<Character> list = new ArrayList<Character>();
	        for(Character cha : s.toCharArray()){
	            list.add(cha);
	        }
	        for(int i = 0; i<s.length(); i++){
	            if(Collections.frequency(list, s.charAt(i)) == 1){
	                return i;
	            }
	        }
	        return -1;
	}
	   public int firstUniqChar3(String s) {
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        for(char c : s.toCharArray()){
	            map.put(c, map.getOrDefault(c,0)+1);
	        }
	        for(Map.Entry<Character,Integer> set : map.entrySet()){
	            if(set.getValue() == 1){
	                return set.getKey();
	            }
	        }
	        return -1;
	    }
	   public int firstUniqChar1(String s) {
	        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	        int n = s.length();
	        // build hash map : character and how often it appears
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            count.put(c, count.getOrDefault(c, 0) + 1);
	        }
	        
	        // find the index
	        for (int i = 0; i < n; i++) {
	            if (count.get(s.charAt(i)) == 1) 
	                return i;
	        }
	        return -1;
	    }
	   
	   public int firstUniqChar2(String s) {
	        
	        HashMap<Character, Integer> charList = new HashMap<Character, Integer>(s.length());
	        
	        for(char c : s.toCharArray()){
	            if(charList.containsKey(c)){
	                charList.put(c, charList.get(c) + 1);
	            }
	            else{
	                charList.put(c, 0 + 1);
	            }
	        }
	        
	        for(int i=0; i<s.length(); i++){
	            
	            if(charList.get(s.charAt(i)) == 1){
	                return i;
	            }
	        }
	        return -1;     
	    }
		public static boolean isUniqueChars(String str) {
			if (str.length() > 128) {
				return false;
			}
			boolean[] char_set = new boolean[128];
			for (int i = 0; i < str.length(); i++) {
				int val = str.charAt(i);
				if (char_set[val]) return false;
				char_set[val] = true;
			}
			return true;
		}
		   public static int firstUniqChar31(String s) {
		        int[] c = new int[26];
		        Arrays.fill(c,0);
		        for(int i =0; i<s.length(); i++){
		            c[s.charAt(i) - 'a']++;
		        }
		        for(int i=0; i<s.length(); i++){
		            if(c[s.charAt(i) - 'a'] == 1){
		                return i;
		            }
		        }
		        return -1;
		    }
	    
		public static boolean isPalindrome(String s){
			List<Character> list = new ArrayList<Character>();
			for(Character c : s.toLowerCase().toCharArray()){
				if(Character.isLetter(c)){
					list.add(c);
				}
			}
			int odd = 0;
			for(int i=0; i<s.length(); i++){
				if(Collections.frequency(list, s.charAt(i)) % 2 ==1){
					odd++;
				}
			}
			if(odd>=2){
				return false;
			}
			return true;
		}
		public class Solution {
		    public boolean canPermutePalindrome(String s) {
		        Set < Character > set = new HashSet < > ();
		        for (int i = 0; i < s.length(); i++) {
		            if (!set.add(s.charAt(i)))
		                set.remove(s.charAt(i));
		        }
		        return set.size() <= 1;
		    }
		}

		
		public static void main(String[] args) {
			firstUniqChar31("leetcode");
			String[] words = {"abcde", "hello", "apple", "kite", "padle"};
			for (String word : words) {
				System.out.println(word + ": " + isUniqueChars(word));
			}
			String[] strings = {"Rats live on no evil star",
					"A man, a plan, a canal, panama",
					"Lleve",
					"Tacotac",
					"asda"};
for (String s : strings) {
	System.out.println(isPalindrome(s));
	
}

		}

}
