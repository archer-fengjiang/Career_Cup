package colleciton_qustions;

/**
 * Reverse a linkedList, direct reverse and recursion is acceptable, 
 * Cannot create new node
 * 
 * This method use both direct and recursive method
 *
 * @author Fengjiang.
 *         Created Aug 28, 2012.
 */
public class CapitalIQ_1 {
	private Node head;
	private Node tail;
	
	private class Node{
		public int value;
		public Node next;
	}
	
	public void add(int i){
		Node n = new Node();
		n.value = i;
		if(this.head == null){
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	
	public void reverse(String option){
		if(option.equals("recursion")){
			if(head == null || tail == null || head == tail){
				return;
			}
			this.reverseRecursionHelper(head, head.next);
			return;
		}
		if(option.equals("direct")){
			this.reverseDirectHelper();
		}
	}
	
	//Recursive reverse
	private void reverseRecursionHelper(Node pointer1, Node pointer2){
		System.out.println("pointer1:"+pointer1.value+" pointer2:" + pointer2.value);
		if(pointer2 == tail){
			tail = head;
			head = pointer2;
			pointer2.next = pointer1;
			return;
		}
		reverseRecursionHelper(pointer2, pointer2.next);
		pointer2.next = pointer1;
		if(pointer1 == tail){
			System.out.println("setting tail's next to null");
			pointer1.next = null;
		}
		return;
	}
	
	//Direct reverse
	private void reverseDirectHelper(){
		Node pointer1 = head;
		Node pointer2 = head.next;
		while(true){
			if(pointer2 == tail){
				tail = head;
				head = pointer2;
				pointer2.next = pointer1;
				break;
			}
			Node tmp = pointer2.next;
			pointer2.next = pointer1;
			pointer1 = pointer2;
			pointer2 = tmp;
		}
		tail.next = null;
	}
	
	@Override
	public String toString(){
		String str = "";
		for(Node n = this.head; n != null; n = n.next){
			str += n.value + " ";
		}
		return str;
	}
	
	public static void main(String[] args){
		CapitalIQ_1 tester = new CapitalIQ_1();
		for(int i = 0; i < 10; i++){
			tester.add(i);
		}
		System.out.println(tester.toString());
//		tester.reverse("recursion");
		tester.reverse("direct");
		System.out.println(tester.toString());
	}
}
