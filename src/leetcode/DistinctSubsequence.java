package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * */
public class DistinctSubsequence {
	
	public int numDistinct(String S, String T) {
        if(S == null || T == null || S.length() == 0 || T.length() == 0){
            return 0;
        }
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        Set<Character> TSet = new HashSet<Character>();
        for(int i = 0; i < T.length(); i++){
        	Character c = new Character(T.charAt(i));
            TSet.add(c);
            if(!map.containsKey(c)){
            	map.put(c, new LinkedList<Integer>());
            }
        }

        for(int i = 0; i < S.length(); i++){
            Character c = new Character(S.charAt(i));
            if(TSet.contains(c)){
            	List<Integer> list = map.get(c);
            	list.add(new Integer(i));
            }
        }
        
        int maxCol = 0;
        LinkedList<LinkedList<Integer>> posOrderList = new LinkedList<LinkedList<Integer>>();
        for(int i = 0; i < T.length(); i++){
        	Character c = new Character(T.charAt(i));
        	LinkedList<Integer> list = (LinkedList<Integer>) map.get(c);
        	if(list.size() > maxCol){
        		maxCol = list.size();
        	}
        	posOrderList.add(list);
        }
        
        int[][] sumMatrix = new int[posOrderList.size()][maxCol];
        
        for(int i = 0; i < posOrderList.size(); i++){
        	for(int j = 0; j < posOrderList.get(i).size(); j++){
        		//System.out.print(posOrderList.get(i).get(j) + " ");
        		sumMatrix[i][j] = 0;
        	}
        	//System.out.println();
        }
        
        if(posOrderList.size() == 1){
        	return posOrderList.get(0).size();
        }
        
        for(int row = posOrderList.size() - 2; row >= 0; row--){
        	for(int col = 0; col < posOrderList.get(row).size(); col++){
        		Integer curVal = posOrderList.get(row).get(col);
        		for(int subCol = 0; subCol < posOrderList.get(row + 1).size(); subCol++){
        			if(posOrderList.get(row + 1).get(subCol) > curVal){
        				if(row == posOrderList.size() - 2){
        					sumMatrix[row][col] += 1;
        				}else{
        					sumMatrix[row][col] += sumMatrix[row+1][subCol];
        				}
        			}
        		}
        	}
        }
        
        int sum = 0;
        for(int col = 0; col < posOrderList.get(0).size(); col++){
        	sum += sumMatrix[0][col];
        }
        
        return sum;
    }
	
	public static void main(String[] args){
		String S = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String T = "bddabdcae";
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinct(S, T));
	}
}
