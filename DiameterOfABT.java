package TreesAndGraphs;
//Complexity Analysis

//Time Complexity: O(N). We visit every node once.

//Space Complexity: O(N), the size of our implicit call stack during our depth-first search.

public class DiameterOfABT {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int value){
			this.val = value;
		}
	}
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        diameterHelper(root, max);
        return max[0];
    }
    public int diameterHelper(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        
        int left = diameterHelper(root.left, max);
        int right = diameterHelper(root.right, max);
        
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
