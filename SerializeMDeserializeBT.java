package Design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class SerializeMDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }
    public String serializeHelper(TreeNode root, String curr){
        if(root == null){
            curr += "null,";
        }
        else{
            curr += String.valueOf(root.val) + ",";
            curr = serializeHelper(root.left, curr);
            curr = serializeHelper(root.right, curr);
        }
        return curr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(str));
        return rdeserialize(list);
    }
      public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }
      class TreeNode{
    	  TreeNode left;
    	  TreeNode right;
    	  int val;
    	  
    	  TreeNode(int val){
    		  this.val = val;
    	  }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
