package leetcode.ch;

public class SumRootToLeafNumbers {
	
	
	
	//  Definition for binary tree
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
		
		int sum;
	  
		public int sumNumbers(TreeNode root) {
			sum = 0;
			this.recursiveSum(0, root);
			return sum;
	    }
		
		
		public void recursiveSum(int prevSum, TreeNode nodes) {
			
			if (nodes == null) {
				return;
			}
			
			int curSum = prevSum * 10 + nodes.val;
			//leaf node
			if (nodes.left == null && nodes.right == null) {
				this.sum += curSum;
			} 
			//
			recursiveSum(curSum, nodes.left);
			recursiveSum(curSum, nodes.right);
		}
		
		
	}
	
	
	
	
	
	

}
