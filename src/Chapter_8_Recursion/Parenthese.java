/*8.5*/
package Chapter_8_Recursion;
import java.util.*;
public class Parenthese {
	ArrayList<String> parList = new ArrayList<String>();
	
	public ArrayList<String> parentheses(int n){
		int left = 0;
		int right = 0;
		String parStr = "";
		if(n < 1)
			return null;
		left++;
		parStr +="(";
		parenthesesHelper(left,right,n,parStr);
		return parList;
	}
	
	private void parenthesesHelper(int left, int right, int n, String parStr){
		String tmpStr;
		if(left == right && left == n){
			parList.add(parStr);
			return;
		}
		
		if(left < n){
			left++;
			tmpStr = parStr+"(";
			parenthesesHelper(left, right, n, tmpStr);
			left--;
		}
		if(right < left && right < n){
			right++;
			tmpStr = parStr+")";
			parenthesesHelper(left, right, n, tmpStr);
		}
	}
	
	public static void main(String[] args){
		Parenthese par = new Parenthese();
		ArrayList<String> list = new ArrayList<String>();
		list = par.parentheses(3);
		System.out.println(list.toString());
	}
}
