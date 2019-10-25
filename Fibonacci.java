package ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {
	int prev = 0;
	int d =1;
	int x =1;
	int y =0;

	public int recursion(String[][] n){

	    Map<String, List<Integer>> map = new HashMap<>();
	    for(String[] s : n ){
	    	if(map.containsKey(s[0])){
	    		map.put(s[0], new ArrayList<>());
	    	}
	    	map.get(s[0]).add(Integer.parseInt(s[1]));
	    }
	    float avg = 0;
	    float val = Integer.MIN_VALUE;
	    String returk = null;
	    List<Integer> score = new ArrayList<>();
	    for(String key : map.keySet()){
	    	score = map.get(key);
	    	int sum = 0;
	    	for(int num : score){
	    		sum += num;
	    	}
	    	avg = sum/score.size();
	    	long x = 1;
	    	
	    	if(val != Integer.MAX_VALUE){
	    		Math.max(0, avg);
	    	}
	    }
	    
	    return x;
	}
	public static void main(String[] args) {
Fibonacci f = new Fibonacci();
String student[][] = {{"jerry","65"}, {"bob","1"}, {"jerry","23"},{"jerry","23"}, {"jerry","100"},{"Eric","83"}};
System.out.println(f.recursion(student));

	}

}
