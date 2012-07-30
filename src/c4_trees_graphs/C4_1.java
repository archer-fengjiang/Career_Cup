package c4_trees_graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given a binary search tree, design an algorithm which creates a linked
 * list of all the nodes at each depth (eg, if you have a tree with depth D, 
 * you will have D linked lists)
 *
 * Solution:
 * Adopts breadth-first search in the tree, keep track of list of nodes on each
 * level
 * 
 * @author Fengjiang.
 *         Created Jul 29, 2012.
 */
public class C4_1 {
	public List<List<NodeBinaryTree>> buildLinkedList(NodeBinaryTree root){
		List<List<NodeBinaryTree>> builtList = new LinkedList<List<NodeBinaryTree>>();
		if(root == null)
			return builtList;
		List<NodeBinaryTree> prevLvlNodes = new LinkedList<NodeBinaryTree>();
		List<NodeBinaryTree> currLvlNodes = prevLvlNodes;
		prevLvlNodes.add(root);
		builtList.add(currLvlNodes);
		while((currLvlNodes = this.getNextLvlNodes(prevLvlNodes)).size() > 0){
			builtList.add(currLvlNodes);
			prevLvlNodes = currLvlNodes;
		}
		return builtList;
	}
	
	private List<NodeBinaryTree> getNextLvlNodes(List<NodeBinaryTree> prevLvlNodes){
		List<NodeBinaryTree> nextLvlNodes = new LinkedList<NodeBinaryTree>();
		if(prevLvlNodes == null)
			return nextLvlNodes;
		for(NodeBinaryTree node : prevLvlNodes){
			if(node.left != null)
				nextLvlNodes.add(node.left);
			if(node.right != null)
				nextLvlNodes.add(node.right);
		}
		return nextLvlNodes;
	}
	
	public static void main(String[] args){
		NodeBinaryTree[] nodes = new NodeBinaryTree[10];
		for(int i = 0 ; i < 10 ; i++){
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
		
		C4_1 builder = new C4_1();
		List<List<NodeBinaryTree>> builtList = builder.buildLinkedList(nodes[0]);
		for(List<NodeBinaryTree> list : builtList){
			for(NodeBinaryTree node : list){
				System.out.print(node.content);
			}
			System.out.println();
		}
	}
}
