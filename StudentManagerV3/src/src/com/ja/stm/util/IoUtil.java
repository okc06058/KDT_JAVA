package com.ja.stm.util;

import java.util.Scanner;

public class IoUtil {
	private static Scanner scanner = new Scanner(System.in);

	public static void println(String value) {
		System.out.println(value);
	}
	
	public static String input(String text) {
		System.out.println(text);
		String input = scanner.nextLine();
		return input;
	}
	
	public static void pause() {
		System.out.println("계속하시려면 ENTER");
	}

}
