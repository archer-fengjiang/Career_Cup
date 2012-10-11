package dynamic_programming;

/**
 * The Longest Increasing Subsequence problem is to find the longest increasing subsequence of a given sequence. 
 * Given a sequence S= {a1 , a2 , a3, a4, ............., an-1, an }
 * we have to find a longest subset such that for all j and i,  j<i in the subset aj<ai.
 *
 * @author Fengjiang.
 *         Created Oct 11, 2012.
 */
public class LongestIncreasingSequence {
	
	public int[] findLongestIncreasingSequence(int[] input){
		int[] seqCount = new int[input.length]; 
		for(int i = 0; i < input.length; i++){
			seqCount[i] = 1;
			for(int j = 0; j < i; j++){
				if(input[j] < input[i] && seqCount[j] + 1 > seqCount[i]){
					seqCount[i] = seqCount[j] + 1;
				}
			}
		}
		int maxSeq = 0;
		int maxSeqEndingPos = 0;
		for(int i = 0; i < input.length; i++){
			if(seqCount[i] > maxSeq){
				maxSeqEndingPos = i;
				maxSeq = seqCount[i];
			}
		}
		int[] longestSeq = new int[maxSeq];
		longestSeq[maxSeq - 1] = input[maxSeqEndingPos];
		for(int i = maxSeqEndingPos - 1, j = maxSeq - 1; i >= 0 && j >= 0; i--){
			if(input[i] < longestSeq[j]){
				longestSeq[--j] = input[i];
			}
		}
		return longestSeq;
	}
	
	public static void main(String[] args){
		LongestIncreasingSequence tester = new LongestIncreasingSequence();
		int[] arr = {10,20,60,70,30,40,22,23,24,25,26,101,89,100};
		int[] seq = tester.findLongestIncreasingSequence(arr);
		for(int i = 0; i < seq.length; i++){
			System.out.print(seq[i] + " ");
		}
	}
}
