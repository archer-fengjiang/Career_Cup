package colleciton_qustions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given array [1,2,3....16], print out all possible re-order of array 
 * that adjacent element sums to be a square number(e.g 4, 16, 25....)
 * 
 * First I compute square arrange for the array, which is [4,9,16,25]
 * 
 * Then I will try to use every element in the input array as header 
 * of result list. I use recursion to traverse the path, all possible pairs
 * for value in current level of traversal will be tried, and stack is used
 * to maintain my "footprints" for each level in the recursion. Note no 
 * repeated element is allowed in the stack. A valid list is created when the
 * stack grow to size of input array.
 *
 * @author Fengjiang.
 *         Created Sep 13, 2012.
 */
public class Samsung_1 {
	private List<Integer>  squareList = new LinkedList<Integer>();
	private Map<Integer, Set<Integer>> pairMap = 
			new HashMap<Integer, Set<Integer>>();
	private List<List<Integer>> resultList = new LinkedList<List<Integer>>();
	private int[] inputArr;

	public void printSquareList(int[] arr){
		this.inputArr = arr;
		// First locate range of square
		int start_square_root = (int)Math.pow(arr[0] + arr[1], 0.5) + 1;
		int end_square_root = (int) Math.pow(arr[arr.length - 2] 
				+ arr[arr.length - 1], 0.5);
		
		// Form square lists
		for(int i = start_square_root; i <= end_square_root; i++){
			squareList.add(i * i);
		}
		System.out.println("available square number list:\n" + 
				squareList.toString() + "\n");
		
		// Creating possible pairs for each element in input list
		for(int i = 0; i < arr.length; i++){
			int tmp = arr[i];
			Set<Integer> pairSet = new HashSet<Integer>();
			for(int j = 0; j < squareList.size(); j++){
				int pairValue = squareList.get(j) - tmp;
				if(pairValue >= inputArr[0] && pairValue <= 
						inputArr[inputArr.length - 1] && pairValue != tmp){
					pairSet.add(pairValue);
				}
			}
			this.pairMap.put(tmp, pairSet);
		}
		System.out.println("possible neighbour pairs:\n" + 
				this.pairMap.toString() + "\n");
		
		// Try to create list beginning from each element
		// Use Stack to trace your footprints
		Stack<Integer> trace = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++){
			buildList(arr[i], trace);
		}
		
		// print out all result lists
		System.out.println("possible result arrays:");
		for(int i = 0; i < this.resultList.size(); i++){
			List<Integer> list = resultList.get(i);
			System.out.println(list.toString());
		}
	}
	
	private void buildList(int num, Stack<Integer> trace){
		trace.push(num); // push this value to go one level further
		if(trace.size() == inputArr.length){ // Traversal is completed 
			Stack<Integer> completeTrace = (Stack<Integer>) trace.clone();
			List<Integer> completeList = new LinkedList<Integer>();
			while(!completeTrace.isEmpty()){
				// Note order is reversed, but still a valid output
				// And we will cover all situations anyway
				completeList.add(completeTrace.pop());
			}
			resultList.add(completeList);
		}
		Set<Integer> pairSet = this.pairMap.get(num);
		Iterator itr = pairSet.iterator();
		while(itr.hasNext()){
			int pairVal = (Integer)itr.next();
			if(!trace.contains(pairVal)){
				buildList(pairVal, trace);
			}
		}
		trace.pop(); // pop the value to return one level back
	}
	
	public static void main(String[] args){
		Samsung_1 tester = new Samsung_1();
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		tester.printSquareList(arr);
	}
}
