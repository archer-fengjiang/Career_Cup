package c9_sorting_searching;

public class RotateBinarySearch {
	public static int search(int[] array, int target){
		int x = 0;
		int y = array.length - 1;
		int rotatePoint;
		if(array[x] == target)
			return x;
		if(array[x] < array[y])
			return binarySearch(array, x, y, target);
		rotatePoint = searchPoint(array, x, y);
		if(array[0] > target)
			return binarySearch(array, rotatePoint, y, target);
		else
			return binarySearch(array, 0, rotatePoint - 1, target);
	}
	
	private static int searchPoint(int[] array, int x, int y){
		int mid = (x+y)/2;
		if(x == y)
			return x;
		if(array[mid] < array[y])
			return searchPoint(array, x, mid);
		else
			return searchPoint(array, mid+1, y);
	}
	
	private static int binarySearch(int[] array, int x, int y, int target){
		if(x > y)
			return -1;
		int mid = (x+y)/2;
		if(array[mid] == target)
			return mid;
		if(array[mid] > target)
			return binarySearch(array, x, mid-1, target);
		else
			return binarySearch(array, mid+1, y, target);
	}
	
	public static void main(String[] args){
		int[] a = {2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2};
		int position = RotateBinarySearch.search(a, 3);
		System.out.println(position);
	}
}
