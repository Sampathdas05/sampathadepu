package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAmazon {
	
	   public List<String> reOrder(List<String> logs) {
	        Comparator<String> comp = new Comparator<String>(){
	        	@Override
	            public int compare(String s1, String s2){
	                int s1ind = s1.indexOf(' ');
	                int s2ind = s2.indexOf(' ');
	                char c1 = s1.charAt(s1ind+1);
	                char c2 = s2.charAt(s2ind+1);
	                
	                if(c1 <= '9'){
	                    if(c2 <= '9'){
	                        return 0;
	                    }
	                    else{
	                        return 1;
	                    }
	                }
	                if(c2 <= '9'){
	                    return -1;
	                }
	                
	                int val = s1.substring(s1ind+1).compareTo(s2.substring(s2ind+1));
	                if(val == 0) return  s1.substring(0, s1ind).compareTo(s2.substring(0, s2ind));
	                return val;
	            }
	        };
	        Collections.sort(logs, comp);
	        return logs;
	    }

	public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			list.add("ykc 82 01");
			list.add("eo first qpx");
			list.add("09z cat hamster");
			list.add("06f 12 25 6");
			list.add("az0 first qpx");
			list.add("236 cat dog rabbit snake");
			SortAmazon sor = new SortAmazon();
			List<String> list1 = sor.reOrder(list);
			for(String s : list1)
			System.out.println(s);
	}

}
