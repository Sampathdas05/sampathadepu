package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        int n = words.length;
        if(n == 0){
            return list;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                String s = words[i] + words[j];
                if(ispalind(s)){
                    List<Integer> ls = new ArrayList<>(Arrays.asList(i,j));
                    list.add(ls);
                }
                s =words[j] + words[i];
                if(ispalind(s)){
                    List<Integer> ls = new ArrayList<>(Arrays.asList(j,i));
                    list.add(ls); 
                }
            }
        }
        return list;
    }
    public boolean ispalind(String s){
        for(int i=0, j=s.length()-1; i<j; i++, j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    
    //////////////////////
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
	public static void main(String[] args) {
			PalindromePairs pp = new PalindromePairs();
			String[] words = {"abcd","dcba","lls","s","sssll"};
			System.out.println(pp.palindromePairs(words));
	}

}
