package leetcode.ch;

import java.util.HashMap;

public class PopulatingNextRightPointersInEachNode {
	
	
	 // Definition for binary tree with next pointer.
	  public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
	
	  
	    public void connect(TreeLinkNode root) {
	    	if (root== null) {
	    		return;
	    	}
	    	HashMap<Integer, TreeLinkNode> list = new HashMap<Integer, TreeLinkNode>();
	    	this.recursive(root, 0,  list);
	    }
	    
	    void recursive(TreeLinkNode node, int depth, HashMap<Integer, TreeLinkNode> list) {
	    	if (node == null) {
	    		return;
	    	}
	    	TreeLinkNode curNode = list.get(depth);
	    	if (curNode == null) {
	    		list.put(depth, node);
	    	} else {
	    		curNode.next = node;
	    		list.put(depth, node);
	    	}
	    	this.recursive(node.left, depth +1, list);
	    	this.recursive(node.right, depth +1, list);
	    }
	
	    
	    public TreeLinkNode getTestNode() {
	    	TreeLinkNode node = new TreeLinkNode(0);
	    	return node;
	    }
		

}
