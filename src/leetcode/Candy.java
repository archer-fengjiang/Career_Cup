package leetcode;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * */
public class Candy {
	public int candy(int[] ratings) {
		// if going up, process one by one
		// if going even, process one by one
		// if going down, back trace to origin one
		if(ratings.length < 2){
			return 1;
		}
		int len = ratings.length;
		boolean isDown = false;
		int[] candies = new int[len];
		int pos, score;
		for(score = 1, pos = 0; pos < len; pos++){
			if(pos - 1 >= 0 && ratings[pos] > ratings[pos - 1]){
				candies[pos] = ++score;
			}else{
				score = 1;
			}
		}
		
		for(score = 1, pos = len - 1; pos >= 0; pos--){
			if(pos + 1 < len && ratings[pos] > ratings[pos + 1]){
				candies[pos] = Math.max(candies[pos], ++score);
			}else{
				score = 1;
			}
		}
		int sum = 0;
		for(int i = 0; i < len; i++){
			if(candies[i] == 0){
				sum += 1;
			}else{
				sum += candies[i];
			}
		}
		
		return sum;
	}
}
