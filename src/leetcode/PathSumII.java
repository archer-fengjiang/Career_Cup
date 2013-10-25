package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Path SumOct 14 '126653 / 15901
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Completed by Fengjiang Li on 9/12/2013
 * */
public class PathSumII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();
        helperDriver(root, list, sum, 0, stack);
        return list;
    }

    private void helperDriver(TreeNode node, ArrayList<ArrayList<Integer>> list, int sum, int curSum, Stack<Integer> stack){
        if(node == null){
            return;
        }
        
        
        if(node.left == null && node.right == null){
            if(curSum + node.val == sum){
                stack.push(new Integer(node.val));
                list.add(this.getArrayListFromStack(stack));
                stack.pop();
                return;
            }
            else{
            	return;
            }
        }
        
        stack.push(new Integer(node.val));
        helperDriver(node.left, list, sum, curSum + node.val, stack);
        helperDriver(node.right, list, sum, curSum + node.val, stack);
        stack.pop();
        return;
    }

    private ArrayList<Integer> getArrayListFromStack(Stack<Integer> stack){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(Integer i : stack){
            arr.add(i);
        }
        return arr;
    }
    
    public static void main(String[] args){
    	PathSumII ps = new PathSumII();
    	TreeNode root = ps.new TreeNode(1);
    	ArrayList<ArrayList<Integer>> list = ps.pathSum(root, 1);
    	for(ArrayList<Integer> arr : list){
    		for(Integer i : arr){
    			System.out.print(i);
    		}
    		System.out.println();
    	}
    }
}