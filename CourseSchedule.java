package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] indegree = new int[numCourses];
        
        for(int i=0; i<prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            
            List<Integer> list = map.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            map.put(src, list);
            indegree[dest]++;
        }
        
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        int id = 0;
        while(!que.isEmpty()){
            int src = que.poll();
            id++;
            if(map.containsKey(src)){
                for(Integer i : map.get(src)){
                    indegree[i]--;
                if(indegree[i] == 0){
                    que.add(i);
                }
                }
            }
        }
        return numCourses == id;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
