package c7_object_oriented_design;

import c7_object_oriented_design.Card.Suit;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Fengjiang.
 *         Created Aug 12, 2012.
 */
public class C7_1 {
	public class BlackJackCard extends Card {

		public BlackJackCard(int c, Suit s) {
			super(c, s);
		}

		public int value(){
			int r = super.value();
			if(r == 1)
				return 11;
			if(r < 10)
				return r;
			return 10;
		}
		
		boolean isAce(){
			int r = super.value();
			if(r == 1)
				return true;
			else
				return false;
		}
	}
	
	public class Card {
		public enum Suit{
			CLUBS(1), SPADE(2), HEART(3), DIAMOND(4);
			int value;
			private Suit(int i){
				this.value = i;
			}
		};
		
		private int card;
		private Suit suit;
		
		public Card(int c, Suit s){
			this.card = c;
			this.suit = s;
		}
		
		public int value()
		{
			return this.card;
		}
		
		public Suit suit(){
			return this.suit;
		}
	}
}
