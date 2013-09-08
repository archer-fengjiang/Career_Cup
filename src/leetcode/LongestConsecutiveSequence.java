package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestConsecutiveSequence{
    public class Sequence{
        int start;
        int end;
        public Sequence(int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        Map<Integer, Sequence> map = new HashMap<Integer, Sequence>();
        for(int i = 0; i < num.length; i++){
        	int x = num[i];
            if(map.containsKey(x)){
            	continue;
            }
            // x connects two sequences
            if(map.containsKey(x)){
            	continue;
            }
            else if(map.containsKey(x + 1) && map.containsKey(x - 1)){
            	Sequence seq_small = map.get(x - 1);
            	Sequence seq_large = map.get(x + 1);
            	Sequence newSeq = new Sequence(seq_small.start, seq_large.end);
                map.put(seq_small.start, newSeq);
                map.put(seq_large.end, newSeq);
                map.put(x, newSeq);
            }

            // x expands to left
            else if(map.containsKey(x - 1)){
                Sequence seq_small = map.get(x - 1);
                Sequence newSeq = new Sequence(seq_small.start, x);
                map.put(seq_small.start, newSeq);
                map.put(x, newSeq);
            }
            // x expands to right
            else if(map.containsKey(x + 1)){
                Sequence seq_large = map.get(x + 1);
                Sequence newSeq = new Sequence(x, seq_large.end);
                map.put(seq_large.end, newSeq);
                map.put(x, newSeq);
            }
            // x is isolated 
            else {
                map.put(x, new Sequence(x, x));
            }
        }

        int length = 0;
        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()){
            Sequence seq = map.get(itr.next());
            if((seq.end - seq.start + 1) > length){
                length = seq.end - seq.start + 1;
            }
        }

        return length;
    }
    
    public static void main(String[] args){
    	int[] arr = {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence scs = new LongestConsecutiveSequence();
        System.out.println(scs.longestConsecutive(arr));
    }
}
