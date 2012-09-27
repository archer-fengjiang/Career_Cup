package sorting;

/**
 * Quick Sort:
 * 
 * An improvement of bubble sort. T(n) = knln(n), k is some constant
 * Quick sort is the best in-place sorting method
 *
 * @author Fengjiang.
 *         Created Aug 21, 2012.
 */
public class QuickSort {
	private int[] arr;
	private int len;
	
	public int[] quickSort(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		this.arr = arr;
		this.len = arr.length;
		this.quickSortHelper(0, len -1);
		return arr;
	}
	
	private void quickSortHelper(int low, int high){
		int pivot = arr[(low + high) / 2];
		int i = low, j = high;
		while(i < j){
			while(arr[i] < pivot){
				i++;
			}
			while(arr[j] > pivot ){
				j--;
			}
			if(i <= j){//easy to forget, think what if low to high happens to be sorted
				this.exchange(i, j);
				i++;
				j--;
			}
		}
		if(low < j){
			quickSortHelper(low, j);
		}
		if(i < high){
			quickSortHelper(high, i);
		}
	}
	
	private void exchange(int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return;
	}
	
	public static void main(String[] args){
		QuickSort quickSort = new QuickSort();
		int[] arr = {1,4,10,8,1,2,5};
		arr = quickSort.quickSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
