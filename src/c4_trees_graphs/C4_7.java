package c4_trees_graphs;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2
 * with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1
 *
 * @author Fengjiang.
 *         Created Aug 4, 2012.
 */
public class C4_7 {
	private boolean isSubTree(NodeBinaryTree node, NodeBinaryTree root){
		if(node == null || !root.content.equals(node.content))
			return false;
		boolean left;
		boolean right;
		if(node.left != null){
			left = isSubTree(node.left, root.left);
		} else {
			left = true;
		}
		if(node.right != null){
			right = isSubTree(node.right, root.right);
		} else {
			right = true;
		}
		if(left && right){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean matchTree(NodeBinaryTree bigRoot, NodeBinaryTree smallRoot){
		if(bigRoot == null && smallRoot == null)
			return true;
		if(bigRoot == null || smallRoot == null)
			return false;
		if(bigRoot.content == smallRoot.content){
			if(isSubTree(bigRoot, smallRoot)){
				return true;
			}
		}
		return matchTree(bigRoot.right, smallRoot.right) || matchTree(bigRoot.left, smallRoot.left);
	}
	
	public static void main(String[] args){
		NodeBinaryTree[] nodes1 = new NodeBinaryTree[10];
		for(int i = 0; i < nodes1.length; i++){
			nodes1[i] = new NodeBinaryTree();
			nodes1[i].content = Integer.toString(i);
		}
		
		NodeBinaryTree[] nodes2 = new NodeBinaryTree[4];
		for(int i = 0; i < nodes2.length; i++){
			nodes2[i] = new NodeBinaryTree();
			nodes2[i].content = Integer.toString(i) + 3;
		}
		
		nodes1[0].left = nodes1[1];
		nodes1[0].right = nodes1[2];
		
		nodes1[1].left = nodes1[8];
		nodes1[1].right = nodes1[9];
		
		nodes1[2].left = nodes1[3];
		nodes1[2].right = nodes1[7];
		
		nodes1[3].left = nodes1[4];
		nodes1[3].right = nodes1[5];
		
		nodes1[5].right = nodes1[6];
		
		nodes2[0].left = nodes2[1];
		nodes2[0].right = nodes2[2];
		nodes2[2].right = nodes2[3];
		
		C4_7 tester = new C4_7();
		if(tester.matchTree(nodes1[0], nodes2[0]))
			System.out.println("is sub tree");
	}
}