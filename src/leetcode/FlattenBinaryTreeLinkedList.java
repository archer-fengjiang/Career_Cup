package leetcode;
/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *         4
 *           \
 *            5
 *            \
 *              6
 * */
public class FlattenBinaryTreeLinkedList {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
		if(root == null){
			return;
		}
		TreeNode right = root.right;
		TreeNode left = root.left;
		if(left != null){
			root.right = left;
			root.left = null;
			TreeNode rightMost = left;
			while(rightMost.right != null){
				rightMost = rightMost.right;
			}
			rightMost.right = right;
		}
		
		flatten(root.right);
    }
	
	public static void main(String[] args){
		FlattenBinaryTreeLinkedList s = new FlattenBinaryTreeLinkedList();
		TreeNode root = s.new TreeNode(1);
		s.flatten(root);
	}
}
