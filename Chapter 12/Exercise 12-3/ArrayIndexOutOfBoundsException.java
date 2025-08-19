/*
Author: Sean Briggs
Date Created: 8/19/25

This program uses the "IndexOutOfBoundsException"
*/

import java.util.*;

public class ArrayIndexOutOfBoundsException {
	public static void main(String[] args) {
		final int SIZE = 100;
		
		int[] testArray = new int[SIZE];
		Random random = new Random();
		for (int i = 0; i < SIZE; i++) {
			testArray[i] = random.nextInt();
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an array index from 0-99: ");
		int index = input.nextInt();
		try {
			System.out.println("Element at index " + index + ": " + testArray[index]);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Between 0 and 99 please!");
			main(new String[0]);
		}
	}
}