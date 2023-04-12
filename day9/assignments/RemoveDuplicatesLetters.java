package day9.assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesLetters {

	public static void main(String[] args) {
		String str = "PayPal India";
		String space1 = "";
		String space2 = "";
		char[] ch1 = str.toCharArray();
		Set <Character> charSet = new LinkedHashSet <Character>();
		Set <Character> dupCharSet = new LinkedHashSet <Character>();
		for (Character i : ch1) {
			boolean add = charSet.add(i);
				if(!add) {
					dupCharSet.add(i);
				}
		}
		List <Character> list1 = new ArrayList<Character>(charSet);
		for (Character ch2 : list1) {
			space1 = space1+ch2;
		}
		List <Character> list2 = new ArrayList<Character>(dupCharSet);
		for (Character ch3 : list2) {
			space2 = space2+ch3;
		}
		System.out.println(space1);
		System.out.println(space2);
	}
}
