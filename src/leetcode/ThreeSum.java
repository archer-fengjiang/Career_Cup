package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * */
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3){
            return list;
        }

        Arrays.sort(num);
        int i = 0;
        while(i < num.length - 2){
            int target = 0 - num[i];
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                if(num[j] + num[k] < target){
                    j++;
                    continue;
                }else if(num[j] + num[k] > target){
                    k--;
                    continue;
                }else{
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    arr.add(new Integer(num[i]));
                    arr.add(new Integer(num[j]));
                    arr.add(new Integer(num[k]));
                    list.add(arr);
                    do{
                        j++;
                    }while(j < num.length && num[j] == num[j - 1]);
                    do{
                        k--;
                    }while(k > i && num[k] == num[k + 1]);
                }
            }
            // update i
            do{
            	i++;
            }while(i < num.length - 2 && num[i] == num[i - 1]);
        }
        return list;
    }

	public static void main(String[] args){
		int[] arr = {-7,-4,-6,6,4,-6,-9,-10,-7,5,3,-1,-5,8,-1,-2,-8,-1,5,-3,-5,4,2,-5,-4,4,7};
		ThreeSum sum3 = new ThreeSum();
		ArrayList<ArrayList<Integer>> list = sum3.threeSum(arr);
		for(ArrayList<Integer> array : list){
			for(Integer I : array){
				System.out.print(I + " ");
			}
			System.out.println();
		}
	}
}
