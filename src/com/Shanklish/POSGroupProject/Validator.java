package com.Shanklish.POSGroupProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc) {

		String s = sc.next().toLowerCase(); // read user entry

		return s;
	}

	public static String getString2(Scanner sc, ArrayList<String> productList) {

		String s = sc.next().toLowerCase();

		while (!productList.contains(s)) {

			System.out.println("We don't carry that. Please pick another product.");
			s = sc.next().toLowerCase();

		}
		return s;
	}

	public static String getString3(Scanner sc) {

		String s = sc.next().toLowerCase();

		while (!s.contains("y") || !s.contains("n") ) {

			System.out.println("Please try again.");
			s = sc.next().toLowerCase();

		}
		return s;

	}

	public static int getInt(Scanner sc) {
		int i = 0;

		while (!sc.hasNextInt()) {

			System.out.println("Error! Invalid integer value. Try again.");
			sc.nextLine();
		}

		i = sc.nextInt();

		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt, min, max);
			if (i <= min)
				System.out.println("Error! Number must be greater than " + min + ".");
			else if (i >= max)
				System.out.println("Error! Number must be less than " + max + ".");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d <= min)
				System.out.println("Error! Number must be greater than " + min + ".");
			else if (d >= max)
				System.out.println("Error! Number must be less than " + max + ".");
			else
				isValid = true;
		}
		return d;
	}
}