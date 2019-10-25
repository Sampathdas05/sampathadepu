package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidWords {
    Set<String> set;
    Set<String> set1;
    public ValidWords(String[] dictionary) {
        set1 = new HashSet<>(Arrays.asList(dictionary));
        set = new HashSet();
        for(String str : set1){
            set.add(toAbbr(str));
        }
    }
    
    public boolean isUnique(String word) {
        if(set.contains(toAbbr(word)) || set1.contains(word)){
            return false;
        }
        return true;
    }
    
    public String toAbbr(String s){
        int n = s.length();
        if(n<=2){
            return s;
        }
        return s.charAt(0) + Integer.toString(n-2) + s.charAt(n-1);
    }
}
