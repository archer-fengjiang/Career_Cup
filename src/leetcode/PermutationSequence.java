package leetcode;

import java.util.Arrays;

/**
 * The set [1,2,3,É,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
        	arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int pos = k;
        int remain = k;
        for(int i = 0; i < n; i++){
        	int mul = mul(n - 1 - i);
        	if(remain/mul > 0 && remain % mul > 0){
        		pos = remain / mul;
            	remain = remain % mul;
        		int tmp = arr[i + pos];
        		arr[i + pos] = arr[i];
        		arr[i] = tmp;
        	}
        	else if(remain/mul > 0 && remain % mul == 0){
        		int start = i + 1;
        		int end = n - 1;
        		while(start < end){
        			int tmp = arr[start];
        			arr[start] = arr[end];
        			arr[end] = tmp;
        			start++;
        			end--;
        		}
        		break;
        	}
        }
        //System.out.println(Arrays.toString(arr));
        String s = "";
        for(int i = 0; i < n; i++){
        	s += (char)('0' + arr[i]);
        }
        return s;
    }
    
    private int mul(int max){
    	int mul = 1;
    	for(int i = 2; i <= max; i++){
    		mul *= i;
    	}
    	return mul;
    }
    
    public static void main(String[] args){
    	PermutationSequence ps = new PermutationSequence();
    	System.out.println(ps.getPermutation(4, 4));
    }
}
