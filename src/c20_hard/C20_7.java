package c20_hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;;

/**
 * Write a program to find the longest word made of other words
 *
 * Create a map that maps length of words to words set that contains words of same length
 * Then start from words of biggest lenght, split sub words and search if there are matches
 * 
 * Sorting lenght, O( nlog(n) ), searching takes (length of entire characters) * (avg word length)
 * For samll arrays is (length of entire characters) * (avg word length) = m * n
 * For big arryas is nlog(n)
 * @author Fengjiang.
 *         Created Aug 22, 2012.
 */
public class C20_7 {
    private Map<Integer, Set<String>> map;
	
    public String getLongest(String[] arr) throws NullPointerException{
        if(arr == null || arr.length == 0){
            return null;
        }

        // Generate Map length -> set
        this.map = new HashMap<Integer, Set<String>>();
        for(int i = 0; i < arr.length; i++){
            int length = arr[i].length();
            Set set = map.get(length);
            if(set == null){
                set = new HashSet<String>();
            }
            set.add(arr[i]);
            map.put(length, set);
        }

        // Generate sorted array of length in ascending order
        Set<Integer> keySet = (Set<Integer>)map.keySet();
        int[] sortedKeyArray = new int[keySet.size()];
        Iterator itr = keySet.iterator();
        for(int i = 0; itr.hasNext(); i++){
        	sortedKeyArray[i] = (Integer)itr.next();
        }
        
        // Iterate through every string and split subString to find
        for(int i = sortedKeyArray.length - 1; i >= 0; i--){
        	Set<String> set = map.get(sortedKeyArray[i]);
        	if(set == null){
        		throw new NullPointerException();
        	}
        	Iterator itrSplit = set.iterator();
        	while(itrSplit.hasNext()){
        		String str = (String)itrSplit.next();
        		// split sub-strings
        		for(int j = 0; j < str.length(); j++){
        			String subStr1 = str.substring(0, j+1);
        			String subStr2 = str.substring(j+1, str.length());
        			if(subStringExist(subStr1) && subStringExist(subStr2)){
        				return str;
        			}
        		}
        	}
        }
        return null;
    }
    
    private boolean subStringExist(String str){
    	int length = str.length();
    	Set<String> set = this.map.get(length);
    	if(set == null || set.size() == 0){
    		return false;
    	}
    	Iterator itr = set.iterator();
    	while(itr.hasNext()){
            String tmpStr = (String)itr.next();
            if(tmpStr.equals(str)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] arr = {"good","go", "thunder","odd", "storm", "fun", "nationality",
        			"nation", "action","function", "on", "crossover","cross", "over", "thunderstorm"};
        C20_7 tester = new C20_7();
        System.out.println(tester.getLongest(arr));
    }
}
