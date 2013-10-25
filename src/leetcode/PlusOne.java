package leetcode;
/**
 * Given a number represented as an array of digits, plus one to the number.
 * */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null && digits.length == 0){
            return null;
        }
        int notNighPos = digits.length - 1;
        while(notNighPos >= 0){
            if(digits[notNighPos] != 9){
                break;
            }
            notNighPos--;
        }
        if(notNighPos != -1){
            digits[notNighPos]++;
            for(int i = notNighPos + 1; i < digits.length; i++){
                digits[i] = 0;
            }
            return digits;
        }
        else{
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }
}
