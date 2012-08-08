package c4_trees_graphs;

/**
 * Write an algorithm to find the 'next' node (e.g in-order successor) of a given node
 * in a binary search tree where each node has a link to its parent
 *
 * @author Fengjiang.
 *         Created May 27, 2012.
 */
public class C4_5 {
	public NodeBinaryTree findNextNode(NodeBinaryTree node){
		if(node == null)
			return null;
		if(node.right != null)
			return findLeftMostNode(node.right);
		if(node.parent == null)
			return null;
		else if(node == node.parent.left)
			return node.parent;
		else if(node == node.parent.right){
			while(node.parent != null){
				node = node.parent;
				if(node == node.parent.left)
					return node.parent;
			}
		}
		return null;
	}
	
	private NodeBinaryTree findLeftMostNode(NodeBinaryTree node){
		if(node == null)
			return null;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args){
		NodeBinaryTree[] nodes = new NodeBinaryTree[11];
		for(int i = 0; i < nodes.length; i++){
			nodes[i] = new NodeBinaryTree();
			nodes[i].content = Integer.toString(i);
		}
		
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].parent = nodes[0];
		nodes[2].parent = nodes[0];
		
		nodes[1].left = nodes[3];
		nodes[1].right = nodes[4];
		nodes[3].parent = nodes[1];
		nodes[4].parent = nodes[1];
		
		nodes[3].left = nodes[5];
		nodes[5].parent = nodes[3];
		
		nodes[4].left = nodes[6];
		nodes[4].right = nodes[7];
		nodes[6].parent = nodes[4];
		nodes[7].parent = nodes[4];
		
		nodes[7].left = nodes[8];
		nodes[8].parent = nodes[7];
		
		nodes[8].left = nodes[9];
		nodes[8].right = nodes[10];
		nodes[9].parent = nodes[8];
		nodes[10].parent = nodes[8];
		
		C4_5 tester = new C4_5();
		System.out.println(tester.findNextNode(nodes[10]).content);
	}
}
