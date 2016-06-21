package com.Shanklish.POSGroupProject;

import java.util.Scanner;

public class Validator {
	
	
	public static boolean getYesNo(Scanner sc, String prompt) {

		System.out.println(prompt);

		String S = sc.nextLine();
		boolean b = false;
		while (!S.trim().substring(0, 1).toLowerCase().equalsIgnoreCase("y")
				&& !S.trim().substring(0, 1).toLowerCase().equalsIgnoreCase("n")) {
			System.out.println("Incorrect format. Yes or No?");
			S = sc.nextLine();
		}
		if (S.trim().substring(0, 1).equalsIgnoreCase("y")) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

}
