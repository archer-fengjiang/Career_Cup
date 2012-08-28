package c20_hard;

/**
 * Given an NxN matrix of positive and negative integers, 
 * write code to find the sub- matrix with the largest possible sum
 *
 * @author Fengjiang.
 *         Created Aug 24, 2012.
 */
public class C20_12 {
    private int[][] preProcess(int[][] matrix){
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 && j == 0){
                    sumMatrix[i][j] = matrix[i][j];
                }
                else if(i == 0){
                    sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
                }
                else if(j == 0){
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
                }
                else{
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j]; 
                }
            }
        }
        return sumMatrix;
    }

    public int getMax(int[][] matrix){
        int[][] sumMatrix = this.preProcess(matrix);
        for(int i = 0; i < sumMatrix.length; i++){
        	for(int j = 0; j < sumMatrix[0].length; j++){
        		System.out.print(sumMatrix[i][j] +" ");
        	}
        	System.out.println();
        }
        
        int max = Integer.MIN_VALUE;
        for(int col1 = 0; col1 < matrix[0].length; col1++){
            for(int col2 = col1; col2 < matrix[0].length; col2++){
                for(int row1 = 0; row1 < matrix.length; row1++){
                    for(int row2 = row1; row2 < matrix.length; row2++){
                        max = Math.max(max, compute(sumMatrix, row1, row2, col1, col2));
                    }
                }
            }
        }
        return max;
    }

    private int compute(int[][] sumMatrix, int row1, int row2, int col1, int col2){
        if(row1 == 0 && col1 == 0){
            return sumMatrix[row2][col2];
        } else if (row1 == 0){
            return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];
        } else if (col1 == 0){
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        } else {
            return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1] - sumMatrix[row1 - 1][col2] + sumMatrix[row1 - 1][col1 - 1];
        }
    }

    public static void main(String[] args){
        C20_12 tester = new C20_12();
        int[][] matrix = {{6, -7, 11, 5},
                          {1, 4, -8, 0},
                          {9, -2, 3, 11},
                          {-8, 3, 2, 1}};
        System.out.println("max sum is:" + tester.getMax(matrix));
    }
}
