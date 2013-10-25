package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Your algorithm should run in O(n) complexity.
 * */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0){
            return 0;
        }
        Character[] CArr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
        	CArr[i] = new Character(s.charAt(i));
        }
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            set.clear();
            for(int j = i; j < s.length(); j++){
                Character C = CArr[j];
                
                if(!set.contains(C)){
                    set.add(C);
                }else{
                    if(set.size() > maxLength){
                        maxLength = set.size();
                    }
                    break;
                }
            }
            if(set.size() > maxLength){
                maxLength = set.size();
            }
        }
        if(set.size() > maxLength){
            maxLength = set.size();
        }
        return maxLength;
    }
    
    public static void main(String[] args){
    	String s = "abcd";
        LongestSubstringWithoutRepeatingCharacters L = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(L.lengthOfLongestSubstring(s));
    }
}
