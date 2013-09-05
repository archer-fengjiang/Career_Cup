package c4_trees_graphs;

import java.beans.Visibility;
import java.util.Stack;


/**
 * Left -> Right -> Root
 * */
public class PostOrderTraversal {
	public void iterativePostOrder(Node node){
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		Node preNode = null;
		Node curNode = null;
		while(!stack.isEmpty()){
			curNode = stack.peek();
			if(preNode == null || preNode.left == curNode || preNode.right == curNode){
				if(curNode.left != null){
					stack.push(curNode.left);
				} else if(curNode.right != null) {
					stack.push(curNode.right);
				}
			} else if(curNode.left == preNode){
				if(curNode.right != null){
					stack.push(curNode.right);
				}
			} else {
				visit(curNode);
				stack.pop();
			}
			preNode = curNode;
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
		
		PostOrderTraversal tr = new PostOrderTraversal();
		System.out.println("iterative post order");
		tr.iterativePostOrder(nodearr[0]);
	}
}
