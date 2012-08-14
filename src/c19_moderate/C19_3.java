package c19_moderate;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial
 *
 * @author Fengjiang.
 *         Created Aug 14, 2012.
 */
public class C19_3 {
	public static int numOfTrailingZeros(int n){
		int sum = 0;
		for(int i = 1; n / Math.pow(5, i) > 0 ; i++){
			sum += n / Math.pow(5, i);
		}
		return sum;
	}
	
	public static void main(String[] args){
		int sum = C19_3.numOfTrailingZeros(4617);
		System.out.println("sum:"+ sum);
	}
}
