package leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// I:1 V:5 X:10 L:50 C:100 D:500 M:1000
public class RomanToInt {
    
    private Map<Character, Integer> map;
    
    public RomanToInt(){
        this.map = new HashMap<Character, Integer>();
        char[] charArr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        char[] intArr = {1,5,10,50,100,500,1000};
        for(int i = 0; i < charArr.length; i++){
            this.map.put(new Character(charArr[i]), new Integer(intArr[i]));
        }
    }
    
    private int getInt(char c){
        Character C = new Character(c);
        return this.map.get(C).intValue();
    }
    
    public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] charArr = s.toCharArray();
        if(charArr.length == 1){
            return this.getInt(charArr[0]);
        }
        int sum = 0;
        List<Character> charList = new LinkedList<Character>();
        for(char c : charArr){
            charList.add(new Character(c));
        }
        for(int i = 0; i < charList.size() - 1;){
            Integer currentInt = this.map.get(charList.get(i));
            Integer nextInt = this.map.get(charList.get(i + 1));
            if(nextInt > currentInt){
                sum += nextInt.intValue() - currentInt.intValue();
                charList.remove(i);
                charList.remove(i);
            }else{
                i++;
            }
        }
        for(Character C : charList){
            sum += this.map.get(C).intValue();
        }
        return sum;
    }
    
    public static void main(String[] args){
    	RomanToInt r2i = new RomanToInt();
    	System.out.println(r2i.romanToInt("DCLIV"));
    }
}