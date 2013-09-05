package c8_recursion;
public class Fibonacci{
	public int RecurFibo(int n){
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		else if(n>1){
			return RecurFibo(n-1)+RecurFibo(n-2);
		}
		else{
			return -1;
		}
	}
	public int IteraFibo(int n){
		if(n<0)
			return -1;
		else if(n==0){
			return 0;
		}
		else{
			int a=0, b=1,c=0;
			for(int i=1;i<n;i++){
				c=a+b;
				a=b;
				b=c;
			}
			return c;
		}
	}
	public static void main(String[] args){
		Fibonacci b = new Fibonacci();
		System.out.println(b.IteraFibo(14));
	}
}
