package sorting;

/**
 * Bubble Sort
 * 
 * For each pass, smaller element goes up, biggest element drops down to bottom
 *
 * @author Fengjiang.
 *         Created Aug 21, 2012.
 */
public class BubbleSort {
	
	public int[] bubbleSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 1; j < arr.length - i; j++){
				if(arr[j] < arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args){
		BubbleSort bubbleSort = new BubbleSort();
		int[] arr = {5,4,3,2,10,1,-1,-2,-3};
		arr = bubbleSort.bubbleSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
