package c19_moderate;

/**
 * Write a method to decide hit and pseudo-hit of 
 * The Game of Master Mind is played as follows:
 *
 * @author Fengjiang.
 *         Created Aug 13, 2012.
 */
public class C19_5 {
	
	private class Result{
		public int hit;
		public int pseudo_hit;
	}
	
	public Result esitmate(String guess, String solution){
		int mask = 0; // bit mask is an amazing way to check repeated element
		Result res = new Result();
		for(int i = 0 ; i < guess.length(); i++){
			mask |= 1 << (solution.charAt(i) - 'A');
		}
		for(int i = 0; i < guess.length(); i++){
			if(guess.charAt(i) == solution.charAt(i)){
				res.hit++;
			} else if((guess.charAt(i) & mask )> 0){
				res.pseudo_hit++;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		C19_5 tester = new C19_5();
		Result res = tester.esitmate("ABCD","ABCD");
		System.out.println(res.hit + ";" + res.pseudo_hit);
	}

}
