package com.revature.main;

import java.util.Scanner;

public class WordGame {
	public static void main(String[] args) {
		//System.out.println(chooseWord());
		
		String theWord = chooseWord();
		boolean isRight=false;
		
		//char[] letters = new char[theWord.length()];

		Scanner scanner = new Scanner(System.in);
		
		while(isRight!=true) {
			System.out.println("Type a guess and press Enter.");
			String guess = scanner.nextLine();
			isRight = checkWord(guess, theWord);
		}
		//System.out.println(isCorrect(guess, theWord));
		
		//if (isCorrect(guess, theWord)) {
		//	System.out.println("You are correct!"); 
		//} else {
		//	System.out.println("You are wrong!"); 
		//}
		
		
	}

	public static String chooseWord() {
		String[] words = {"arise", "faith", "table", "array"};
		String word;
		int randomInt = (int) (Math.random() * words.length);
		word = words[randomInt];
		return word;
	}
	
	public static boolean isCorrect(String input, String target) {
		System.out.println("You guessed: " + input);
		System.out.println("The answer is: " + target);
		boolean correct = false;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i)!=target.charAt(i)) {
				//System.out.println(i);
				break;
			} else {
			correct = true;
			}
		}
		return correct;
	}
	
	public static boolean checkWord(String input, String target) {
		String result="";
		boolean resultCorrect = false;
		
		if (input.equals(target)) {
			resultCorrect = true;
			System.out.println("You are correct!");
		} else {
			for (int i = 0; i< target.length(); i++) {
				if (input.charAt(i)==target.charAt(i)) {
					result+=input.charAt(i);
				} else {
					result+=" _";
				}
			}
			System.out.println(result);
		}
		
		return resultCorrect;
	}
}

