package chapter4.tree.graph;

import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 * Design an algroithm and write code to find the first common ancestor of two nodes in a binary tree
 * Avoid storing nodes in a data structure. NOTE: this is not necessarily a binary search tree
 * @author Fengjiang.
 *         Created May 27, 2012.
 */
public class C4_6 {
	public class Node{
		protected Node left;
		protected Node right;
		protected String content;
	}
	
	public Node finaFirstCommonAncestor(Node root, Node n1, Node n2){
		ArrayList<Node> sq1 = new ArrayList<Node>();
		ArrayList<Node> sq2 = new ArrayList<Node>();
		isInSubTree(root, n1, sq1);
		isInSubTree(root, n2, sq2);
		Node firstCommonNode = null;
		int lastIndex1 = sq1.size() - 1;
		int lastIndex2 = sq2.size() - 1;
		for(int i = 0; i < sq1.size() && i < sq2.size(); i++){
			if(sq1.get(lastIndex1 - i) == sq2.get(lastIndex2 - i))
				firstCommonNode = sq1.get(lastIndex1 - i);
			else
				break;
		}
		return firstCommonNode;
	}
	
	private boolean isInSubTree(Node parent, Node n, ArrayList<Node> sequenceArr){
		if(parent == null)
			return false;
		if(parent == n){
			sequenceArr.add(parent);
			return true;
		}
		if(isInSubTree(parent.left, n, sequenceArr)){
			sequenceArr.add(parent);
			return true;
		}
		if(isInSubTree(parent.right, n, sequenceArr)){
			sequenceArr.add(parent);
			return true;
		}
		return false;
	}
}
