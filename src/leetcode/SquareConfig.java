package leetcode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


/*
 * 	/wallet/dashboard 172.90.80.1:5600
 *	/wallet/download 172.30.10.1:8000
 *	/* 124.86.78.4
 */
public class SquareConfig {
	
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    	Map<String, String> basicMap = new HashMap<String, String>();
	    	Map<String, String> wildCardMap = new HashMap<String, String>();
	        Scanner stdin = new Scanner(System.in);
	        while(stdin.hasNextLine()){
	        	String line = stdin.nextLine();
	        	String[] tokens = line.split(" ");
	        	String url = tokens[0];
	        	String endPoint = tokens[1];
	        	//Basic
	        	if(url.endsWith("*")){
	        		wildCardMap.put(url, endPoint);
	        	}
	        	//WldCard
	        	else{
	        		//check conflict from basicMap
	        		if(basicMap.containsKey(url) && !basicMap.get(url).equals(endPoint)){
	        			System.out.println("Error: invalid configuration.");
	        			return;
	        		}
	        		//check conflict from wildCardMap
	        		Iterator<String> itr = wildCardMap.keySet().iterator();
	        		while(itr.hasNext()){
	        			String wildCardUrl = itr.next();
	        			String wildCardEndPoint = wildCardMap.get(wildCardUrl);
	        			String wildCardUrlNoStart = wildCardUrl.split("//*")[0];
	        			if(url.startsWith(wildCardUrlNoStart) && !endPoint.equals(wildCardEndPoint)){
	        				System.out.println("Error: invalid configuration.");
	        				return;
	        			}
	        		}
	        		basicMap.put(url, endPoint);
	        	}
	        }
	        System.out.println("Valid configuration.");
	    }
}
