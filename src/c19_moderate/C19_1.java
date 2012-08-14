package c19_moderate;

/**
 * Write a function to swap a number in place without temporary variable
 *
 * @author Fengjiang.
 *         Created Aug 13, 2012.
 */
public class C19_1 {
	public static void swap(int a, int b){
		a = b - a;
		b = b - a;
		a = a + b;
		System.out.println("a:"+a+"b:"+b);
	}
	
	public static void swap_optimize(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:"+a+"b:"+b);
	}
	
	public static void main(String[] args){
		C19_1.swap(1,2);
		C19_1.swap_optimize(1,2);
	}
}
