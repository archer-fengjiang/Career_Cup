package c8_recursion;
import java.util.*;
public class Quarter {
	ArrayList<ArrayList<Integer>> expressionList = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> calculateExpression(int n){
		int nextCount;
		ArrayList<Integer> tmpList;
		if(n < 0)
			return null;
		if(n >= 25){
			tmpList = new ArrayList<Integer>();
			tmpList.add(25);
			nextCount = n - 25;
			calculateExpressionHelper(nextCount, tmpList, 25);
		}
		if(n >= 10){
			tmpList = new ArrayList<Integer>();
			tmpList.add(10);
			nextCount = n - 10;
			calculateExpressionHelper(nextCount, tmpList, 10);
		}
		if(n >= 5){
			tmpList = new ArrayList<Integer>();
			tmpList.add(5);
			nextCount = n - 5;
			calculateExpressionHelper(nextCount, tmpList, 5);
		}
		if(n >= 1){
			tmpList = new ArrayList<Integer>();
			tmpList.add(1);
			nextCount = n - 1;
			calculateExpressionHelper(nextCount, tmpList, 1);
		}
		return expressionList;
	}
	private void calculateExpressionHelper(int count, ArrayList<Integer> List, int biggest){
		int nextCount;
		ArrayList<Integer> tmpList;
		if(count == 0){
			expressionList.add(List);
			return;
		}
		if(count >= 25 && 25 <= biggest){
			nextCount = count - 25;
			tmpList = (ArrayList<Integer>)List.clone();
			tmpList.add(25);
			calculateExpressionHelper(nextCount, tmpList, 25);
		}
		if(count >= 10 && 10 <= biggest){
			nextCount = count - 10;
			tmpList = (ArrayList<Integer>)List.clone();
			tmpList.add(10);
			calculateExpressionHelper(nextCount, tmpList, 10);
		}
		if(count >= 5 && 5 <= biggest){
			nextCount = count - 5;
			tmpList = (ArrayList<Integer>)List.clone();
			tmpList.add(5);
			calculateExpressionHelper(nextCount, tmpList, 5);
		}
		if(count >= 1 && 1 <= biggest){
			nextCount = count - 1;
			tmpList = (ArrayList<Integer>)List.clone();
			tmpList.add(1);
			calculateExpressionHelper(nextCount, tmpList, 1);
		}
	}
	public static void main(String[] args){
		Quarter q = new Quarter();
		ArrayList<ArrayList<Integer>> list = q.calculateExpression(34);
		ArrayList<Integer> subList;
		Iterator itr1;
		itr1 = list.iterator();
		while(itr1.hasNext()){
			subList = (ArrayList<Integer>)itr1.next();
			System.out.println(subList.toString());
		}
	}
}
