package leetcode;

import java.util.Arrays;

/**
 * 3Sum ClosestJan 18 '126070 / 15852
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3){
        	return 0;
        }
        Arrays.sort(num);
        int closestSum = Integer.MAX_VALUE/2;
        for(int i = 0; i < num.length; i++){
            int j = i + 1;
            int k = num.length - 1;
            
            while(j < k){
            	int curSum = num[i] + num[j] + num[k];
            	if(Math.abs(curSum - target) < Math.abs(closestSum - target)){
            		closestSum = curSum;
            	}
                if(curSum == target){
                	return target;
                }else if(curSum > target){
                	k--;
                }else{
                	j++;
                }
            }
        }
        return closestSum;
    }
	
	
	public static void main(String[] args){
		int[] arr = {-3,-2,-5,3,-4};
		ThreeSumClosest a = new ThreeSumClosest();
		System.out.println(a.threeSumClosest(arr, -1));
	}
}
