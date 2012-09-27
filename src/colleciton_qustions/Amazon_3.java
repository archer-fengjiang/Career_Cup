package colleciton_qustions;

/**
 * Given a sorted array (ex. {1,2,3,4,5,6,7,8}). 
 * A random number from the array is taken and put the left side
 * array to right side and right side array to left side.
 * in the example; if 6 is randomly taken, the array will become like {7,8,6,1,2,3,4,5}
 * 
 * Question:
 * Given the above mangled array, write a searching algorithm to find a number present or not. 
 * That algo should not be of O(n) solution.
 *
 * Find the pivot at first, this will cost O(logn).
 * Notice the pivot should less than the first element and larger than the last element.
 * So, this property makes a rule for binary search.
 * Binary search on the appropriate sub array.
 *
 * @author Fengjiang.
 *         Created Aug 27, 2012.
 */
public class Amazon_3 {
    private int[] arr;
    private int pivot;

    public Amazon_3(int[] arr){
        this.arr = arr;
        this.pivot = this.findPivot(arr);
        System.out.println("Pivot is at:" + this.pivot);
    }

    private boolean contains(int i){
        if(this.pivot == -1){
            return false;
        }
        if(this.arr[pivot] == i){
            return true;
        }
        if(binarySearch(0, this.pivot - 1, i) || binarySearch(this.pivot + 1, this.arr.length - 1, i)){
            return true;
        }
        return false;
    }

    private boolean binarySearch(int start, int end, int i){
        if(start > end){
            return false;
        }
        int mid = (start + end) / 2;
        if(this.arr[mid] == i){
            return true;
        }
        if(this.arr[mid] > i){
            return binarySearch(start, mid - 1, i);
        }
        if(this.arr[mid] < i){
            return binarySearch(mid + 1, end, i);
        }
        return false;
    }

    private int findPivot(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        return findPivotHelper(0, arr.length - 1);
    }

    private int findPivotHelper(int start, int end){
        int mid = (start + end) / 2;
        if(mid == 0 || mid == arr.length){
            return mid;
        }
        if(arr[mid] <= arr[start] && arr[mid] >= arr[end]){
            return mid;
        }
        if(arr[mid] < arr[start] || arr[mid] < arr[end]){
            return findPivotHelper(start, mid - 1);
        }
        if(arr[mid] > arr[start] || arr[mid] > arr[end]){
            return findPivotHelper(mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {7,8,9,10,11,13,6,1,2,3,4,5};
        Amazon_3 tester = new Amazon_3(arr);
        if(tester.contains(12)){
            System.out.println("contians");
        } else {
            System.out.println("not contians");
        }
    }
}