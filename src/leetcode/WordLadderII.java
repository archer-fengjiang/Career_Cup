package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 *
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * */
public class WordLadderII {
	
	private ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
	private int minSize = Integer.MAX_VALUE;
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		Stack<String> visitedWords = new Stack<String>();
		dict.add(end);
		visitedWords.add(start);
		helperDriver(start, end, visitedWords, dict);
		return this.array;
	}
	
	private void helperDriver(String word, String end, Stack<String> visitedWords, Set<String> dict){
		//if we hit the end word
		if(word.equals(end) && visitedWords.size() <= this.minSize){
			this.minSize = visitedWords.size();
			// delete all arr that has size larger
			for(int i = 0; i < this.array.size(); i++){
				if(this.array.get(i).size() > visitedWords.size()){
					this.array.remove(i);
				}
			}
			
			// add current visitedWord queue
			ArrayList<String> newArr = new ArrayList<String>();
			for(String str : visitedWords){
				newArr.add(str);
			}
			this.array.add(newArr);
			visitedWords.pop();
			return;
		}
		// keep looking for new transition
		for(String str : dict){
			if(!visitedWords.contains(str) && isTransmisive(word, str)){
				visitedWords.push(str);
				helperDriver(str, end, visitedWords, dict);
			}
		}
		
		// pop current word before returning to previous level
		visitedWords.pop();
	}
	
	private boolean isTransmisive(String s1, String s2){
		if(s1 == null || s2 == null || s1.equals(s2) || s1.length() != s2.length()){
			return false;
		}
		int difCount = 0;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				difCount++;
				if(difCount > 1){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		WordLadderII wl = new WordLadderII();
//		String[] strArr = {"hot","dot","dog","lot","log"};
		String[] strArr = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		HashSet<String> dict = new HashSet<String>();
		for(String str : strArr){
			dict.add(str);
		}
		ArrayList<ArrayList<String>> arrlists = wl.findLadders("qa", "sq", dict);
		System.out.println(arrlists.size());
		for(ArrayList<String> arr : arrlists){
			for(String str : arr){
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
