package colleciton_qustions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/**
 * Given a list of makefile dependency, print out order of compile
 * 
 * ram@twitter.com
 *
 * Hi Ram, I think marking level on file could be a better way to tack this 
 * problem, because the path might converge on one file and I didn't cover 
 * this situation during the talk with you.
 * 
 * So the idea with level comes with this:
 * A file with higher level would be complied prior to files with lower level,
 * all file originally has level 0. So while we traverse through the 
 * dependency "graph" starting from each file in the not-depended-set, we are 
 * adding levels and try to mark level on files. If the levels we want to mark
 * for one file is smaller than the file's current level, we stop this traversal
 * 
 *
 * @author Fengjiang.
 *         Created Sep 12, 2012.
 */
public class Twitter_1 {
	Map<String, Set<String>> dependencyMap = new HashMap<String, Set<String>>();
	Set<String> dependedSet = new HashSet<String>();
	Set<String> notDependedSet = new HashSet<String>();
	int maxLevel = 0;
	// file -> level in dependency, level initialized to be 0
	// file with highest level will be compiled first
	Map<String, Integer> levelMap = new HashMap<String, Integer>(); 
	
	public List<String> getDependencyListForCompile(Depend[] dependArr){
		List<String> dependencyList = new LinkedList<String>();
		// 1. Set up the dependency map (String -> Set<String>)
		// 2. Determine which file has been depended and what file hasn't been depended
		for(int i = 0; i < dependArr.length; i++){
			Depend tmpDepend = dependArr[i];
			dependencyMap.put(tmpDepend.file, tmpDepend.dependSet);
			levelMap.put(tmpDepend.file, 0);
			if(!dependedSet.contains(tmpDepend.file)){
				notDependedSet.add(tmpDepend.file);
			}
			
			Set<String> tmpDependSet = tmpDepend.dependSet;
			Iterator itr = tmpDependSet.iterator();
			while(itr.hasNext()){
				String file = (String)itr.next();
				levelMap.put(file, 0);
				notDependedSet.remove(file);
				dependedSet.add(file);
			}
		}
		
		System.out.println("\nDepended Set:" + dependedSet.toString());
		System.out.println("Not Depended Set:" + notDependedSet.toString() + "\n");
		
		// star traversing from files in notDependedSet and mark level on each file
		Iterator itr = notDependedSet.iterator();
		while(itr.hasNext()){
			String fileToBeign = (String)itr.next();
			getsDown(fileToBeign, 0);
		}
		
		// create set array, index indicates level of elements in the set
		Set[] setArr = new Set[maxLevel + 1];
		for(int i = 0; i < setArr.length; i++){
			setArr[i] = new HashSet<String>();
		}
		
		itr = levelMap.keySet().iterator();
		while(itr.hasNext()){
			String file = (String)itr.next();
			int level = levelMap.get(file);
			setArr[level].add(file);
		}
		
		// the generate the dependency list
		for(int i = maxLevel; i >= 0 ;i--){
			Set set = setArr[i];
			itr = set.iterator();
			while(itr.hasNext()){
				String file = (String)itr.next();
				dependencyList.add(file);
			}
		}
		return dependencyList;
		
	}
	
	private void getsDown(String file, int newLevel){
		maxLevel = Math.max(maxLevel, newLevel);
		
		int originLevel = levelMap.get(file);
		// the recursion will stop if level on this file is bigger than level on this traversal
		if(originLevel > newLevel){
			return;
		}
		// otherwise, overwrite/update new level on this file
		originLevel = newLevel;
		levelMap.put(file, originLevel);
		
		// continue traverse down
		Set<String> dependSet = dependencyMap.get(file);
		if(dependSet == null){
			return;
		}
		Iterator itr = dependSet.iterator();
		while(itr.hasNext()){
			String tmpFile = (String)itr.next();
			getsDown(tmpFile, originLevel + 1);
		}
	}
	
	public static void main(String[] args){
		Set<String> fileSet = new HashSet<String>();
		Depend[] testArr = new Depend[7];
		System.out.println("Creating dependency files below...");
		// A ->{B, C, D}
		fileSet.add("B");
		fileSet.add("C");
		fileSet.add("D");
		testArr[0] = new Depend("A", fileSet);
		fileSet = new HashSet<String>();
		
		// B ->{J, E}
		fileSet.add("J");
		fileSet.add("E");
		testArr[1] = new Depend("B", fileSet);
		fileSet = new HashSet<String>();
		
		// C ->{E}
		fileSet.add("E");
		testArr[2] = new Depend("C", fileSet);
		fileSet = new HashSet<String>();
		
		// D ->{F}
		fileSet.add("F");
		testArr[3] = new Depend("D", fileSet);
		fileSet = new HashSet<String>();
		
		// F->{E, G}
		fileSet.add("E");
		fileSet.add("G");
		testArr[4] = new Depend("F", fileSet);
		fileSet = new HashSet<String>();
		
		// E->{H, I}
		fileSet.add("H");
		fileSet.add("I");
		testArr[5] = new Depend("E", fileSet);
		fileSet = new HashSet<String>();
		
		// J->{G, I}
		fileSet.add("G");
		fileSet.add("I");
		testArr[6] = new Depend("K", fileSet);
		fileSet = new HashSet<String>();

		for(int i = 0; i < testArr.length; i++){
			System.out.print(testArr[i].file + "->");
			Iterator itr = testArr[i].dependSet.iterator();
			while(itr.hasNext()){
				System.out.print((String)itr.next() + " ");
			}
			System.out.println();
		}
		
		Twitter_1 tester = new Twitter_1();
		System.out.println("order to compile result:" + tester.getDependencyListForCompile(testArr).toString());
	}
}

class Depend{
	public String file;
	Set<String> dependSet;
	
	public Depend(String file, Set<String> dependSet){
		this.file = file;
		this.dependSet = dependSet;
	}
}

