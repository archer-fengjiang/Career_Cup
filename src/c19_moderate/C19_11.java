package c19_moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Design an algorithm to find all pairs of integers 
 * within an array which sum to a specified value
 * 
 * Facebook Intern: Design an algorithm to find all "3-element-paris"
 * of integers within an array which sum to a specificed value
 *
 * @author Fengjiang.
 *         Created Aug 16, 2012.
 */
public class C19_11 {
    public class Pair{
        public int a;
        public int b;
        
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object o){
            Pair p = null;
            if(o instanceof Pair){
                p = (Pair)o;
            }
            else{
                return false;
            }

            if((p.a == this.a && p.b == this.b) || (p.b == this.a && p.a == this.b))
                return true;
            else
                return false;
        }
    }

    // note that this method cannot check single values that appears only once
    // but double to be equal to sum forms a pair
    // improved methods would be counting frequency using hashmap
    // key as element in array, values as frequency
    public List<Pair> getPairsByHashTable(int[] array, int sum){
        HashSet<Integer> set = new HashSet<Integer>();
        List<Pair> list = new LinkedList<Pair>();
        for(int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        for(int i = 0; i < array.length; i++){
            if(set.contains(sum - array[i])){
                Pair pair = new Pair(array[i], sum - array[i]);
                if(!list.contains(pair))
                    list.add(pair);
            }
        }
        return list;
    }

    public List<Pair> getPairsBySortedArray(int[] array, int sum){
        List<Pair> list = new LinkedList<Pair>();
        Arrays.sort(array); // java's sort implementation is using merge sort
        int start = 0;
        int end = array.length - 1;
        while(start < end){
            if(array[start] + array[end] == sum){
                Pair pair = new Pair(array[start], array[end]);
                if(!list.contains(pair)){
                    list.add(pair);
                }
                start++;
                end--;
                continue;
            }
            else if(array[start] + array[end] > sum){
                end --;
                continue;
            }
            else if(array[start] + array[end] < sum){
                start++;
                continue;
            }
        }
        return list;
    }

    public static void main(String[] args){
        C19_11 tester = new C19_11();
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        List<Pair> res = tester.getPairsBySortedArray(array, 14);
//        List<Pair> res = tester.getPairsByHashTable(array, 14);
        for(Pair pair : res){
            System.out.println(pair.a + "+" + pair.b);
        }
    }
}
