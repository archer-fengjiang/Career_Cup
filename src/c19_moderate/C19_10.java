package c19_moderate;

/**
 * Use rand5() generate rand7().
 * 
 * Expand the rand()
 * 
 * New problem. Use rand3() generate rand4()
 *
 * @author Fengjiang.
 *         Created Aug 16, 2012.
 */
public class C19_10 {

	public int rand4(){
		while(true){
			int sum = 3 * (rand3() -1) + rand3();
			if(sum < 8){
				return sum % 4 + 1;
			}
		}
	}
	
	public int rand3(){
		return 0;
	}
}
