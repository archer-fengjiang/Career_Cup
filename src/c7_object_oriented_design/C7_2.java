package c7_object_oriented_design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Fengjiang.
 *         Created Aug 12, 2012.
 */
public class C7_2 {
	
	public class CallHandler{
		static final int LEVELS = 3;
		static final int NUM_FRESHER = 5;
		ArrayList<Employee>[] employeeLevels =
				new ArrayList[LEVELS];
		Queue<Call>[] callQueues = new LinkedList[LEVELS];
		
		/**
		 * handle the call or add it to queue
		 * */
		public void dispatchCall(Call call){
			Employee emp = this.getCallHandler(call);
			if(emp != null){
				emp.ReceiveCall(call);
			} else {
				callQueues[call.rank].add(call);
			}
		}
		
		private Employee getCallHandler(Call call){
			for(int level = call.rank ; level < LEVELS - 1; level++){
				ArrayList<Employee> employeeLevel = employeeLevels[level];
				for(Employee ee : employeeLevel){
					if(ee.free){
						return ee;
					}
				}
			}
			return null;
		}
		
		/**
		 * Take another call from call queue
		 * */
		public void getNextCall(Employee ee){}
	}
	
	public class Employee {
		public boolean free;
		int rank;
		public CallHandler callHandler;
		public Employee(int rank){
			this.rank = rank;
		}
		public void ReceiveCall(Call call){}
		public void CallHandled(Call call){}
		public void CallNotHandled(Call call){
			call.rank = rank + 1;
			callHandler.dispatchCall(call);
			free = true;
			callHandler.getNextCall(this);
		}
	}

	public class Call{
		public int rank;
		public void reply(String message){}
		public void disconnect(){}
	}
	
	public class Fresher extends Employee{
		public Fresher(){
			super(0);
		}
	}
	
	public class TechLead extends Employee{
		public TechLead(){
			super(1);
		}
	}
	
	public class ProductManager extends Employee{
		public ProductManager(){
			super(2);
		}
	}
}