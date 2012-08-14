package c7_object_oriented_design;

import java.util.ArrayList;

/**
 * Design a chess game using object oriented principles
 *
 * @author Fengjiang.
 *         Created Aug 13, 2012.
 */
public class C7_4 {
	/**
	 * Think of what makes up a game?
	 * Player's turn, each move, position
	 * */
	public class GameManager{
		Position currentPosition;
		/**
		 * Chess game has turn
		 * */
		void processTurn(PlayerBase player) {};
		
		/**
		 * Each turn made by player could be legal or illegal
		 * We assume all turn are legal
		 * */
		boolean acceptTurn(ChessPieceTurn turn){
			return true;
		}
	}
	
	public class ChessPieceTurn{}
	
	public abstract class PlayerBase{
		public abstract ChessPieceTurn getTurn(Position p);
	}
	
	/**
	 * Think what should AI have?
	 * Difficulty, Brain to play
	 * */
	public class ComputerPlayer extends PlayerBase{
		public ChessPieceTurn getTurn(Position p){
			return null;
		}
		public void setDifficulty() {};
		public PositionEstimator estimator;
		public PositionBackTracker backTracker;
	}
	
	public class HumanPlayer extends PlayerBase{
		public ChessPieceTurn getTurn(Position p){
			return null;
		}
	}
	
	public abstract class ChessPieceBase{
		public abstract boolean canBeChecked();
		public abstract boolean isSupportCastle();
	}
	
	public class King extends ChessPieceBase{
		@Override
		public boolean canBeChecked() {
			return false;
		}
		@Override
		public boolean isSupportCastle() {
			return false;
		}
	}
	
	public class Queen extends ChessPieceBase{
		@Override
		public boolean canBeChecked() {
			return false;
		}

		@Override
		public boolean isSupportCastle() {
			return false;
		}
	}
	
	public class Position {
		ArrayList<ChessPieceBase> black;
		ArrayList<ChessPieceBase> white;
	}
	
	public class PositionBackTracker{
		public Position getNext(Position p){
			return null;
		}
	}
	
	public class PositionEstimator{
		public PositionPotentialValue estimate(Position p){
			return null;
		}
	}
	
	public abstract class PositionPotentialValue{
		public abstract boolean lessThan(PositionPotentialValue pv);
	}
}
