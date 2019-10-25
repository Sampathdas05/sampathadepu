package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnag {
	        
		    public List<List<String>> groupAnagrams2(String[] strs) {
		        Map<String, List<String>> anag = new HashMap<String, List<String>>();
		        String s1 = "";
		        for(String s : strs){
		            s1 = sort1(s1);
		            if(!anag.containsKey(s1)){
		                anag.put(s, new ArrayList<String>());
		            }
		            anag.get(s).add(s1);
		        }
		        return new ArrayList(anag.values());
		    }
		    

		    public static List<List<String>> groupAnagrams1(String[] strs) {
		        Map<String, List<String>> anag = new HashMap<String, List<String>>();
		        String s1 = "";
		        for(String s : strs){
		        	String s11 = new String ();
		            s1 = sort1(s);
		            if(!anag.containsKey(s1)){
		                anag.put(s1, new ArrayList<String>());
		            }
		            anag.get(s1).add(s);
		        }
		        
		        return new ArrayList(anag.values());
		    }
		    
		    private static String sort1(String s){
		        char[] c = s.toCharArray();
		        Arrays.sort(c);
		        return new String(c);
		    }
	public static void main(String[] args) {
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> anag = groupAnagrams1(strs);
		System.out.println(anag);
	}

}
