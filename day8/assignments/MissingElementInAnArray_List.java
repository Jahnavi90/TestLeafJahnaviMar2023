package day8.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray_List {

	public static void main(String[] args) {
	List <Integer> missele= new ArrayList <Integer>();
					missele.add(1);
					missele.add(2);
					missele.add(3);
					missele.add(4);
					missele.add(7);
					missele.add(6);
					missele.add(8);
					int size = missele.size();
					Collections.sort(missele);			
				for (int i = 0; i < size; i++) {	
					int j = i+1;
					if (missele.get(i)!=j) {
						System.out.println("Missing element is : "+j);
						break;
					}
				}
	}
}
