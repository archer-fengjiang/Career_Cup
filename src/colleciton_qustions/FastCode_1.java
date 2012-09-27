package colleciton_qustions;

/**
 * Transpose A matrix
 *
 * @author Fengjiang.
 *         Created Sep 9, 2012.
 */
public class FastCode_1 {
	final int CACHE_LINE_SIZE = 2;
	public int[][] transpose(int[][] matrix){
		int[][] A = matrix.clone();
//		for(int i = 0; i < A.length; i++){
//			for(int j = 0; j < A[0].length; j++){
//				System.out.print(A[i][j] + " ");
//			}
//			System.out.println();
//		}
		int length = A.length;
		int arear_size = length / this.CACHE_LINE_SIZE;
		for(int arear_row = 0; arear_row < arear_size; arear_row++){
			for(int arear_col = arear_row; arear_col < arear_size; arear_col++){
				int row_offset = arear_row * this.CACHE_LINE_SIZE;
				int col_offset = arear_col * this.CACHE_LINE_SIZE;
				for(int i = 0; i < this.CACHE_LINE_SIZE; i++){
					for(int j = 0; j < this.CACHE_LINE_SIZE; j++){
						if(row_offset + i < col_offset + j){
							int tmp = A[row_offset + i][col_offset + j];
							A[row_offset + i][col_offset + j] = A[col_offset + j][row_offset+i];
							A[col_offset + j][row_offset+i] = tmp;
						}
					}
				}
				
				for(int x = 0; x < length; x++){
					for(int y = 0; y < length; y++){
						System.out.print(A[x][y] + " ");
					}
					System.out.println();
				}
				System.out.println("******");
			}
		}
		int extra_size = length - arear_size * this.CACHE_LINE_SIZE;
		System.out.println("extra_size " + extra_size);
		for(int row = 0 ; row < length; row++){
			for(int j = 0; j < extra_size; j++){
				int col = arear_size * this.CACHE_LINE_SIZE + j;
				System.out.println("col:"+col);
				if(row < col){
					int tmp = A[row][col];
					A[row][col] = A[col][row];
					A[col][row] = tmp;
				}
			}
		}
		return A;
	}
	
	public int[][] transpose_malloc(int[][] matrix){
		int[][] A = new int[matrix.length][matrix[0].length];
		int length = matrix.length;
		int arear_size = length / this.CACHE_LINE_SIZE;
		for(int arear_row = 0; arear_row < arear_size; arear_row++){
			for(int arear_col = 0; arear_col < arear_size; arear_col++){
				int row_offset = arear_row * this.CACHE_LINE_SIZE;
				int col_offset = arear_col * this.CACHE_LINE_SIZE;
				for(int i = 0; i < this.CACHE_LINE_SIZE; i++){
					for(int j = 0; j < this.CACHE_LINE_SIZE; j++){
						A[col_offset + j][row_offset + i] = matrix[row_offset + i][col_offset + j];
					}
				}
			}
		}
		
		int extra_size = length - arear_size * this.CACHE_LINE_SIZE;
		for(int row = 0 ; row < length; row++){
			for(int j = 0; j < extra_size; j++){
				int col = arear_size * this.CACHE_LINE_SIZE + j;
				A[row][col] = matrix[col][row];
				A[col][row] = matrix[row][col];
			}
		}
		
		return A;
	}
	
	public static void main(String[] args){
		FastCode_1 test = new FastCode_1();
		int[][] matrix = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
		matrix = test.transpose_malloc(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}