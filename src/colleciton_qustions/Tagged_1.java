package colleciton_qustions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Fengjiang.
 *         Created Sep 21, 2012.
 */
public class Tagged_1 {
	Map<Integer,Integer> indexToDigitMap = new HashMap<Integer, Integer>();
	//Set<Integer> usedDigitSet = new HashSet<Integer>();
	
	public int nextSelfSwapNumber(int i){
		this.createInputToDigitMap(i);
		Set<Integer> visitedIndexSet = new HashSet<Integer>();
		Set<Integer> showedDigitSet = new HashSet<Integer>();
		
		//return computeNextSelfSwapNumber
		return -1;
	}
	
	/**
	 * This method creates a map from index of digit to digit in the input int
	 * */
	private void createInputToDigitMap(int input){
		String numberStr = Integer.toString(input);
		for(int i = 0; i < numberStr.length(); i++){
			String digitStr = numberStr.substring(i, i+1);
			int digit = Integer.parseInt(digitStr);
			this.indexToDigitMap.put(i, digit);
		}
	}
}
