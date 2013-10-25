package leetcode;

import java.util.Stack;

/**
 * Add BinaryApr 2 '125763 / 16556
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * Solve this problem
 * */
public class AddBinary {

//	public String addBinary(String a, String b) {
//        long aInt = binaryToDecimal(a);
//        long bInt = binaryToDecimal(b);
//        return intToBinary(aInt + bInt);
//    }
//	
//	private long binaryToDecimal(String b){
//		char[] arr = b.toCharArray();
//		int num = 0;
//        for(int i = arr.length - 1; i >= 0; i--){
//            if(arr[i] == '1'){
//                num += Math.pow(2, arr.length - 1 - i);
//            }
//        }
//        return num;
//	}
//	
//	private String intToBinary(long i){
//        Stack<Character> charStack = new Stack<Character>();
//        if(i == 0){
//        	return "0";
//        }
//        while(i != 0){
//        	int tmp = (int)i % 2;
//            charStack.push(new Character((char) ('0' + tmp)));
//            i /= 2;
//        }
//        String str = "";
//        while(!charStack.isEmpty()){
//        	str += charStack.pop();
//        }
//        return str;
//	}
	
	public String addBinary(String a, String b){
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		Stack<Character> aStack = new Stack<Character>();
		Stack<Character> bStack = new Stack<Character>();
		Stack<Character> resultStack = new Stack<Character>();
		for(char c : aArr){
			aStack.push(new Character(c));
		}
		for(char c : bArr){
			bStack.push(new Character(c));
		}
		int addOne = 0;
		while(!aStack.isEmpty() && !bStack.isEmpty()){
			Character aChar = aStack.pop();
			Character bChar = bStack.pop();
			int aInt = aChar.charValue() - '0';
			int bInt = bChar.charValue() - '0';
			int result = aInt + bInt + addOne;
			if(result == 3){
				resultStack.push(new Character('1'));
				addOne = 1;
			}else if(result == 2){
				resultStack.push(new Character('0'));
				addOne = 1;
			}else if(result == 1){
				resultStack.push(new Character('1'));
				addOne = 0;
			}else{
				resultStack.push(new Character('0'));
				addOne = 0;
			}
		}
		
		if(aStack.isEmpty() && bStack.isEmpty() && addOne == 1){
			resultStack.push(new Character('1'));
		}else if(aStack.isEmpty()){
			while(!bStack.isEmpty()){
				Character bChar = bStack.pop();
				int bInt = bChar.charValue() - '0';
				int result = bInt + addOne;
				if(result == 2){
					resultStack.push(new Character('0'));
					addOne = 1;
				}else if(result == 1){
					resultStack.push(new Character('1'));
					addOne = 0;
				}else{
					resultStack.push(new Character('0'));
					addOne = 0;
				}
			}
			if(addOne == 1){
				resultStack.push(new Character('1'));
			}
		}else if(bStack.isEmpty()){
			while(!aStack.isEmpty()){
				Character aChar = aStack.pop();
				int aInt = aChar.charValue() - '0';
				int result = aInt + addOne;
				if(result == 2){
					resultStack.push(new Character('0'));
					addOne = 1;
				}else if(result == 1){
					resultStack.push(new Character('1'));
					addOne = 0;
				}else{
					resultStack.push(new Character('0'));
					addOne = 0;
				}
			}
			if(addOne == 1){
				resultStack.push(new Character('1'));
			}
		}
		
		
		String str = "";
		while(!resultStack.isEmpty()){
			str += resultStack.pop();
		}
		return str;
	}
	
	public static void main(String[] args){
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary("111", "1"));
	}
}
