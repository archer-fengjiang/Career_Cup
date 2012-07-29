package Chapter_9_Sorting_Searching;

public class BinarySearchEmptyInterspersed {
	public static int binarySearch(String[] array, String target){
		int x = 0;
		int y = array.length - 1;
		return binaryHelper(array, x , y, target);
	}
	private static int binaryHelper(String[] array, int x, int y, String target){
		int i;
		if(x > y)
			return -1;
		int mid = (x+y)/2;
		if(array[mid].compareTo(target) == 0)
			return mid;
		if(array[mid].compareTo("") == 0){
			for(i = mid+1; array[i] == "" && i<=y; i++);
			if(i<y){
				mid = i;
				if(array[mid].compareTo(target) == 0)
					return mid;
				else if(array[mid].compareTo(target) < 0)
					return binaryHelper(array, mid+1, y, target);
				else
					return binaryHelper(array, x, mid-1, target);
			}
			else if(i == y && array[i] == target)
				return i;
			else
				return binaryHelper(array, x, mid-1, target);
		}
		else if(array[mid].compareTo(target) < 0)
			return binaryHelper(array, mid+1, y, target);
		else
			return binaryHelper(array, x, mid-1, target);
	}
	public static void main(String[] args){
		String[] str = {"","abandon","","bad","certain","","","","","","","","","","","dog","egg","fuck","","","","good","hire","jack","","",""};
		System.out.println(BinarySearchEmptyInterspersed.binarySearch(str, "abandond"));
	}
}
