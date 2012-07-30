package c4_trees_graphs;

import java.util.LinkedList;

/**
 * TODO 
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 * If you have a tree with depth D, you'll have D linked lists
 *
 * @author Fengjiang.
 *         Created May 27, 2012.
 */
public class C4_4 {
	
	public LinkedList<LinkedList<Node>> buildLinkedList(Node root){
		if(root == null)
			return null;
		LinkedList<LinkedList<Node>> builtLinkedList = new LinkedList<LinkedList<Node>>();
		LinkedList<Node> tmpList = new LinkedList<Node>();
		tmpList.add(root);
		builtLinkedList.add(tmpList);
		while(true){
			LinkedList<Node> nextLevelList = new LinkedList<Node>();
			for(int i = 0; i < tmpList.size(); i++){
				Node tmpNode = tmpList.get(i);
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

