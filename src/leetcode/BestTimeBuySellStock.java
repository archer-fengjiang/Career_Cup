package leetcode;


/**
 * I:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 *
 * II:
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * III:
 * You may complete at most two transactions.
 * */
public class BestTimeBuySellStock {
	public int maxProfitI(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		
		int minPrice = Integer.MAX_VALUE;
		int maxDif = -1;
		
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			else if(prices[i] - minPrice > maxDif){
				maxDif = prices[i] - minPrice;
			}
		}
		if(maxDif > 0){
			return maxDif;
		}else{
			return 0;
		}
    }
	
	public int maxProfitII(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		
		int lowPrice = prices[0];
		int highPrice = prices[0];
		int totalProfit = 0;
		
		boolean goingUp;
		if(prices[1] >= prices[0]){
			goingUp = true;
		}else{
			goingUp = false;
		}

		
		for(int i = 1; i < prices.length; i++){
			// going up
			if(prices[i] >= prices[i - 1]){
				//if going down stops: set low price
				if(!goingUp){
					highPrice = prices[i];
					goingUp = true;
				}
				//if going up continues, update high price
				else{
					highPrice = prices[i];
				}
			}
			// going down
			else{
				// if going up stops: commit one transaction and set new lowPrice
				if(goingUp){
					totalProfit += highPrice - lowPrice;
					lowPrice = prices[i];
					goingUp = false;
				}
				// if going down continues, update low price
				else{
					lowPrice = prices[i];
				}
			}
		}
		
		if(goingUp){
			totalProfit += highPrice - lowPrice;
		}
		
		return totalProfit;
    }
	
	
	public int maxProfitIII(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		
		// First pass
		int minPrice = Integer.MAX_VALUE;
		int buyPricePos = -1;
		int sellPricePos = -1;
		int minPricePos = -1;
		int maxDif = -1;
		
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
				minPricePos = i;
			}
			else if(prices[i] - minPrice > maxDif){
				maxDif = prices[i] - minPrice;
				buyPricePos = minPricePos;
				sellPricePos = i;
			}
		}
		int maxProfitFirstPass;
		if(maxDif <= 0){
			return 0;
		}else{
			maxProfitFirstPass = maxDif;
		}
		
		// Find maxDif within first pass
		int maxPrice = Integer.MIN_VALUE;
		maxDif = 1;
		for(int i = buyPricePos; i <= sellPricePos; i++){
			if(prices[i] > maxPrice){
				maxPrice = prices[i];
			}else if(prices[i] - maxPrice < maxDif){
				maxDif = prices[i] - maxPrice;
			}
		}
		int maxDifWithinBuySell = 0 - maxDif;
		
		
		
		//Second pass
		minPrice = Integer.MAX_VALUE;
		maxDif = -1;
		for(int i = 0; i < buyPricePos; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			else if(prices[i] - minPrice > maxDif){
				maxDif = prices[i] - minPrice;
			}
		}
		int maxDifSecondPassHead = maxDif;
		
		minPrice = Integer.MAX_VALUE;
		maxDif = -1;
		for(int i = sellPricePos; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			else if(prices[i] - minPrice > maxDif){
				maxDif = prices[i] - minPrice;
			}
		}
		int maxDifSecondPassTail = maxDif;
		
		
		// Sum up
		int additionAdd = maxDifWithinBuySell;
		if(additionAdd < maxDifSecondPassHead){
			additionAdd = maxDifSecondPassHead;
		}
		if(additionAdd < maxDifSecondPassTail){
			additionAdd = maxDifSecondPassTail;
		}
		if(additionAdd <= 0){
			return maxProfitFirstPass;
		} else {
			return maxProfitFirstPass + additionAdd;
		}
    }
}
