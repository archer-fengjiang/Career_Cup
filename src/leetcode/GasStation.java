package leetcode;
/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		if(gas == null || cost == null || gas.length != cost.length){
			return -1;
		}
		int len = gas.length;
		int gasSum = 0;
		int costSum = 0;
		for(int i = 0; i < len; i++){
			gasSum += gas[i];
			costSum += cost[i];
		}
		if(gasSum < costSum){
			return -1;
		}
		int extraGas = 0;
		int head = 0;
		int tail = 0;
		while(true){
			while(extraGas >= 0){
				extraGas += gas[head] - cost[head];
				head = nextIndex(len, head);
				if(head == tail){
					return tail;
				}
			}
			while(extraGas < 0){
				extraGas -= gas[tail] - cost[tail];
				tail  = nextIndex(len, tail);
			}
		}
	}
	
	private int nextIndex(int len, int index){
		return (index + 1) % len;
	}
	
	
	public static void main(String[] args){
		GasStation gs = new GasStation();
		int[] gas = {6,0,1,3,2};
		int[] cost = {4,5,2,5,5};
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}
}
