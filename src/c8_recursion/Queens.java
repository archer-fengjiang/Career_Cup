package c8_recursion;
import java.util.*;
public class Queens {
	ArrayList<boolean[][]> queens = new ArrayList<boolean[][]>();
	
	public ArrayList<boolean[][]> setQueens(){
		boolean[][] board = new boolean[8][8];
		for(int i = 0; i<8;i++)
			for(int j = 0; j < 8; j++)
				board[i][j] = false;
		int num = 8;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				boolean[][] tmpBoard = arrayClone(board);
				tmpBoard[i][j] = true;
				boolean[][] tmpOccupied = calculateOccupied(tmpBoard);
				setQueensHelper(tmpBoard, tmpOccupied, num-1);
			}
		return queens;
	}
	
	private void setQueensHelper(boolean[][] board, boolean[][] occupied, int n){
		if(n == 0){
			queens.add(board);
			return;
		}
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(!board[i][j] && !occupied[i][j]){
					boolean[][] tmpBoard = arrayClone(board);
					tmpBoard[i][j] = true;
					boolean[][] tmpOccupied = calculateOccupied(tmpBoard);
					setQueensHelper(tmpBoard, tmpOccupied, n-1);
				}
		return;
	}
	
	private boolean[][] calculateOccupied(boolean[][] queensPos){
		boolean[][] occupied = new boolean[8][8];
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				if(queensPos[i][j]){
					for(int k = 0; k < 8; k++){
						occupied[k][j] = true;
						occupied[i][k] = true;
						if(i-k >= 0 && j-k >= 0)
							occupied[i-k][j-k] = true;
						if(i+k < 8 && j-k >= 0)
							occupied[i+k][j-k] = true;
						if(i-k >= 0 && j+k < 8)
							occupied[i-k][j+k] = true;
						if(i+k < 8 && j+k < 8)
							occupied[i+k][j+k] = true;
					}
				}
			}
		
		return occupied;
	}
	
	private boolean[][] arrayClone(boolean[][] origin){
		boolean[][] b = new boolean[origin.length][origin[0].length];
		for(int i = 0; i < origin.length; i++)
			for(int j = 0; j < origin[0].length; j++)
				b[i][j] = origin[i][j];
		return b;
	}
	public static void main(String[] args){
		ArrayList<boolean[][]> result;
		Queens que = new Queens();
		Iterator itr;
		result = que.setQueens();
		itr = result.iterator();
		while(itr.hasNext()){
			boolean[][] tmp;
			tmp = (boolean[][])itr.next();
			for(int i = 0; i<8; i++){
				for(int j = 0; j <8; j++){
					if(tmp[i][j])
						System.out.print(1);
					else
						System.out.print(0);
				}
			System.out.print('\n');
			}
			System.out.print('\n');
		}
	}
	
}
