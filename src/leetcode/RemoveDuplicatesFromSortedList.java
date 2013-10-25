package leetcode;
/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * */
public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
        	return null;
        }
        ListNode x = head;
        ListNode y = head;
        while(x != null){
        	while(y.next != null && y.next.val == x.val){
        		y = y.next;
        	}
        	x.next = y.next;
        	x = y.next;
        	y = y.next;
        }
        return head;
    }
}
