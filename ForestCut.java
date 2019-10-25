package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ForestCut {
    public int cutOffTree(List<List<Integer>> forest) {
        //create a list of int[] {value, x, y}
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int value = forest.get(i).get(j);
                if (value > 1) trees.add(new int[]{i, j, value});
            }
        }
        
        Collections.sort(trees, (a, b)->(a[2]-b[2]));
        int res = 0, x = 0, y = 0;
        for (int[] tree: trees) {
            int dist = bfs(forest, x, y, tree[0], tree[1]);
            if (dist < 0) return -1;
            else {
                res += dist;
                x = tree[0];
                y = tree[1];
            }
        }
        return res;
    }
    public int bfs(List<List<Integer>> forest, int sr, int sc, int dr, int dt) {
        int r = forest.size();
        int c = forest.get(0).size();
        
        int[][] dir = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[r][c];
        
        Queue<Forest> que = new LinkedList<Forest>();
        que.add(new Forest(sr, sc, 0));
        visited[sr][sc] = true;
        
        while(!que.isEmpty()){
            Forest f = que.poll();
            int row = f.x;
            int col = f.y;
            int count = f.c;
            
            if(row == dr && col == dt){
                return count;
            }
            
            for(int i=0; i<4; i++){
                int roww = row + dir[i][0];
                int coll =  col + dir[i][1];
                
                if(roww < forest.size() && roww >=0 && coll <forest.get(0).size() && coll >=0 && forest.get(roww).get(coll) > 0){
                    if(!visited[roww][coll]){
                        que.add(new Forest(roww, coll, count+1));
                        visited[roww][coll] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    class Forest{
        int x;
        int y;
        int c;
        
        Forest(int xx, int yy, int cc){
            this.x = xx;
            this.y = yy;
            this.c = cc;
        }
    }

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList();
		List<Integer> l1 = new ArrayList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		list.add(l1);
		
		List<Integer> l2 = new ArrayList();
		l2.add(0);
		l2.add(0);
		l2.add(4);
		list.add(l2);
		
		List<Integer> l3 = new ArrayList();
		l3.add(7);
		l3.add(6);
		l3.add(5);
		list.add(l3);
		
		ForestCut f = new ForestCut();
		System.out.println(f.cutOffTree(list));
	}

}
