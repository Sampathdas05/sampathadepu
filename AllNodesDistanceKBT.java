package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import TreesAndGraphs.DiameterOfABT.TreeNode;
//https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/allNodesDistanceKFromStart.java
public class AllNodesDistanceKBT {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap();
        preOrderForMappingParent(root, null, map);
        
        Queue<TreeNode> que = new LinkedList();
        que.add(target);
        
        Set<TreeNode> seen = new HashSet<TreeNode>();
        seen.add(target);
        int currLevel = 0;
        
        while(!que.isEmpty()){
            if(currLevel == K){
                return extractResult(que);
            }    
            int size = que.size();
            for(int i=0; i<size; i++){
                TreeNode node = que.poll();
                
                if(node.left != null && !seen.contains(node.left)){
                    seen.add(node.left);
                    que.add(node.left);
                }
                if(node.right != null && !seen.contains(node.right)){
                    seen.add(node.right);
                    que.add(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent != null && !seen.contains(parent)){
                    seen.add(parent);
                    que.add(parent);
                }
            }
            currLevel++;
        }
        return new ArrayList<Integer>();
    }
    public List<Integer> extractResult(Queue<TreeNode> que){
        List<Integer> list = new ArrayList<Integer>();
        while(!que.isEmpty()){
            list.add(que.poll().val);
        }
        return list;
    }
    public void preOrderForMappingParent(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(node == null){
            return;
        }
        map.put(node, parent);
        preOrderForMappingParent(node.left, node, map);
        preOrderForMappingParent(node.right, node, map);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
