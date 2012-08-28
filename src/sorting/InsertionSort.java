package sorting;

/**
 * Insertion sort:
 * 	Pros: easy to implement, in-place sort, need only one extra slot
 * 	      very quick if the origin array is almost sorted
 * 	Cons: O(n^2) time complexity
 * 
 *  Usage: good to use on small data sets
 *
 * @author Fengjiang.
 *         Created Aug 20, 2012.
 */
public class InsertionSort {
	
	public int[] insertionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
				int tmp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = tmp;
			}
		}
		return arr;
	}
	
	/**
	 * Binary Insertion Sort: use binary sort to quickly locate insertion point
	 * 
	 * Not very important improvement, as binary insertion sort only
	 * reduce comparison times, not shifting times
	 * And insertion sort is only used on small data sets
	 * */
	public int[] binaryInsertionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int low = 0;
			int high = i - 1;
			int tmp = arr[i];
			while(low <= high){
				int mid = (low + high) / 2;
				if(arr[mid] > tmp){
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			for(int j = i - 1; j > high; j--){
				arr[j + 1] = arr[j];
			}
			arr[high + 1] = tmp;
		}
		return arr;
	}
	
	public static void main(String[] args){
		InsertionSort sort = new InsertionSort();
		int[] arr = {5, 4, 3, 2, 1, 12, 10, 7, 19};
		arr = sort.binaryInsertionSort(arr);
		for(int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
