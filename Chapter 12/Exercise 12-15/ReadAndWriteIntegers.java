/*
Author: Sean Briggs
Date Created: 8/19/25

This program creates a file with 100 random integers and then displays them in increasing order
*/

import java.io.*;
import java.util.*;

public class ReadAndWriteIntegers {
	public static void main(String[] args) throws IOException {
		File file = new File("Exercise12_15.txt");
		if (!file.exists()) {
			Random random = new Random();
			PrintWriter ouptut = new PrintWriter(file);
			
			for (int i = 0; i < 100; i++) {
				ouptut.print(random.nextInt());
				ouptut.print(" ");
			}
			ouptut.close();
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			list.add(input.nextInt());
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}