package ArraysAndStrings;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //do a breadth first search
        if(s==null || s.isEmpty() || wordDict == null || wordDict.size() == 0){
            return false;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        boolean[] visited = new boolean[s.length()];
        int start = 0;
        que.add(start);
        
        while(!que.isEmpty()){
            start = que.poll();
                if(!visited[start]){
                    for(int end=start+1; end<=s.length(); end++){
                if(wordDict.contains(s.substring(start, end))){
                    if(end == s.length()){
                        return true;
                    }
                    que.add(end);
                }
            }
            }
            visited[start] = true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
