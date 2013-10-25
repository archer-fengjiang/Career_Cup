package leetcode;
/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return null;
        }
        int maxLength = 0;
        String subString = null;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            // test odd
            int j = 1;
            for(; i - j >= 0 && i + j < s.length(); j++){
            	if(charArr[i - j] == charArr[i + j]){
            		continue;
            	}else{
            	    break;	
            	}
            }
            if(2 * j - 1 > maxLength){
                    maxLength = 2 * j - 1;
            		subString = s.substring(i - (j - 1), i + (j - 1) + 1);
            }
            
            // test even
            int oddS = i;
            int oddE = i+1;
            while(oddS >= 0 && oddE < s.length()){
                if(charArr[oddS] == charArr[oddE]){
                    oddS--;
                    oddE++;
                }else{
                    break;
                }
            }
            if(oddE - oddS - 1 > maxLength){
                maxLength = oddE - oddS - 1;
                subString = s.substring(oddS + 1, oddE);
            }
        }
        return subString;
    }
    
    public static void main(String[] args){
    	LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
    	String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
    	System.out.println(lps.longestPalindrome(s));
    }
}
