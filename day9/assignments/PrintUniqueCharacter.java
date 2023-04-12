package day9.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String str = "babu";
		String space = "";
		char[] ch1 = str.toCharArray();
		Set <Character> set1 = new HashSet <Character>();
		for (Character j : ch1) {
			boolean add = set1.add(j);
			if(!add) {
				set1.remove(j);
				}
			}
		List <Character> list = new ArrayList<Character>(set1);
		//for (int i = 0; i < list.size() ; i++) {
		for (Character ch2 : list) {
			space = space+" "+ch2;
		}
		System.out.println(space);
		}
	
	}
