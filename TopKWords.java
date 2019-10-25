package SortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        PriorityQueue<String> pq = new PriorityQueue<String>(
        	(s1, s2) -> map.get(s1).equals(map.get(s2)) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s  :  map.keySet()){
            pq.add(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> list = new ArrayList<String>();
        while(!pq.isEmpty())
            list.add(0,pq.poll());
            //Collections.reverse(list);
        return list;
    }
    
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
	public static void main(String[] args) {
		TopKWords top = new TopKWords();
		System.out.println(top.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
		System.out.println(top.topKFrequent1(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
				
	}

}
