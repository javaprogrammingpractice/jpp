package leetcode.ch;

public class PathSum {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean hasPathSum = false;

	public boolean hasPathSum(TreeNode root, int sum) {
		this.hasPathSum = false;
		this.recursive(root, 0, sum);
		return this.hasPathSum;
	}

	void recursive(TreeNode nodes, int prevSum, int sum) {

		if (this.hasPathSum) {
			return;
		} else if (nodes == null) {
			return;
		}

		//leaf node
		if (nodes.left == null && nodes.right == null) {
			if ((prevSum + nodes.val) == sum) {
				this.hasPathSum = true;
				return;
			} else {
				return;
			}
		}

		
		if (nodes.left != null) {
			this.recursive(nodes.left, prevSum + nodes.val, sum);
		}

		if (nodes.right != null) {
			this.recursive(nodes.right, prevSum + nodes.val, sum);
		}
	}

}
