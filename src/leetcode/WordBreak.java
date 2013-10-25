package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || dict == null){
        	return false;
        }

        int len = s.length();
        
        boolean[][] matrix = new boolean[len][len];
        for(int i = 0; i < len; i++){
        	if(dict.contains(s.substring(i, i + 1))){
        		matrix[i][i] = true;
        	}else{
        		matrix[i][i] = false;
        	}
        }
        
        for(int inc = 1; inc < len; inc++){
        	for(int row = 0; row + inc < len; row++){
        		if(dict.contains(s.substring(row, row + inc + 1))){
        			matrix[row][row + inc] = true;
        		}else{
        			for(int k = row; k < row + inc; k++){
        				if(matrix[row][k] && matrix[k + 1][row + inc]){
        					matrix[row][row + inc] = true;
        				}
        			}
        		}
        	}
        }
        return matrix[0][len - 1];
    }
}
