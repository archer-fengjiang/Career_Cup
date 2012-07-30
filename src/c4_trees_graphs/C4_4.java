package c4_trees_graphs;

import java.util.LinkedList;

/**
 * Problem 
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 * If you have a tree with depth D, you'll have D linked lists
 *
 * @author Fengjiang.
 *         Created May 27, 2012.
 */
public class C4_4 {
	
	public LinkedList<LinkedList<NodeBinaryTree>> buildLinkedList(NodeBinaryTree root){
		if(root == null)
			return null;
		LinkedList<LinkedList<NodeBinaryTree>> builtLinkedList = new LinkedList<LinkedList<NodeBinaryTree>>();
		LinkedList<NodeBinaryTree> tmpList = new LinkedList<NodeBinaryTree>();
		tmpList.add(root);
		builtLinkedList.add(tmpList);
		while(true){
			LinkedList<NodeBinaryTree> nextLevelList = new LinkedList<NodeBinaryTree>();
			for(int i = 0; i < tmpList.size(); i++){
				NodeBinaryTree tmpNode = tmpList.get(i);
				if(tmpNode.left != null){
					nextLevelList.add(tmpNode.left);
				}
				if(tmpNode.right != null){
					nextLevelList.add(tmpNode.right);
				}
			}
			if(nextLevelList.size() > 0){
				builtLinkedList.add(nextLevelList);
				tmpList = nextLevelList;
			}
			else{
				break;
			}
		}
		return builtLinkedList;
	}
}

