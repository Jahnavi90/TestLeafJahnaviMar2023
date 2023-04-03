package day3.assignments;

import java.util.Arrays;
import java.util.Iterator;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		int length = arr.length;
		Arrays.sort(arr);		
			for (int i = 0; i < arr.length; i++) {	
				int j = i+1;
				if (arr[i]!=j) {
					System.out.println("Missing element is :"+j);
					break;
				}
			}
		}
	}