package sorting;

/**
 * Selection Sort
 * 
 * Whole array is divided into two parts. Sorted and unsorted.
 * At the beginning, sorted array is empty and unsorted array is whole array
 * 
 * O(n^2), inefficient for large data set, quick under certain
 *
 * @author Fengjiang.
 *         Created Aug 21, 2012.
 */
public class SelectionSort {
	public int[] selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int pos = i;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < arr[pos]){
					pos = j;
				}
			}
			int tmp = arr[pos];
			arr[pos] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = {5,4,3,2,1,0};
		SelectionSort selectionSort = new SelectionSort();
		arr = selectionSort.selectionSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
