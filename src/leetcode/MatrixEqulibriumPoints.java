package leetcode;

public class MatrixEqulibriumPoints {
	public int solution(int[][] A){
		if(A == null || A.length == 0 || A[0].length == 0){
			return 0;
		}
		
		int rowCount = A.length;
		int colCount = A[0].length;
		
		int equliRowCount = 0;
		int equliColCount = 0;
		
		long[] rowSums = new long[rowCount];
		long[] colSums = new long[colCount];
		
		// Sums total
		long totalSumOfMatrix = 0;
		for(int i = 0; i < rowCount; i++){
			long sumOfRow = 0;
			for(int j = 0; j < colCount; j++){
				sumOfRow += A[i][j];
			}
			rowSums[i] = sumOfRow;
			totalSumOfMatrix += sumOfRow;
		}
		
		for(int i = 0; i < colCount; i++){
			long sumOfCol = 0;
			for(int j = 0; j < rowCount; j++){
				sumOfCol += A[j][i];
			}
			colSums[i] = sumOfCol;
		}
		
		long tmpSumOfRow = 0;
		for(int row = 0; row < rowCount; row++){
			tmpSumOfRow += rowSums[row];
			if(tmpSumOfRow - rowSums[row] == totalSumOfMatrix - tmpSumOfRow){
				equliRowCount++;
			}
		}
		
		long tmpSumOfCol = 0;
		for(int col = 0; col < colCount; col++){
			tmpSumOfCol += colSums[col];
			if(tmpSumOfCol - colSums[col] == totalSumOfMatrix - tmpSumOfCol){
				equliColCount++;
			}
		}
		
		return equliColCount * equliRowCount;
	}
	
	public static void main(String[] args){
		int[][] matrix = {{2, 7, 5}, {3, 1, 1}, {2, 1, -7}, {0, 2, 1}, {1, 6, 8}};
		MatrixEqulibriumPoints solution = new MatrixEqulibriumPoints();
		System.out.println(solution.solution(matrix));
	}
	
}
