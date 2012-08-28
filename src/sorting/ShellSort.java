package sorting;

/**
 * Shell Sort
 * A improvement of insertion sort, as insertion-sorting 
 * almost sorted array is very quick, shell sort creates sub sorted array and combine them together
 *
 * Shell sort is a sorting algorithm that requires asymptotically fewer than O(n^2) 
 * comparisons and exchanges in the worst case. 
 * Although it is easy to develop an intuitive sense of how this algorithm works, 
 * it is very difficult to analyze its execution time, 
 * but estimates range from O(nlog2 n) to O(n1.5) depending on implementation details.
 * 
 * @author Fengjiang.
 *         Created Aug 20, 2012.
 */
public class ShellSort {
	public int[] shellSort(int[] arr){
		int h = 1;
		while((h*3 + 1) < arr.length){
			h = 3 * h + 1;
		}
		while(h > 0){
			for(int i = h - 1; i < arr.length; i++){
				int tmp = arr[i];
				int j = i;
				for(; (j >= h) && arr[j - h] > arr[j]; j-=h){
					arr[j] = arr[j - h];
				}
				arr[j] = tmp;
			}
			h /= 3;
		}
		return arr;
	}

	public static void main(String[] args){
		ShellSort shellSort = new ShellSort();
		int[] arr = {5, 4, 3, 2, 1};
		arr = shellSort.shellSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
