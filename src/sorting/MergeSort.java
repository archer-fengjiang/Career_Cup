package sorting;

/**
 * Merge Sort
 *
 * @author Fengjiang.
 *         Created Aug 29, 2012.
 */
public class MergeSort {
    private int[] arr;

    public int[] mergeSort(int[] array){
        this.arr = array;
        this.mergeHelper(0, this.arr.length - 1);
        return this.arr;
    }

    private void mergeHelper(int start, int end){
        if(start == end){
            return;
        }
        int mid = (start + end) / 2;
        mergeHelper(start, mid);
        mergeHelper(mid + 1, end);
        merge(start, mid, end);
        return;
    }

    private void merge(int start, int mid, int end){
        int[] tmpArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                tmpArr[k] = arr[i];
                k++;
                i++;
            } else {
                tmpArr[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i <= mid){
            tmpArr[k] = arr[i];
            k++;
            i++;
        }
        while(j <= end){
            tmpArr[k] = arr[j];
            k++;
            j++;
        }
        for(int pos = 0; pos < tmpArr.length; pos++){
            this.arr[start + pos] = tmpArr[pos];
        }
    }

    public static void main(String[] args){
        int[] array = {2,1,4,3,15,6,3,7,8,10,4};
        MergeSort tester = new MergeSort();
        array = tester.mergeSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}