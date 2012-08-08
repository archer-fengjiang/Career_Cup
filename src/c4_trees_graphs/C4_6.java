package c4_trees_graphs;

import java.util.ArrayList;

/**
 * Design an algroithm and write code to find the first common ancestor of two nodes in a binary tree
 * Avoid storing nodes in a data structure. NOTE: this is not necessarily a binary search tree
 * 
 * @author Fengjiang.
 *         Created May 27, 2012.
 */
public class C4_6 {
	private static int RET_NOT_FOUND;
	private static int RET_ONE_FOUND;
	private static int RET_TWO_FOUND;
	private int cover(NodeBinaryTree root, NodeBinaryTree p, NodeBinaryTree q){
		if(root == null)
			return RET_NOT_FOUND;
		int ret = RET_NOT_FOUND;
		if(root == p || root == q){
			ret += 1;
		}
		ret += cover(root.left, p, q);
		ret += cover(root.right, p, q);
		return ret;
	}
	
	public NodeBinaryTree findFirstCommonAncestor(NodeBinaryTree root, NodeBinaryTree p, NodeBinaryTree q){
		if(root == p || root == q)
			return root;
		int leftCount = cover(root.left, p, q);
		switch(leftCount){
		case 0:
				return findFirstCommonAncestor(root.right, p, q);
		case 1:
				return root;
		case 2:
				return findFirstCommonAncestor(root.left, p, q);
		}
		return null;
	}
	
	public static void main(String[] args){
		NodeBinaryTree[] nodes = new NodeBinaryTree[10];
		for(int i = 0; i < nodes.length; i++){
			nodes[i] = new NodeBinaryTree();
			nodes[i].content = Integer.toString(i);
		}
		
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		
		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		
		nodes[2].left = nodes[5];
		nodes[2].right = nodes[6];
		
		nodes[3].left = nodes[7];
		
		nodes[4].right = nodes[8];
		
		nodes[6].left = nodes[9];
		
		C4_6 tester = new C4_6();
		System.out.println(tester.findFirstCommonAncestor(nodes[0], nodes[5], nodes[0]).content);
	}
}
