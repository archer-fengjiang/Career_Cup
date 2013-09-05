/*9.1*/
package c9_sorting_searching;

import java.util.Arrays;

public class merageAB {
	public static void mergeAB(int[] a, int m, int[] b, int n){
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while(i >= 0 && j >= 0){
			if(a[i] > b[j])
				a[k--] = a[i--];
			else
				a[k--] = b[j--];
		}
		while(i >= 0)
			a[k--] = a[i--];
		while(j >= 0)
			a[k--] = b[j--];
	}
	public static void main(String[] args){
		int[] a = new int[100];
		int[] b = new int[30];
		for(int i = 0; i < 50; i++)
			a[i] = 2*i;
		for(int i = 0; i < 30; i++)
			b[i] = i;
		mergeAB(a, 50, b, 30);
		System.out.println(Arrays.toString(a));
	}
}
