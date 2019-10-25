package TreesAndGraphs;

import TreesAndGraphs.DiameterOfABT.TreeNode;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathHelper(root);
        return max;
    }
    public int maxPathHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = Math.max(maxPathHelper(root.left), 0);
        int right = Math.max(maxPathHelper(root.right),0);
        int val = left + right + root.val;
        max = Math.max(max, val);
        return Math.max(left, right) + root.val;
    }
    //O(N)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
