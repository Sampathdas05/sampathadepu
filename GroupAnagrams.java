package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
            
        for(String s : strs){
            char[] c = s.toCharArray();
            
            Arrays.sort(c);
            String s1 = String.valueOf(c);
            if(!map.containsKey(s1)) map.put(s1, new ArrayList<String>());
            map.get(s1).add(s);
        }
        
        return new ArrayList(map.values());
    } // O(NKlogK)
    
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }// O(NK)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
