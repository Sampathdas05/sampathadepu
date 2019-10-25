package TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import TreesAndGraphs.DiameterOfABT.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap();
Deque<TreeNode> stack = new ArrayDeque<>();        
        map.put(root, null);
        stack.push(root);
        
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                map.put(root.left, node);
                stack.push(root.left);
            }
            if(node.right != null){
                map.put(root.right, node);
                stack.push(root.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet();
        while(p!=null){
            ancestors.add(p);
            p = map.get(p);
        }
        while(!ancestors.contains(q)){
            q = map.get(q);
        }
        return q;
    }
    // O(N)
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
