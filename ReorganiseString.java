package ArraysAndStrings;

import java.util.PriorityQueue;

public class ReorganiseString {
	   public String reorganizeString(String S) {
	        int n = S.length();
	        int[] count = new int[26];
	        for(char c : S.toCharArray()){
	            count[c - 'a']++;
	        }
	        PriorityQueue<Helper> pq = new PriorityQueue<Helper>((a1, a2) -> a1.count == a2.count ? a1.c - a2.c : a2.count - a1.count);
	        for(int i=0; i<26; i++){
	        	if(count[i] > 0){
	            if(count[i] > (n+1)/2) return "";
	            pq.add(new Helper((char)('a' + i), count[i]));
	        }
	        }
	        StringBuilder sb = new StringBuilder();
	        while(pq.size()>=2){
	            Helper h1 = pq.poll();
	            Helper h2 = pq.poll();
	            sb.append(h1.c);
	            h1.count--;
	            sb.append(h2.c);
	            h2.count--;
	            if(h1.count>0) pq.add(h1);
	            if(h2.count>0) pq.add(h2);
	        }
	        if(pq.size() >0){
	            sb.append(pq.poll().c);
	        }
	        return sb.toString();
	    }
	    class Helper{
	        char c;
	        int count;
	        public Helper(char c, int count){
	            this.c = c;
	            this.count = count;
	        }
	    }
	public static void main(String[] args) {
		ReorganiseString rs = new ReorganiseString();
		System.out.println(rs.reorganizeString("aaab"));
	}

}
