package colleciton_qustions;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Write code to implement a queue using an array.
 * How do you identify if the queue is circular?
 *
 * @author Fengjiang.
 *         Created Sep 5, 2012.
 */
public class Apple_1<T>{
	private class CircularArrayQueue<T> implements Queue{
		int front = 0;
		int rear = 0;
		Object[] array;
		
		public CircularArrayQueue(int size){
			this.array = new Object[size];
		}
		
		@Override
		public boolean addAll(Collection arg0) {
			Iterator itr = arg0.iterator();
			boolean ifSuccess = true;
			while(itr.hasNext()){
				int oldRear = rear;
				rear = (rear + 1) % array.length;
				
				if(rear == front){
					rear = oldRear;
					ifSuccess = false;
				}
				else{
					array[rear] = itr.next();
				}
			}
			return ifSuccess;
		}

		@Override
		public void clear() {
			rear = front;
		}

		@Override
		public boolean contains(Object arg0) {
			for(int i = front; i != rear; i = (i+1) % array.length){
				int pos = (i + 1) % array.length;
				if(array[pos].equals(arg0)){
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean containsAll(Collection arg0) {
			Iterator itr = arg0.iterator();
			while(itr.hasNext()){
				if(!this.contains(itr.next())){
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean isEmpty() {
			if(front == rear){
				return true;
			}
			else{
				return false;
			}
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public boolean remove(Object arg0) {
			// TODO Auto-generated method stub.
			return false;
		}

		@Override
		public boolean removeAll(Collection arg0) {
			// TODO Auto-generated method stub.
			return false;
		}

		@Override
		public boolean retainAll(Collection arg0) {
			// TODO Auto-generated method stub.
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub.
			return 0;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public Object[] toArray(Object[] arg0) {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public boolean add(Object arg0) {
			// TODO Auto-generated method stub.
			return false;
		}

		@Override
		public Object element() {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public boolean offer(Object arg0) {
			// TODO Auto-generated method stub.
			return false;
		}

		@Override
		public Object peek() {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public Object poll() {
			// TODO Auto-generated method stub.
			return null;
		}

		@Override
		public Object remove() {
			// TODO Auto-generated method stub.
			return null;
		}
		
	}

	public static void main(String[] args){
		int a = (1 << 31) - 1;
		System.out.println(a);
	}
}
