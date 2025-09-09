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
        writeToFile();
        System.out.println(readFromFile());
    }

    public static void writeToFile() throws IOException {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream("Exercise17_03.dat", true)))) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                output.writeInt(random.nextInt());
            }
        }
    }

    public static long readFromFile() throws IOException {
        long number = 0;
        int numberOfInts = 0;
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(
            new FileInputStream("Exercise17_03.dat")))) {
            while (true) {
                number += input.readInt();
                numberOfInts++;
            }
        }
        catch (EOFException ex) {}
        System.out.println(numberOfInts);
        return number;
    }
}
