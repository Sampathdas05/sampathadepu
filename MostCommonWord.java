package AmazonOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public List mostCommonWord(String paragraph, List<String> banned) {
        paragraph += ".";
        Set<String> banset = new HashSet<String>();
        for(String s : banned){
            banset.add(s.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> ans = new ArrayList<String>();
        int max = 0;
        StringBuilder word = new StringBuilder();
        for(char c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }
            else if(word.length() > 0){
                String s = word.toString();
                if(!banset.contains(s)){
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
                word = new StringBuilder();
            }
        }
        int val = Collections.max(map.values());
        for(Map.Entry<String, Integer> entry : map.entrySet()){
        	if(entry.getValue().equals(val)){
        		ans.add(entry.getKey());
        	}
        }
        return ans;
    }
    
    public List mostCommonWord1(String paragraph, List<String> bannedList) {
        List<String> result = new ArrayList<>();
        int n = paragraph.length();
        char[] paragraphArray = paragraph.toCharArray();
      
        Map<String, Integer> freqMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(Character.isLetter(paragraphArray[i])) {
                sb.append(paragraphArray[i]);
            }
                if(paragraphArray[i] == '\'' || paragraphArray[i] == ',' || paragraphArray[i] == ' ' || paragraphArray[i] == '.' || i == n - 1) {
                    String temp = sb.toString();
                    temp = temp.toLowerCase();
                    sb.setLength(0);
                    if(bannedList.indexOf(temp) < 0 && !temp.isEmpty()) {
                        int count = freqMap.getOrDefault(temp, 0);
                        freqMap.put(temp, count + 1);
                    }
                }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		MostCommonWord common = new MostCommonWord();
		System.out.println(common.mostCommonWord("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.",new ArrayList<>(Arrays.asList("and", "he", "the", "to", "is", "Jack", "Jill"))));
		System.out.println(common.mostCommonWord1("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.",new ArrayList<>(Arrays.asList("and", "he", "the", "to", "is", "Jack", "Jill"))));

	}
}
