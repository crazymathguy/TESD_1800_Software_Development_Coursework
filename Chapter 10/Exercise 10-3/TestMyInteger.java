/*
Author: Sean Briggs
Date: 8/14

This program contains a wrapper class for integers
*/

public class TestMyInteger {
	public static void main(String[] args) {
		String number = "1538";
		MyInteger myNumber = new MyInteger(MyInteger.parseInt(number));
		System.out.println("myNumber: " + myNumber.getValue());
		System.out.println("Is myNumber even? " + myNumber.isEven());
		System.out.println("Is myNumber odd? " + myNumber.isOdd());
		System.out.println("Is myNumber prime? " + myNumber.isPrime());
		System.out.println("Is 15 even? " + MyInteger.isEven(15));
		System.out.println("Is 17 odd? " + MyInteger.isOdd(17));
		System.out.println("Is 19 prime? " + MyInteger.isPrime(19));
		System.out.println("Is MyInteger 8 even? " + MyInteger.isEven(new MyInteger(8)));
		System.out.println("Is MyInteger 20 odd? " + MyInteger.isOdd(new MyInteger(20)));
		System.out.println("Is MyInteger 6 prime? " + MyInteger.isPrime(new MyInteger(6)));
		System.out.println("Is myNumber equal to MyInteger 576? " + myNumber.isEqual(new MyInteger(576)));
		System.out.println("Is myNumber equal to 1538? " + myNumber.isEqual(1538));
	}
}

class MyInteger {
	int value;
	
	MyInteger(int value) {
		this.value = value;
	}
	
	int getValue() {
		return value;
	}
	
	static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	static boolean isOdd(int value) {
		return value % 2 == 1;
	}
	
	static boolean isPrime(int value) {
		for (int i = 2; i <= Math.sqrt(value); i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	boolean isEven() {
		return isEven(value);
	}
	
	boolean isOdd() {
		return isOdd(value);
	}
	
	boolean isPrime() {
		return isPrime(value);
	}
	
	static boolean isEven(MyInteger value) {
		return value.isEven();
	}
	
	static boolean isOdd(MyInteger value) {
		return value.isOdd();
	}
	
	static boolean isPrime(MyInteger value) {
		return value.isPrime();
	}
	
	boolean isEqual(int value) {
		return this.value == value;
	}
	
	boolean isEqual(MyInteger value) {
		return this.value == value.value;
	}
	
	static int parseInt(char[] charArray) {
		int returnValue = 0;
		for (char charI : charArray) {
			returnValue *= 10;
			returnValue += charI - '0';
		}
		return returnValue;
	}
	
	static int parseInt(String string) {
		return parseInt(string.toCharArray());
	}
}