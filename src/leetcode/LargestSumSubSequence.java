package leetcode;
/**
 * Given an integer Array, find out a consecutive sequence that has largest sum
 * */
public class LargestSumSubSequence {
	public int largestSum(int[] num){
		if(num == null || num.length == 0){
			return 0;
		}
		int sum = num[0];
		int curSum = 0;
		for(int i = 0; i < num.length; i++){
			curSum += num[i];
			if(curSum > sum){
				sum = curSum;
			}
			if(curSum < 0){
				curSum = 0;
			}
		}
		return sum;
	}
	
	public static void main(String[] args){
		LargestSumSubSequence ls = new LargestSumSubSequence();
		int[] a = {1, -4, 2, 8, -9, 10};
		System.out.println(ls.largestSum(a));
	}
}
