package c20_hard;

/**
 * Write a function that adds two numbers 
 * You should not use + or any arithmetic op- erators
 *
 * @author Fengjiang.
 *         Created Aug 17, 2012.
 */
public class C20_1 {
    public int add(int a, int b){
        if(b == 0)
            return a;
        int add = a ^ b;
        int carry = (a & b) << 1;
        return add(add, carry);
    }
    
    public static void main(String[] args){
    	C20_1 tester = new C20_1();
    	System.out.println(tester.add(1, 200));
    }
}
