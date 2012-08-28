package c20_hard;

/**
 * Write a method to randomly generate a set of m Integers
 * from an array of size of n. Each element must have equal probability
 * of being chosen
 *
 * @author Fengjiang.
 *         Created Aug 18, 2012.
 */
public class C20_3 {
    public int[] randSelectFromArray(int[] array, int m){
        if(m > array.length){
            return null;
        }
        int[] clone = array.clone();
        int[] sa = new int[m];

        for(int i = 0; i < m; i++){
            int pos = i + (int)(Math.random() * (clone.length - i));
            sa[i] = clone[pos];
            clone[pos] = clone[i];
            clone[i] = sa[i];
        }

        return sa;
    }

    public static void main(String[] args){
        C20_3 tester = new C20_3();
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }

        int[] selectedArr = tester.randSelectFromArray(array, 10);
        for(int i = 0; i < selectedArr.length; i++){
            System.out.println(selectedArr[i]);
        }
    }
}
