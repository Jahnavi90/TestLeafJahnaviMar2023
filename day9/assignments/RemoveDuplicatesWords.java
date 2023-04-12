package day9.assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String space = "";
		String[] split = text.split(" ");
		Set <String> str1 = new LinkedHashSet <String>();
		for (String i : split) {
			str1.add(i);
		}
	List <String> list = new ArrayList<String>(str1);
		for (String ch2 : list) {
		space = space+" "+ch2;
		}
		System.out.println(space);
	}
}
