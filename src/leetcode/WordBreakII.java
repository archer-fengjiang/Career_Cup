package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * */
public class WordBreakII {
	
	private ArrayList<String> arr;
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		// Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || dict == null){
        	return null;
        }
        
        this.arr = new ArrayList<String>();

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
        		}
        	}
        }
        
        
        for(int i = 0; i < s.length(); i++){
        	for(int j = 0; j < s.length(); j++){
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }
//        helperDriver(s, matrix, 0, "");
        return this.arr;
    }
	
	private void helperDriver(String s, boolean[][] matrix, int pos, String tmpStr){
		System.out.println(tmpStr);
		if(pos == s.length()){
			this.arr.add(tmpStr);
		}
		for(int i = pos; i < matrix.length; i++){
			if(matrix[pos][i]){
				tmpStr += " " + s.substring(pos, i + 1);
				helperDriver(s, matrix, i + 1, tmpStr);
			}
		}
	}
	
    public static void main(String[] args){
    	WordBreakII wb = new WordBreakII();
    	Set<String> dict = new HashSet<String>();
    	String[] strArr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    	for(String str : strArr){
    		dict.add(str);
    	}
    	List<String> list = wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict);
    	for(String str : list){
    		System.out.println(str);
    	}
    	
    }
}
