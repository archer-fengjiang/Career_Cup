package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * */
public class NQueens {
	
	private class Pos{
		int row;
		int col;
		
		public Pos(int r, int c){
			this.row = r;
			this.col = c;
		}
	}
	
	public ArrayList<String[]> solveNQueens(int n) {
		Pos[][] posMatrix = new Pos[n][n];
		
		boolean[] rowAvi = new boolean[n];
		boolean[] colAvi = new boolean[n];
		
		for(int i = 0; i < n; i++){
			rowAvi[i] = true;
			colAvi[i] = true;
			for(int j = 0; j < n; j++){
				posMatrix[i][j] = new Pos(i,j);
			}
		}
		
		Stack<Pos> stack = new Stack<Pos>();
		
		for(int i = 0; i < n; i++){
			
		}
	}
	
	private helperDriver(Stack<Pos> queenStack, int row, Pos[][] posMatrix){
		if(row == posMatrix.length){
			if(queenStack.size() == row){
				
			}
		}
		
		for(int j = 0; j < posMatrix.length; j++){
			if(canPut(queenStack, posMatrix[row][j])){
				queenStack.push(posMatrix[row][j]);
				helperDriver(queenStack, row + 1, posMatrix);
			}
		}
	}
	
	private boolean canPut(Stack<Pos> queenStack, Pos newPos){
		for(Pos p : queenStack){
			if(p.col == newPos.col){
				return false;
			}
			if((p.col - newPos.col) == (p.row - newPos.row)){
				return false;
			}
		}
		return true;
	}
}