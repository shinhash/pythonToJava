package day11;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		
		arr.add("���");
		arr.add("��");
		
		arr.add(0, "test");
		
		for(String temp : arr) {
			
			System.out.println(temp);
		}
		
	}
	
}
