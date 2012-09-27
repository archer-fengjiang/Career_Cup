package c20_hard;

/**
 * Imagine you have a square matrix, where each cell is filled with either black or white 
 * Design an algorithm to find the maximum subsquare 
 * such that all four borders are filled with black pixels
 *
 * @author Fengjiang.
 *         Created Aug 24, 2012.
 */
public class C20_11 {
    private class Square{
        public int row;
        public int col;
        public int dif;
    }

    /**
     * Return null if input matrix is invalid
     */
    public Square getMaxSubsquare(int[][] matrix){
        if(matrix == null || matrix.length < 2 || matrix[0].length < 2  || matrix.length != matrix[0].length){
            return null;
        }

        int N = matrix.length;
        System.out.println("N:"+N);
        int maxDif = 0;
        Square maxSubSquare = new Square();
        for(int col = 1; col < N; col++){
            if((N - col) <= maxDif){
                break;
            }
            for(int row = 0; row < col; row++){
                if(matrix[row][col] != 1){
                	System.out.println("get hit at row:" + row + " and col:" + col);
                    continue;
                }
                int maxLengthDif = col - row;
                for(int dif = 1; dif <= maxLengthDif && dif > maxDif; dif++){
                    if(matrix[row][col - dif] == 1 && matrix[row + dif][col - dif] == 1 && matrix[row + dif][col] == 1){
                        if(dif > maxDif){
                            maxDif = dif;
                            maxSubSquare.row = row;
                            maxSubSquare.col = col;
                            maxSubSquare.dif = dif;
                        }
                    }
                }
            }
        }
        return maxSubSquare;
    }

    public static void main(String[] args){
        C20_11 tester = new C20_11();
        int[][] matrix = {{1, 1, 0, 1}, 
                   {0, 0, 0, 0},
                   {1, 0, 1, 0},
                   {1, 0, 0, 1}};

        Square maxSquare = tester.getMaxSubsquare(matrix);
        System.out.println(maxSquare.row + ":" + maxSquare.col + ":" + maxSquare.dif);
    }
}