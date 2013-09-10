package leetcode;

import leetcode.SumRootToLeaf.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 * */
public class BinaryTreeMaxPathSum {
	int maxSum;
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int i){
			this.val = i;
		}
	}
	
	public int maxPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		this.maxSum = Integer.MIN_VALUE;
		helperDriver(root);
		return this.maxSum;
	}
	
	private int helperDriver(TreeNode node){
		if(node == null){
			return 0;
		}
		int leftVal = helperDriver(node.left);
		int rightVal = helperDriver(node.right);
		// Update maxSum
		if(leftVal + node.val > this.maxSum){
			this.maxSum = leftVal + node.val;
		}
		if(rightVal + node.val > this.maxSum){
			this.maxSum = rightVal + node.val;
		}
		if(leftVal + rightVal + node.val > this.maxSum){
			this.maxSum = leftVal + rightVal + node.val;
		}
		
		// pass val to next level
		int posValToPass = 0;
		if(leftVal >= rightVal){
			posValToPass = leftVal + node.val;
		}else{
			posValToPass = rightVal + node.val;
		}
		
		if(posValToPass > 0){
			return posValToPass;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args){
		TreeNode[] arr = new TreeNode[10];
    	BinaryTreeMaxPathSum sum = new BinaryTreeMaxPathSum();
    	for(int i = 0; i < arr.length; i++){
    		arr[i] = sum.new TreeNode(i);
    	}
    	
    	arr[0].left = arr[1];
    	arr[0].right = arr[2];

        arr[1].left = arr[3];
        arr[1].right = arr[4];

        arr[2].left = arr[5];
        arr[2].right = arr[6];

        arr[3].left = arr[7];
        arr[4].right = arr[8];

        arr[5].left = arr[9];
        
        System.out.println(sum.maxPathSum(arr[0]));
        System.out.println(sum.maxPathSum(sum.new TreeNode(-3)));
	}
}
