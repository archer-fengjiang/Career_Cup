package c8_recursion;

public class Queen_Asnwer {
	int[] columInRow = new int[8];
	public void placeInRow(int row){
		if(row == 8){
			printBoard();
			return;
		}
		for(int i = 0; i < 8; i++){
			columInRow[row] = i;
			if(checkRow(row)){
				placeInRow(row+1);
			}
		}
	}
	private void printBoard(){
		System.out.println("**************new board************");
		for(int i = 0; i < 8; i++)
			System.out.println(columInRow[i]);
	}
	private boolean checkRow(int row){
		for(int i = 0; i < row; i++){
			int diff = Math.abs(columInRow[i] - columInRow[row]);
			if(diff == 0 || diff == Math.abs(row - i))
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		Queen_Asnwer q = new Queen_Asnwer();
		q.placeInRow(0);
	}
}
