package c19_moderate;

/**
 * Write a method to return maximum of two numbers.
 * You are not allowed to use if else
 *
 * Key to solve this problem is:
 *  if a > b, return a
 *  if a - b > 0, return a, else return b
 *  if c = a - b, if c > 0, return a - 0 *(a - b), else return a - 1 * (a - b)
 *  if c = a - b, if c > 0, k = 0, else k = 1, return a - k * (a - b)
 * @author Fengjiang.
 *         Created Aug 13, 2012.
 */
public class C19_4 {
	public static int maximum(int a, int b){
		int c = a - b;
		c = (c >> 31) & 0x1;
		return a - c *(a - b);
	}
	
	public static void main(String[] args){
		int max = C19_4.maximum(40,10);
		System.out.println(max);
	}
}
