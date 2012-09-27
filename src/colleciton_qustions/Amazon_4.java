package colleciton_qustions;

/**
 * Maximum sub-array problem
 * Given an un-sorted array, find the largest sub-array that has maximum sum
 * 
 * @author Fengjiang.
 *         Created Aug 28, 2012.
 */
public class Amazon_4 {
    int[] findSubArray(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int sum_so_far = arr[0];
        int sum_to_now = arr[0];
        int max_start = 0;
        int max_end = 0;
        int cur_start = 0;
        for(int i = 1; i < arr.length; i++){
            if(sum_to_now + arr[i] >= arr[i]){
                sum_to_now += arr[i];
            } else {
                sum_to_now = arr[i];
                cur_start = i;
            }
            if(sum_to_now >= sum_so_far){
                sum_so_far = sum_to_now;
                max_start = cur_start;
                max_end = i;
            }
        }
        int[] subArr = new int[max_end - max_start + 1];
        for(int i = max_start; i <= max_end; i++){
            subArr[i - max_start] = arr[i];
        }
        return subArr;
    }

    public static void main(String[] args){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Amazon_4 tester = new Amazon_4();
        int[] subArr = tester.findSubArray(arr);
        for(int i = 0; i < subArr.length; i++){
            System.out.println(subArr[i]);
        }
    }
}
