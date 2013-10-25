package leetcode;

public class NumberOfPrimes {
	 static int getNumberOfPrimes(int N) {
		int priCount = 0;
		for(int i = 1; i <= N; i++){
			boolean isPrime = true;
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					isPrime = false;
					break;
				}
				
			}
			if(isPrime){
				priCount++;
				System.out.println(i);
			}
		}
		return priCount;
	}
	
	
	static public void main(String[] args){
		NumberOfPrimes x = new NumberOfPrimes();
		System.out.println(NumberOfPrimes.getNumberOfPrimes(100));
	}
}
