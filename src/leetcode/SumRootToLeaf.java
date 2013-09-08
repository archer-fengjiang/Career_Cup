/**
  * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
  *
  * An example is the root-to-leaf path 1->2->3 which represents the number 123.
  *
  * Find the total sum of all root-to-leaf numbers.
  *
  * For example,
  *
  *     1
  *    / \
  *   2   3
  * The root-to-leaf path 1->2 represents the number 12.
  * The root-to-leaf path 1->3 represents the number 13.
  * 
  * Return the sum = 12 + 13 = 25.
  *
*/

package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SumRootToLeaf{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }

    public int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        Map<TreeNode, List<Integer>> map = new HashMap<TreeNode, List<Integer>>();
        sumDriver(root, map);
        int sum = 0;
        Iterator<TreeNode> itr = map.keySet().iterator();
        while(itr.hasNext()){
            TreeNode node = itr.next();
            List<Integer> list = map.get(node);
            for(Integer i : list){
                sum += i;
            }
        }
        return sum;
    }

    private void sumDriver(TreeNode curNode, Map<TreeNode, List<Integer>> map){
        if(curNode == null){
            return;
        }
        sumDriver(curNode.left, map);
        sumDriver(curNode.right, map);
        List<Integer> curNodeList = new LinkedList<Integer>();
        List<Integer> leftNodeList = map.get(curNode.left);
        List<Integer> rightNodeList = map.get(curNode.right);
        if(leftNodeList != null){
            for(Integer i : leftNodeList){
                curNodeList.add(new Integer(addDigitToNum(curNode.val, i)));
            }
        }
        if(rightNodeList != null){
            for(Integer i : rightNodeList){
                curNodeList.add(new Integer(addDigitToNum(curNode.val, i)));
            }
        }
        if(curNode.left != null){
            curNodeList.add(new Integer(addDigitToNum(curNode.val, curNode.left.val)));
        }
        if(curNode.right != null){
            curNodeList.add(new Integer(addDigitToNum(curNode.val, curNode.right.val)));
        }
        map.put(curNode, curNodeList);
    }

    private int addDigitToNum(int digit, int num){
        int digitCount = 0;
        int originNum = num;
        while((originNum /= 10) > 0){
            digitCount++;
        }
        return (int) (num + digit * Math.pow(10, digitCount + 1));
    }
    
    
    public static void main(String[] args){
    	TreeNode[] arr = new TreeNode[10];
    	SumRootToLeaf sum = new SumRootToLeaf();
    	for(int i = 0; i < arr.length; i++){
    		arr[i] = sum.new TreeNode(i);
    	}
    	
    	arr[0].left = arr[1];
    	arr[0].right = arr[2];

        arr[1].left = arr[3];
        arr[1].right = arr[4];

        arr[2].left = arr[5];
        arr[2].right = arr[6];

        arr[3].left = arr[7];
        arr[4].right = arr[8];

        arr[5].left = arr[9];

        System.out.println(sum.sumNumbers(arr[0]));
    }
}