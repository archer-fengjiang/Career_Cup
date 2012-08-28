package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of n integers, 
 * find 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time.
 *
 * @author Fengjiang.
 *         Created Aug 17, 2012.
 */
public class Amazon_1 {
    public class Result{
        public int i;
        public int j;
        public int k;
    }

    public List<Result> getThreeElements(int[] array){
        List<Result> resultList = new LinkedList<Result>();
        Map<Integer, Boolean> minMap = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> maxMap = new HashMap<Integer, Boolean>();

        int max = array[0];
        int min = array[array.length - 1];

        for(int i = 0; i < array.length; i++){
            if(array[i] > min){
                minMap.put(i, true);
            } else {
                min = array[i];
                minMap.put(i, false);
            }
        }

        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] < max){
                maxMap.put(i, true);
            } else {
                max = array[i];
                maxMap.put(i, false);
            }
        }

        for(int i = 0; i < array.length; i++){
            if(minMap.get(i) && maxMap.get(i)){
                Result res = new Result();
                res.j = i;
                resultList.add(res);
            }
        }

        for(Result res : resultList){
            for(int i = 0; i < res.j; i++){
                if(array[i] < array[res.j]){
                    res.i = i;
                    break;
                }
            }
            for(int k = array.length - 1; k > res.j; k--){
                if(array[k] > array[res.j]){
                    res.k = k;
                    break;
                }
            }
        }

        return resultList;
    }
    
    public static void main(String[] args){
    	int[] arr = new int[5];
    	arr[0] = 12;
    	arr[1] = 8;
    	arr[2] = 9;
    	arr[3] = 14;
    	arr[4] = 15;
    	Amazon_1 tester = new Amazon_1();
    	List<Result> list = tester.getThreeElements(arr);
    	for(Result res : list){
    		System.out.println(arr[res.i]+":"+arr[res.j]+":"+arr[res.k]);
    	}
    }
}
