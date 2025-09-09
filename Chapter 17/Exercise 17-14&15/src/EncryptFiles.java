/*
 * Author: Sean Briggs
 * Date Created: 9/9/25
 * 
 * Description: Encrypts and decrypts files
 */

import java.io.*;
import java.util.Scanner;

public class EncryptFiles {
    public static void main(String[] args) throws Exception {
        File[] files = chooseFiles("Enter the name of a file to encrypt (.dat): ", "Enter the name of the new encrypted file (with .dat): ");
        encrypt(files[0], files[1]);
        System.out.println(files[0] + " encrypted");
        File[] files2 = chooseFiles("Enter the name of a file to decrypt (.dat): ", "Enter the name of the new decrypted file (with .dat): ");
        decrypt(files2[0], files2[1]);
        System.out.println(files2[0] + " decrypted");
    }

    public static File[] chooseFiles(String message1, String message2) {
        Scanner input = new Scanner(System.in);

        File inputFile = new File("");
        while (!inputFile.exists()) {
            String fileName = "";
            while (!fileName.contains(".dat")) {
                System.out.print(message1);
                fileName = input.next();
            }
            inputFile = new File(fileName);
        }
        String fileName = "";
        while (!fileName.contains(".dat")) {
            System.out.print(message2);
            fileName = input.next();
        }
        File outputFile = new File(fileName);
        input.close();

        return new File[] {inputFile, outputFile};
    }

    public static void encrypt(File inputFile, File encryptedFile) {
        try (
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(encryptedFile));
        ) {
            int r;
            while ((r = input.read()) != -1) {
                output.write(r + 5);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void decrypt(File inputFile, File encryptedFile) {
        try (
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(encryptedFile));
        ) {
            int r;
            while ((r = input.read()) != -1) {
                output.write(r - 5);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
