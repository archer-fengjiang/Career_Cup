package leetcode;
/**
 * Path SumOct 14 '126653 / 15901
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * completed by Fengjiang Li on 9/11/2013
 * */
public class PathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		return helperDriver(root, 0, sum);
    }
	
	private boolean helperDriver(TreeNode node, int curSum, int sum){
		if(node == null){
			return false;
		}
		
		if(node.left == null && node.right == null){
			if(node.val + curSum == sum){
				return true;
			}else{
				return false;
			}
		}
		return helperDriver(node.left, curSum + node.val, sum) || helperDriver(node.right, curSum + node.val, sum);
	}
}