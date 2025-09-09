/*
 * Author: Sean Briggs
 * Date Created: 9/9/25
 * 
 * Description: This program writes 100 integers to a file
 */

import java.io.*;
import java.util.Random;

public class WriteIntegers {
    public static void main(String[] args) throws IOException {
        try (PrintWriter output = new PrintWriter(new BufferedOutputStream(
            new FileOutputStream("Exercise17_01.txt", true)))) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                output.write(random.nextInt() + (i < 99 ? " " : ""));
            }
        }
    }
}
