package Chapter_8_Recursion;
import java.util.*;
/*8.4*/
public class Permutation {
	HashSet<String> finalSet;
	
	public Permutation(){
		finalSet= new HashSet<String>();
	}
	
	public HashSet<String> getPermutation(String str){
		char[] charArr = str.toCharArray();
		ArrayList<String> charList = new ArrayList<String>();
		ArrayList<String> newCharList;
		String newStr = "";
		Iterator itr;
		for(int i = 0; i<charArr.length; i++)
			charList.add(newStr+charArr[i]);
		
		System.out.println(charList.toString());
		
		itr = charList.iterator();
		while(itr.hasNext()){
			newStr = (String)itr.next();
			newCharList = (ArrayList<String>)charList.clone();
			newCharList.remove(newStr);
			PermutationHelper(newCharList, newStr);
		}
		return finalSet;
	}
	
	private void PermutationHelper(ArrayList<String> charList, String tmpStr){
		Iterator itr;
		String newStr;
		String newTmpStr;
		ArrayList<String> newcharList;
		if(charList.isEmpty()){
			finalSet.add(tmpStr);
			return;
		}
		else{
			itr = charList.iterator();
			while(itr.hasNext()){
				newStr = (String)itr.next();
				newTmpStr = tmpStr + newStr;
				newcharList = (ArrayList<String>)charList.clone();
				newcharList.remove(newStr);
				PermutationHelper(newcharList, newTmpStr);
			}
		}
	}
	
	public static void main(String[] args){
		Permutation per = new Permutation();
		Iterator itr;
		HashSet<String> perSet = per.getPermutation("11112");
		itr = perSet.iterator();
		while(itr.hasNext()){
			System.out.println((String)itr.next());
		}
	}
}
