package leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * */
public class Triangle {
	public class Node{
		int sum;
		Node nextNode;
		
		public Node(int i){
			this.sum = i;
			this.nextNode = null;
		}
	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null){
			return 0;
		}
		int len = triangle.size();
		ArrayList<ArrayList<Node>> nodeTriangle = new ArrayList<ArrayList<Node>>();
		for(ArrayList<Integer> array : triangle){
			ArrayList<Node> nodeArray = new ArrayList<Node>();
			for(Integer i : array){
				nodeArray.add(new Node(i));
			}
			nodeTriangle.add(nodeArray);
		}
		
		for(int row = len - 2; row >= 0; row--){
			ArrayList<Node> array = nodeTriangle.get(row);
			ArrayList<Node> belowArray = nodeTriangle.get(row + 1);
			for(int col = 0; col < array.size(); col++){
				if(belowArray.get(col).sum < belowArray.get(col + 1).sum){
					array.get(col).sum += belowArray.get(col).sum;
					array.get(col).nextNode = belowArray.get(col);
				}else{
					array.get(col).sum += belowArray.get(col + 1).sum;
					array.get(col).nextNode = belowArray.get(col + 1);
				}
			}
		}
		
		return nodeTriangle.get(0).get(0).sum;
    }
}
