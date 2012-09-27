package colleciton_qustions;

/**
 * This class computes square root of double
 *
 * @author Fengjiang.
 *         Created Sep 26, 2012.
 */
public class Sqrt {
	
	public double sqrt(double d){
		if(d <= 0){
			return -1;
		}
		double base = 1.0;
		if(d > 1){
			while(base * base <= d){
				base += 1.0;
			}
			base-= 1.0;
		}
		double offset = 0.0;
		while(Math.abs(d - base * base) > 0.0000000001){
			offset = (double)((d - base * base) / 2 / base);
			base += offset;
		}
		return base;
	}
	
	public static void main(String[] args){
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.sqrt(6.25));
		System.out.println(sqrt.sqrt(2));
		
	}
}
