package c5_bit_manipulation;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M 
 * (e.g., M becomes a substring of N located at i and starting at j)
 *
 * @author Fengjiang.
 *         Created Aug 6, 2012.
 */
public class C5_1 {
	public int changeBits(int N, int M, int i, int j){
		int max = ~0;
		int mask = (max - (~(1<<j -1))) | (1<<i - 1);
		return (N & mask) | (M << i);
	}
}
