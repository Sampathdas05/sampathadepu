package SortAndSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// there is also bucket sort solution for k frequent questions.
public class KMostFrequentNumber {
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(nums.length == 0){
	            return list;
	        }
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
	        
	        for(int i : nums){
	            map.put(i, map.getOrDefault(i, 0) + 1);
	        }
	        
	        for(int i : map.keySet()){
	            pq.add(i);
	            if(pq.size() > k){
	                pq.poll();
	            }
	        }
	        
	        while(!pq.isEmpty()){
	            list.add(0, pq.poll());
	        }
	        return list;
	    }
	    //O(nlogk)
	    
// check this out for sure:
	    //https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
