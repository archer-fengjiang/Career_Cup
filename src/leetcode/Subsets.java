package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * */
public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0){
            return list;
        }
        Arrays.sort(S);
        Stack<Integer> stack = new Stack<Integer>();
        
        helperDriver(S, 0, stack, list);
        return list;
	}

    private void helperDriver(int[] S, int pos, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list){
        if(pos == S.length){
            list.add(stackToList(stack));
            return;
        }
        helperDriver(S, pos + 1, stack, list);
        stack.push(new Integer(S[pos]));
        helperDriver(S, pos + 1, stack, list);
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

    public static void main(String[] args){
        int[] S = {1,2,3};
        Subsets sb = new Subsets();
        ArrayList<ArrayList<Integer>> list = sb.subsets(S);
        for(ArrayList<Integer> arr : list){
            for(Integer I : arr){
                System.out.print(I);
            }
            System.out.println();
        }
    }
}
