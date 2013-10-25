package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return list;
        }
        Arrays.sort(num);
        Stack<Integer> stack = new Stack<Integer>();
        
        helperDriver(num, 0, stack, list);
        return list;
    }

    private void helperDriver(int[] num, int pos, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list){
        if(pos == num.length){
            list.add(stackToList(stack));
            return;
        }
        if(!stack.isEmpty() && stack.peek().intValue() == num[pos]){
        	stack.push(new Integer(num[pos]));
        	helperDriver(num, pos + 1, stack, list);
        } else {
        	helperDriver(num, pos + 1, stack, list);
        	stack.push(new Integer(num[pos]));
        	helperDriver(num, pos + 1, stack, list);
        }
        stack.pop();
        return;
    }

    private ArrayList<Integer> stackToList(Stack<Integer> stack){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer I : stack){
            list.add(I);
        }
        return list;
    }
}