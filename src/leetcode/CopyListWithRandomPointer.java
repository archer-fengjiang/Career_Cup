package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * */
public class CopyListWithRandomPointer {
	class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
	}
	
	Map<RandomListNode, RandomListNode> map;
	
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	if(head == null){
    		return null;
    	}
        this.map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        helperDriverI(head, newHead);
        helperDriverII(head, newHead);
        return newHead;
    }
    
    private void helperDriverI(RandomListNode oriNode, RandomListNode newNode){
    	if(oriNode.next == null){
    		return;
    	}
    	newNode.next = new RandomListNode(oriNode.next.label);
    	this.map.put(oriNode.next, newNode.next);
    	helperDriverI(oriNode.next, newNode.next);
    }
    
    private void helperDriverII(RandomListNode oriNode, RandomListNode newNode){
    	if(oriNode == null){
    		return;
    	}
    	if(oriNode.random != null){
    		newNode.random = this.map.get(oriNode.random);
    	}
    	helperDriverII(oriNode.next, newNode.next);
    }
}
