package c19_moderate;

import java.util.ArrayList;

/**
 * You are given a array of integers (both positive and negative).
 * Find the continuous sequence with the largest sum. Return the sum
 * (and the sequence)
 *
 * @author Fengjiang.
 *         Created Aug 16, 2012.
 */
public class C19_7 {

	public class Sequence{
		public int sum;
		public ArrayList<Integer> sequence;
	}
	
	public Sequence getSubSequence(int[] array){
		boolean hasBeenSet = false;
		int sum = 0;
		int max = 0;
		int start = -1;
		int end = -1;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
			if(sum > max){
				if(!hasBeenSet){
					start = i;
					end = i;
				}else{
					end = i;
				}
				hasBeenSet = true;
				max = sum;
			} else if(sum < 0){
				sum = 0;
				hasBeenSet = false;
			}
		}
		Sequence seq = new Sequence();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = start; i <= end; i++){
			try{
			arr.add(array[i]);
			}catch(Exception e){}
		}
		seq.sequence = arr;
		seq.sum = max;
		return seq;
	}
	
	public static void main(String[] args){
		C19_7 tester = new C19_7();
		int[] array = new int[6];
		array[0] = -1;
		array[1] = -8;
		array[2] = -1;
		array[3] = -2;
		array[4] = -1;
		array[5] = -10;
		Sequence seq = tester.getSubSequence(array);
		System.out.println(seq.sum);
		System.out.println(seq.sequence.toString());
	}
}