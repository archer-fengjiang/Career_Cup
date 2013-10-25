package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * */
public class WordSearch {

    private class Spot{
        int row;
        int col;

        public Spot(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

	public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        final int row = board.length;
        final int col = board[0].length;
        Spot[][] spotArr = new Spot[row][col];
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		spotArr[i][j] = new Spot(i,j);
        	}
        }
        Stack<Spot> visitedSpots = new Stack<Spot>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(word.charAt(0) == board[i][j]){
                	visitedSpots.push(spotArr[i][j]);
                	if(search(board, i, j, word, 1, visitedSpots, spotArr)){
                		return true;
                	}
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int r, int c, String word, int index, Stack<Spot> visitedSpots, Spot[][] spotArr){
        if(index == word.length()){
            return true;
        }
        if(r - 1 >= 0 && !visitedSpots.contains(spotArr[r - 1][c]) && board[r - 1][c] == word.charAt(index)){
            visitedSpots.push(spotArr[r - 1][c]);
            if(search(board, r - 1, c, word, index + 1, visitedSpots, spotArr)){
            	return true;
            }
        }
        if(r + 1 < board.length && !visitedSpots.contains(spotArr[r + 1][c]) && board[r + 1][c] == word.charAt(index)){
            visitedSpots.push(spotArr[r + 1][c]);
            if(search(board, r + 1, c, word, index + 1, visitedSpots, spotArr)){
            	return true;
            }
        }
        if(c - 1 >= 0 && !visitedSpots.contains(spotArr[r][c - 1]) && board[r][c - 1] == word.charAt(index)){
        	visitedSpots.push(spotArr[r][c - 1]);
            if(search(board, r, c - 1, word, index + 1, visitedSpots, spotArr)){
                return true;
            }
        }
        if(c + 1 < board[0].length && !visitedSpots.contains(spotArr[r][c + 1]) && board[r][c + 1] == word.charAt(index)){
            visitedSpots.push(spotArr[r][c + 1]);
            if(search(board, r, c + 1, word, index + 1, visitedSpots, spotArr)){
            	return true;
            }
        }
        visitedSpots.pop();
        return false;
    }

    public static void main(String[] args){
        char[][] board = {{'a','a'}};
        WordSearch ws = new WordSearch();
        if(ws.exist(board, "aa")){
        	System.out.println("exist");
        }
    }
}
