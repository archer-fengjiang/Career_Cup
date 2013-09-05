package c8_recursion;
import java.util.*;
public class SubSet {
	private HashSet subSet;
	private HashSet originSet;
	public <AnyType> SubSet(HashSet<AnyType> input){
		subSet = new HashSet<HashSet<AnyType>>();
		originSet = (HashSet<AnyType>)input.clone();
	}
	public <AnyType> HashSet<HashSet<AnyType>> returnSubSet(){
		moreSubSet(originSet);
		return subSet;
	}
	
	private <AnyType> void moreSubSet(HashSet<AnyType> e){
		Iterator itr = e.iterator();
		HashSet<AnyType> tmp;
		while(itr.hasNext()){
			tmp = (HashSet<AnyType>)e.clone();
			tmp.remove(itr.next());
			if(!subSet.contains(tmp) && !tmp.isEmpty()){
				subSet.add(tmp);
			}
			moreSubSet(tmp);
		}
	}
	
	public static void main(String[] args){
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<HashSet<Integer>> subSet;
		Iterator itr, itrSub;
		for(int i = 0; i < 10; i++)
			set.add(i);
		SubSet testSet = new SubSet(set);
		subSet = testSet.returnSubSet();
		itr = subSet.iterator();
		while(itr.hasNext()){
			HashSet<Integer> tmp = (HashSet<Integer>)itr.next();
			itrSub = tmp.iterator();
			while(itrSub.hasNext()){
				System.out.print(itrSub.next());
			}
			System.out.print('\n');
		}
	}
}
