package leetcode.ch;

public class BinaryTreeMaximumPathSum {
	
	
	
	 // Definition for binary tree
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
		
		
		int maxPathSum = 0;
		
	    public int maxPathSum(TreeNode root) {
	        
	    	this.maxPathSum = Integer.MIN_VALUE;
	    	this.recursive(root);
	    	return this.maxPathSum;
	    }
	    
	    
	    int recursive(TreeNode nodes) {
	
	    	if (nodes == null) {
	    		return 0;
	    	}
	    	
	    	int leftMax = this.recursive(nodes.left);
	    	int rightMax = this.recursive(nodes.right);
	    	
	    	this.maxPathSum = Math.max(this.maxPathSum, nodes.val + leftMax);
	    	this.maxPathSum = Math.max(this.maxPathSum, nodes.val + rightMax);
	    	this.maxPathSum = Math.max(this.maxPathSum, nodes.val + rightMax + leftMax);
	    	this.maxPathSum = Math.max(this.maxPathSum, nodes.val);
	    	
	    	return Math.max(Math.max(nodes.val, nodes.val + leftMax), nodes.val + rightMax); 
	    	
	    }
	    
	    
	    
	    
	}

	
	
	

}
