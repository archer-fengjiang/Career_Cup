package leetcode;

public class SortArrayWithThreeItemsByOnePass {
    public int[] sort(int[] arr){
        if(arr == null || arr.length == 0)
            return null;
        // i: points to last 1 in sorted head
        // j: points to first 3 in sorted tail
        // k: current element
        int i, j, k, tmp;
        int len = arr.length;

        // push i to one before last 1 in sorted head
        for(i = -1; i < len - 1; i++){
            if(arr[i + 1] != 1){
                break;
            }
        }
        
        // push j to one after first 3 in sorted tail
        for(j = len; j > 0; j--){
            if(arr[j - 1] != 3){
                break;
            }
        }

        for(k = i + 1; k < j; k++){
            // pass 2
            if(arr[k] ==2){
                continue;
            }

            // append 1 to sorted head
            if(arr[k] == 1){
                tmp = arr[k];
                arr[k] = arr[++i];
                arr[i] = tmp;
            }

            // append 3 to sorted tail
            if(arr[k] == 3){
                tmp = arr[k];
                arr[k] = arr[--j];
                arr[j] = tmp;
                // if swipe 1 to here, try to append 1 to sorted head
                if(arr[k] == 1){
                    tmp = arr[k];
                    arr[k] = arr[++i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr_1 = {1,2,2,3,2,1,1,3,3,3};
        int[] arr_2 = {1,1,1,1,1,2,2,2,2,3,3,3,3};
        int[] arr_3 = {3,3,1,3,2,3,2,2,2,2,2,1,1,1,1,3,1,1};
        SortArrayWithThreeItemsByOnePass sort = new SortArrayWithThreeItemsByOnePass();
        int[] sortedArr;

        sortedArr = sort.sort(arr_1);
        for(int i = 0; i < sortedArr.length; i++){
        	System.out.print(sortedArr[i]);
        }
        System.out.println();

        sortedArr = sort.sort(arr_2);
        for(int i = 0; i < sortedArr.length; i++){
            System.out.print(sortedArr[i]);
        }
        System.out.println();

        sortedArr = sort.sort(arr_3);
        for(int i = 0; i < sortedArr.length; i++){
            System.out.print(sortedArr[i]);
        }
        System.out.println();
    }
}