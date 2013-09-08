package leetcode;
/**
  * ‚Äò.‚Äô Matches any single character.
  * ‚Äò*‚Äô Matches zero or more of the preceding element.
  * The matching should cover the entire input string (not partial).
  *
  * The function prototype should be:
  * bool isMatch(const char *s, const char *p)
  *
  * Some examples:
  * isMatch(“aa”,”a”) → false
  * isMatch(“aa”,”aa”) → true
  * isMatch(“aaa”,”aa”) → false
  * isMatch(“aa”, “a*”) → true
  * isMatch(“aa”, “.*”) → true
  * isMatch(“ab”, “.*”) → true
  * isMatch(“aab”, “c*a*b”) → true
*/
public class RegularExpressionMatching{
    public static boolean isMatch(String s, String p){
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
    	return isMathcHelper(a, 0, b, 0);
    }

    private static boolean isMathcHelper(char[] a, int i, char[] b, int j){
        // Conditions to end recursion
        if(j == b.length && i == a.length){
            return true;
        }

        if(j == b.length){
            return false;
        }

        if(i == a.length){
            if(b[j] == '*'){
                return isMathcHelper(a, i, b, j + 1);
            }
            else{
                return false;
            }
        }

        // Try to compare
        if(a[i] == b[j] || b[j] == '.'){
            return isMathcHelper(a, i + 1, b, j + 1);
        } else if(b[j] == '*') {
            for(int k = i; k <= a.length; k++){
                if(isMathcHelper(a, k, b, j + 1)){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        RegularExpressionMatching exp = new RegularExpressionMatching();
        System.out.println(exp.isMatch("aa", "a"));
        System.out.println(exp.isMatch("aa", "aa"));
        System.out.println(exp.isMatch("aaa", "aa"));
        System.out.println(exp.isMatch("aa", "a*"));
        System.out.println(exp.isMatch("aa", ".*"));
        System.out.println(exp.isMatch("ab", ".*"));
        System.out.println(exp.isMatch("aab", "c*a*b"));
        System.out.println(exp.isMatch("afewfafweagfawgae efw eabccabcc", "*fw.*b*c*ca*c**."));
    }
}