package leetcode;

import java.util.ArrayList;

/**
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 * 
 * Note this is not the best solution
 * best solution see: http://en.wikipedia.org/wiki/3SUM
 *
 * @author Fengjiang.
 *         Created Oct 8, 2012.
 */
public class Sum3 {

	public static void main(String[] args){
		int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		Sum3 solution = new Sum3();
		ArrayList<ArrayList<Integer>> list = solution.threeSum(arr);
		System.out.println(list.toString());
	}

	private ArrayList<ArrayList<Integer>> threeSumList = 
			new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(num == null || num.length == 0){
			return null;
		}
		mergeSort(num, 0, num.length - 1);

		int start = 0, end = num.length -1;
		while(start < end){
			searchSum(num, start, end);
			start = getNextStart(num, start);
			end = getNextEnd(num, end);
		}
		return this.threeSumList;
	}

	private void searchSum(int[] num, int start, int end){
		int tmpStart = start;
		int tmpEnd = end;
		int prevHitPos = -1;
		int target;
		ArrayList<Integer> list;
		for(tmpStart = start, tmpEnd = end; tmpStart < tmpEnd; tmpStart = getNextStart(num, tmpStart)){
			target = -(num[tmpStart] + num[tmpEnd]);
			if(target >= num[tmpStart + 1]){
				if(isTargetFound(num, target, tmpStart + 1, tmpEnd - 1)){
					list = new ArrayList<Integer>();
					list.add(num[tmpStart]);
					list.add(target);
					list.add(num[tmpEnd]);
					this.threeSumList.add(list);
				}
			}else{
				break;
			}
		}
		for(tmpStart = start, tmpEnd = getNextEnd(num, end); tmpStart < tmpEnd; tmpEnd = getNextEnd(num, tmpEnd)){
			target = -(num[tmpStart] + num[tmpEnd]);
			if(target <= num[tmpEnd - 1]){
				if(isTargetFound(num, target, tmpStart + 1, tmpEnd - 1)){
					list = new ArrayList<Integer>();
					list.add(num[tmpStart]);
					list.add(target);
					list.add(num[tmpEnd]);
					this.threeSumList.add(list);
				}
			} else {
				break;
			}
		}
	}

	private boolean isTargetFound(int[] num, int target, int start, int end){
		if(start > end){
			return false;
		}
		int mid = (start + end) / 2;
		if(num[mid] == target){
			return true;
		}else if(num[mid] < target){
			return isTargetFound(num, target, mid + 1, end);
		}else{
			return isTargetFound(num, target, start, mid - 1);
		}
	}

	private int getNextStart(int[] num, int start){
		do{
			start++;
		} while(start < num.length - 1 && num[start - 1] == num[start]);
		return start;
	}

	private int getNextEnd(int[] num, int end){
		do{
			end--;
		} while(end > 0 && num[end] == num[end + 1]);
		return end;
	}




	private void mergeSort(int[] arr, int start, int end){
		if(start == end){
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		combine(arr, start, mid, end);    
	}

	private void combine(int[] arr, int start, int mid, int end){

		int i = start;
		int j = mid + 1;
		int k = 0;
		int[] tmpArr = new int[end - start + 1];
		while(i <= mid && j <= end){
			if(arr[i] < arr[j]){
				tmpArr[k++] = arr[i++];
			}else{
				tmpArr[k++] = arr[j++];
			}

		}
		while(i <= mid){
			tmpArr[k++] = arr[i++];
		}
		while(j <= end){
			tmpArr[k++] = arr[j++];
		}
		for(i = start, k = 0; i <= end; i++, k++){
			arr[i] = tmpArr[k];
		}
	}
}
