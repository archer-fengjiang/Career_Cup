package c20_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Numbers are randomly generated and passed to a method 
 * Write a program to find and maintain the median value as new values are generated
 *
 * @author Fengjiang.
 *         Created Aug 23, 2012.
 */
public class C20_9 {
    private Comparator<Integer> maxComparator = new MaxHeapComparator();
    private Comparator<Integer> minComparator = new MinHeapComparator();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, maxComparator);
    public PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, minComparator);

    private class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y){
            if(x == y){
                return 0;
            } else if (x < y) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private class MinHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y){
            if(x == y){
                return 0;
            } else if (x < y) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public void insert(int value){
    	
    	// if heap not initialized, directly insert into maxHeap
    	if(this.maxHeap.isEmpty()){
    		maxHeap.add(value);
    		return;
    	}
    	
        // Compare with median value to decide which heap to insert
        int median = this.getMedian();
        if(value <= median){
            this.maxHeap.add(value);
            if(maxHeap.size() - minHeap.size() > 1){
                int max = maxHeap.poll();
                this.minHeap.add(max);
            }
        } else {
            this.minHeap.add(value);
            if(minHeap.size() - maxHeap.size() > 1){
                int min = minHeap.poll();
                this.maxHeap.add(min);
            }
        }
        return;
    }

    public int getMedian(){
        if(maxHeap.size() >= minHeap.size()){
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args){
        C20_9 tester = new C20_9();
        int[] arr = {4,6,1,2,7,3,6,10,2};
        for(int i = 0; i < arr.length; i++){
            tester.insert(arr[i]);
            // note that toString is using iterator, which is not guaranteed to traversed in sorted order
            System.out.println("inserted:"+arr[i]+", now median is:"+ tester.getMedian());
            System.out.println("        maxHeap:"+tester.maxHeap.toString());
            System.out.println("        minHeap:"+tester.minHeap.toString());
        }
    }
}
