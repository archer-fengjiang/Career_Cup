package c20_hard;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle
 * in other words, each 52! permutations of the deck has to be equally likely.
 * Assume that you are given a random number generator which is perfect
 *
 * @author Fengjiang.
 *         Created Aug 17, 2012.
 */
public class C20_2 {
    public void shuffleCards(int[] cards){
        for(int i = 0; i < cards.length; i++){
            int pos = i + (int)(Math.random()*(cards.length -i));
            int tmp = cards[i];
            cards[i] = cards[pos];
            cards[pos] = tmp;
        }
    }

    public static void main(String[] args){
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }

        C20_2 tester = new C20_2();
        tester.shuffleCards(array);

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
