package com.revature.main;

import java.util.Scanner;

public class WordGame2 {

	private static Scanner sc = new Scanner(System.in); 

	public static String answer = chooseWord();

	public static boolean isCorrectAnswer = false;
	
	public static boolean quit = false;
	
	public static void main(String[] args) {
		
		// check to see if the correct answer was guessed
		// or if the player quit
		
		while (isCorrectAnswer == false && quit == false) {
			System.out.println("Guess a word.");
			String guess = sc.nextLine();
			System.out.println("Your guess is " + guess.equals(answer));
			
			if (guess.equals(answer)) {
				quit = true;
				System.out.println("You win!");
			} else if (guess.equals("quit")) {
				quit = true;
				System.out.println("You quit!");
			}
		}
	}
	
// 	public static String askForWord() {
// 
//		System.out.println("Guess a word.");
//		Scanner scanner = new Scanner(System.in);
//		String guess = scanner.nextLine();
//		return guess;
//	}
	
	public static String chooseWord() {
		String[] words = {"arise", "faith", "table", "array"};
		String word;
		int randomInt = (int) (Math.random() * words.length);
		word = words[randomInt];
		return word;
	}
	
	
}
