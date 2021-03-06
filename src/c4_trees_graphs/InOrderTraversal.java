package c4_trees_graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * In order traversal without using recursive call
 * left -> root -> right
 * */
public class InOrderTraversal {
	public void recursiveInOrder(Node node){
		if (node == null)
			return;
		recursiveInOrder(node.left);
		visit(node);
		recursiveInOrder(node.right);
	}

	public void iterativeInOrder(Node node){
		if(node == null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || node != null){
			if(node != null){
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				visit(node);
				node = node.right;
			}
		}
	}
	
	private void visit(Node node){
		System.out.println(node.content);
	}
	
	public static void main(String[] args){
		Node[] nodearr = new Node[10];
		nodearr[0] = new Node("0");
		nodearr[1] = new Node("1");
		nodearr[2] = new Node("2");
		nodearr[3] = new Node("3");
		nodearr[4] = new Node("4");
		nodearr[5] = new Node("5");
		nodearr[6] = new Node("6");
		nodearr[7] = new Node("7");
		nodearr[8] = new Node("8");
		nodearr[9] = new Node("9");
	
		nodearr[0].left = nodearr[1];
		nodearr[0].right = nodearr[2];
		nodearr[1].left = nodearr[3];
		nodearr[1].right = nodearr[4];
		nodearr[2].left = nodearr[5];
		nodearr[2].right = nodearr[6];
		nodearr[3].left = nodearr[7];
		nodearr[4].right = nodearr[8];
		nodearr[6].left = nodearr[9];
		
		InOrderTraversal tr = new InOrderTraversal();
		System.out.println("iterative in order");
		tr.iterativeInOrder(nodearr[0]);
		System.out.println("recursive in order");
		tr.recursiveInOrder(nodearr[0]);
	}
}
