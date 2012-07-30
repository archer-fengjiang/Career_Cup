package c4_trees_graphs;

import java.util.List;

/**
 * Problem:
 * Given a sorted(increasing order) array, write an algorithm to create a
 * binary tree with minimal height
 *
 * @author Fengjiang.
 *         Created Jul 29, 2012.
 */
public class C4_3 {
	public NodeBinaryTree builtBinaryTree(int[] array){
		int length = array.length;
		if(length < 1)
			return null;
		
		return this.buildHelper(array, 0, length - 1);
	}
	
	private NodeBinaryTree buildHelper(int[] array, int startPos, int endPos){
		if(startPos > endPos)
			return null;
		int midPos = (startPos + endPos) / 2;
		NodeBinaryTree node = new NodeBinaryTree();
		node.content = Integer.toString(array[midPos]);
		node.left = this.buildHelper(array, startPos, midPos - 1);
		node.right = this.buildHelper(array, midPos + 1, endPos);
		return node;
	}
	
	public static void main(String[] args){
		int[] array = new int[100];
		for(int i = 0 ; i < array.length; i++){
			array[i] = i;
		}
		
		C4_3 binaryTreeBuilder = new C4_3();
		C4_1 treeListBuilder = new C4_1();
		NodeBinaryTree root = binaryTreeBuilder.builtBinaryTree(array);
		List<List<NodeBinaryTree>> list = treeListBuilder.buildLinkedList(root);
		for(List<NodeBinaryTree> subList : list){
			for(NodeBinaryTree node : subList){
				System.out.print(node.content + ":");
			}
			System.out.println();
		}
	}
}