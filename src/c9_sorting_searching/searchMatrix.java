package Chapter_9_Sorting_Searching;
import java.util.*;

public class searchMatrix {
	private int[] finalCor = new int[2];
	public int[] search(int[][] matrix, int target){
		int M = matrix.length;
		int N = matrix[0].length;
		System.out.println("M="+M+" N="+N);
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++){
				if(matrix[i][j] == target){
					finalCor[0] = j;
					finalCor[1] = i;
					return finalCor;
				}
				else if(matrix[i][j] > target){
					if(j < 1){
						finalCor[0] = -1;
						finalCor[1] = -1;
						return finalCor;
					}
					N = j;
				}
			}
		finalCor[0] = -1;
		finalCor[1] = -1;
		return finalCor;
	}
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4,5,6,7},{12,13,14,15,16,17,18},{16,22,23,24,25,26,27},{110,123,156,214,217,256,265}};
		searchMatrix origion = new searchMatrix();
		int[] cordinate = new int[2];
		cordinate = origion.search(matrix, 281);
		System.out.println(Arrays.toString(cordinate));
	}
}