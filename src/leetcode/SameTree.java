package leetcode;
/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * */
public class SameTree {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        } else if((p == null && q!= null) || (p != null && q== null)){
        	return false;
        } else if(p.val != q.val){
        	return false;
        } else {
        	if(!isSameTree(p.left, q.left)){
        		return false;
        	}if(!isSameTree(p.right, q.right)){
        		return false;
        	}
        }
        return true;
    }
}
