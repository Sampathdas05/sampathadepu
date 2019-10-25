package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        	Map<Integer, List<Integer>> map = new HashMap();
		int[] indegree = new int[numCourses];
		int[] topologicalSort = new int[numCourses];

		for(int i=0; i<prerequisites.length; i++){
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];

			List<Integer> list = map.getOrDefault(src, new ArrayList<Integer>());
			list.add(dest);
			indegree[dest]++;
			map.put(src, list);
		}
		Queue<Integer> que = new LinkedList<Integer>();

		for(int i=0; i<indegree.length; i++){
			if(indegree[i] == 0){
				que.add(i);
			}
		}
		int id = 0;

		while(!que.isEmpty()){
			int src = que.poll();
			topologicalSort[id++] = src; 
			if(map.containsKey(src)){
				for(int i : map.getOrDefault(src, new ArrayList<Integer>())){
					indegree[i]--;
	                if(indegree[i] == 0){
					que.add(i);
				}
				}
			}
		}
		if(id == numCourses){
			return topologicalSort;
		}
		return new int[0];
	    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
