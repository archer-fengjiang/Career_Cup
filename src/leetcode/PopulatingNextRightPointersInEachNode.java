package leetcode;

import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree
 * 
 *     class TreeLinkNode {
 *       TreeLinkNode left;
 *       TreeLinkNode right;
 *       TreeLinkNode next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 * 
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *   	  / \  / \
 *     4->5->6->7 -> NULL
 * */
public class PopulatingNextRightPointersInEachNode {
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		public TreeLinkNode(int x) {
			this.val = x;
		}
	}
	
	public void connect(TreeLinkNode root){
		if(root == null){
			return;
		}
		List<TreeLinkNode> row = new LinkedList<TreeLinkNode>();
		row.add(root);
		while(!row.isEmpty()){
			List<TreeLinkNode> newRow  = new LinkedList<TreeLinkNode>();
			for(TreeLinkNode node : row){
				if(node.left != null){
					if(!newRow.isEmpty()){
						newRow.get(newRow.size() - 1).next = node.left;
					}
					newRow.add(node.left);
				}
				if(node.right != null){
					if(!newRow.isEmpty()){
						newRow.get(newRow.size() - 1).next = node.right;
					}
					newRow.add(node.right);
				}
			}
			for(int i = 0; i < newRow.size() - 1; i++){
				newRow.get(i).next = newRow.get(i + 1);
			}
			row = newRow;
		}
	}
}
