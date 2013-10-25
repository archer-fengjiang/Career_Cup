package leetcode;
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * Completed by Fengjiang Li on 9/13/2013
 * */
public class DecodeWays {
    private int count;
    
    
    /**
     * Recursion O(N!)
     * */
	public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        this.count = 0;
        helperDriver(s, 0);
        return this.count;
    }

    private void helperDriver(String s, int index){
        if(index == s.length()){
            this.count++;
            return;
        }
        if(s.charAt(index) != '0'){
            helperDriver(s, index + 1);
        }else{
            return;
        }
        if(index + 1 < s.length()){
        	String twoS = (String) s.subSequence(index, index + 2);
        	if(this.stringToInt(twoS) <= 26){
        		helperDriver(s, index + 2);
        	}
        }
    }


    /**
     * DP O(N) time complexity
     */
    public int numDecodingsON(String s){
        final int len = s.length(); 
        if(s == null || len == 0){
            return 0;
        }
        int tmpCountL = 0;
        int tmpCountP = 0;

        if(s.charAt(len - 1) != '0'){
            tmpCountP++;
        }
        if(s.length() >= 2 && stringToInt((String)s.subSequence(len - 2, len)) <= 26){
            tmpCountL++;
        }

        for(int i = len - 2; i >= 0; i--){
            int tmp = 0;
            if(s.charAt(i) == '0'){
                if(i == 0 || stringToInt((String)s.subSequence(i - 1, i + 1)) > 26){
                    return 0;
                } else {
                    tmpCountL = tmpCountP;
                    tmpCountP = 0;
                }
            } else {
                // char is not 0
                if(stringToInt((String)s.subSequence(i, i + 2)) <= 26){
                    tmp = tmpCountP + tmpCountL;
                    tmpCountL = tmpCountP;
                    tmpCountP = tmp;
                } else {
                    tmpCountL = tmpCountP;
                }
            }
        }
        return tmpCountP;
    }

    private int stringToInt(String s){
    	return Integer.parseInt(s);
    }

    public static void main(String[] args){
        String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        DecodeWays dw = new DecodeWays();
        System.out.println( dw.numDecodings(s));
    }
}
