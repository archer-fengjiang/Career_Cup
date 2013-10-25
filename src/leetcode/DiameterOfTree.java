package leetcode;

public class DiameterOfTree {
	private class Node {
		Node left, right;
		int data;
		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}
	
	static int maxValue;
	static int diameterOfThree(Node root){
		DiameterOfTree.maxValue = 0;
		helperDriver(root);
		return maxValue;
	}
	
	static private int helperDriver(Node node){
		if(node == null){
			return 0;
		}
		int leftVal = helperDriver(node.left);
		int righVal = helperDriver(node.right);
		if(leftVal + righVal + 1 > maxValue){
			maxValue = leftVal + righVal + 1;
		}
		if(leftVal > righVal){
			return leftVal + 1;
		} else {
			return righVal + 1;
		}
	}
}
