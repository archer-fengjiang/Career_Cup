package leetcode;

public class AnagramPalindrome {
	
	public int solution(String S){
		if(S == null || S.length() == 0){
			return 0;
		}
		
		int[] bitSet = new int[26];
		for(int i = 0; i < bitSet.length; i++){
			bitSet[i] = 0;
		}
		int countOfOne;
		// even number
		if(S.length() % 2 == 0){
			countOfOne = 0;
		}
		// odd number
		else{
			countOfOne = 1;
		}
		
		for(int i = 0; i < S.length(); i++){
			int pos = S.charAt(i) - 'a';
			flipBit(bitSet, pos);
		}
		
		int tmpCountOfOne = 0;
		for(int i : bitSet){
			if(i == 1){
				tmpCountOfOne++;
				if(tmpCountOfOne > countOfOne){
					return 0;
				}
			}
		}
		if(tmpCountOfOne != countOfOne){
			return 0;
		}else{
			return 1;
		}
	}
	
	private void flipBit(int[] bitSet, int pos){
		if(bitSet[pos] == 0){
			bitSet[pos] = 1;
		} else {
			bitSet[pos] = 0;
		}
	}
}
