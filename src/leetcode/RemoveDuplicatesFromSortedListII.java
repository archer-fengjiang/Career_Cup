package leetcode;

import leetcode.RemoveDuplicatesFromSortedList.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * */
public class RemoveDuplicatesFromSortedListII {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		//first set head
		ListNode x = head;
		boolean dup = false;
		while(true){
			if(dup){
				if(x.next == null || x.next.val != x.val){
					head = x.next;
					x = x.next;
					dup = false;
				}else{
//					System.out.println("point 3");
					x = x.next;
				}
			}else if(x == null || x.next == null){
				break;
			}
			else if(x.next.val == head.val){
//				System.out.println("point 4");
				dup = true;
				x = x.next;
			}else{
				break;
			}
 		}
 		if(head == null || head.next == null){
 			return head;
 		}

 		//then set following node
 		dup = false;
 		ListNode y = head;
 		x = head.next;
 		while(true){
 			if(dup){
 				if(x.next == null){
 					y.next = null;
 					break;
 				} else if( x.next.val != x.val){
 					y.next = x.next;
 					x = x.next;
 					dup = false;
 				}else{
 					x = x.next;
 				}
 			}else if(x.next == null){
 				break;
 			}
 			else if(x.next.val == y.next.val){
 				dup = true;
 				x = x.next;
 			}else{
 				y = y.next;
 				x = x.next;
 			}
 		}
 		return head;
    }
	
	public static void main(String[] args){
		RemoveDuplicatesFromSortedListII rm = new RemoveDuplicatesFromSortedListII();
		ListNode root = rm.new ListNode(1);
		ListNode second = rm.new ListNode(1);
		ListNode third = rm.new ListNode(2);
		
		root.next = second;
		second.next = third;
		
		root = rm.deleteDuplicates(root);
		while(root != null){
			System.out.println(root.val);
			root = root.next;
		}
	}
}
