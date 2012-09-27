package colleciton_qustions;

/**
 * print out a matrix clockwise
 * from outside to inside
 * 
 * Note my version avoid using recursion
 * @author Fengjiang.
 *         Created Aug 29, 2012.
 */
public class Google_1 {
    private int[][] matrix;
    private boolean[][] visitedMatrix;
    private int width;
    private int height;

    public Google_1(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        this.matrix = matrix;
        this.height = matrix.length;
        this.width = matrix[0].length;
        visitedMatrix = new boolean[matrix.length][matrix[0].length];
    }

    public void printMatrix(){
        int dir = 1;
        int row = 0;
        int col = -1;
        do{
            if(dir == 1){
                col += 1;
            }
            else if(dir == 2){
                row += 1;
            }
            else if(dir == 3){
                col -= 1;
            }
            else if(dir == 4){
                row -= 1;
            }
            else if(dir == 0){
                break;
            }
            System.out.print(matrix[row][col] + " ");
            visitedMatrix[row][col] = true;
            dir = computeDir(dir, row, col);
        } while(true);
    }

    private int computeDir(int preDir, int row, int col){
        if(preDir == 1){
            if(col + 1 == this.width || visitedMatrix[row][col + 1]){
                if(row + 1 == this.height || visitedMatrix[row + 1][col]){
                    return 0;
                } else {
                    return 2;
                }
            } else {
                return 1;
            }
        }
        else if(preDir == 2){
            if(row + 1 == this.height || visitedMatrix[row + 1][col]){
                if(col - 1 == -1 || visitedMatrix[row][col - 1]){
                    return 0;
                } else {
                    return 3;
                }
            } else {
                return 2;
            }
        }
        else if(preDir == 3){
            if(col - 1 == -1 || visitedMatrix[row][col - 1]){
                if(row - 1 == -1 || visitedMatrix[row - 1][col]){
                    return 0;
                } else {
                    return 4;
                }
            } else {
                return 3;
            }
        }
        else if(preDir == 4){
            if(row - 1 == -1 || visitedMatrix[row - 1][col]){
                if(col + 1 == this.width || visitedMatrix[row][col + 1]){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 4;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        Google_1 tester = new Google_1(matrix);
        tester.printMatrix();
    }
}
