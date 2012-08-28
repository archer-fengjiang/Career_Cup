package c20_hard;

/**
 * Write a method to count number of 2s between 0 and N
 *
 * @author Fengjiang.
 *         Created Aug 18, 2012.
 */
public class C20_4 {
    public int count2S(int N){
        int sum = 0;
        for(int i = 1; ; i++){
        	int tmp = (N/ (int)Math.pow(10,i) );
        	sum += tmp;
        	if(N % (int)Math.pow(10, i) >= 2 * (int)Math.pow(10, i-1)){
        		sum++;
        	}
        	if(tmp == 0)
        		break;
        }
        return sum;
    }
    
    public static void main(String[] args){
    	C20_4 tester = new C20_4();
    	System.out.println(tester.count2S(112));
    }
}
