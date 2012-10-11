package dynamic_programming;

/**
 * Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 
 * 1.) Subtract 1 from it. ( n = n - 1 )  , 
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). 
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 *
 * @author Fengjiang.
 *         Created Oct 11, 2012.
 */
public class MinStepToOne {
	private int[] memOfMinStep;
	
	public int getMinStepMemorization(int N){
		if (N == 1){
			return 0;
		}
		if(this.memOfMinStep == null){
			memOfMinStep = new int[N + 1];
		}
		if(memOfMinStep[N] != 0){
			return memOfMinStep[N];
		}
		int r = 1 + getMinStepMemorization(N - 1);
		if(N % 2 == 0){
			r = Math.min(r, 1 + getMinStepMemorization(N/2));
		}
		if(N % 3 == 0){
			r = Math.min(r, 1 + getMinStepMemorization(N/3));
		}
		this.memOfMinStep[N] = r;
		return r;
	}
	
	public int getMinStepBottomUp(int N){
		this.memOfMinStep = new int[N + 1];
		this.memOfMinStep[1] = 0;
		for(int i = 2; i <= N; i++){
			int r = 1 + this.memOfMinStep[i - 1];
			if(i % 2 == 0){
				r = Math.min(r, 1 + memOfMinStep[i / 2]);
			}
			if(i % 3 == 0){
				r = Math.min(r, 1 + memOfMinStep[i / 3]);
			}
			this.memOfMinStep[i] = r;
		}
		return this.memOfMinStep[N]; 
	}
	
	public static void main(String[] args){
		MinStepToOne test = new MinStepToOne();
		//System.out.println(test.getMinStepMemorization(10229));
		System.out.println(test.getMinStepBottomUp(23715713));
	}
}
