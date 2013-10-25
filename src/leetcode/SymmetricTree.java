package leetcode;


/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 * 
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * */
public class SymmetricTree {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return false;
		}
        return helperDriver(root.left, root.right);
    }
	
	private boolean helperDriver(TreeNode p, TreeNode q){
		if(p == null && q == null){
        	return true;
        } else if((p == null && q!= null) || (p != null && q== null)){
        	return false;
        } else if(p.val != q.val){
        	return false;
        } else {
        	if(!helperDriver(p.left, q.right)){
        		return false;
        	}if(!helperDriver(p.right, q.left)){
        		return false;
        	}
        }
        return true;
	}
}
