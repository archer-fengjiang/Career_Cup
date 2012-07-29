package Chapter_8_Recursion;
import java.util.*;
import java.lang.*;
public class HashTable {
	public static void main(String[] args){
		String s1 = new String("BB");
		String s2 = new String("Aa");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	
	}
	public int hashCode(){
		return "this+this".hashCode();
	}
}
