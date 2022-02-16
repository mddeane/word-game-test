package com.revature.main;

import java.util.Scanner;
import java.util.ArrayList;

public class WordGame2 {

	private static Scanner sc = new Scanner(System.in); 

	public static String answer = chooseWord();
	public static char[] answerCharArray = answer.toCharArray();
	
	public static boolean isCorrectAnswer = false;
	
	public static boolean quit = false;
	
	public static int rounds = 0; 
	
	public static ArrayList<String> guesses = new ArrayList<String>();
	
	//public static char[] guessArray = new char[5];
	
	public static void main(String[] args) {
		
		// check to see if the correct answer was guessed
		// or if the player quit
		
		while (isCorrectAnswer == false && quit == false) {
			System.out.println("Guess " + (rounds == 0 ? "a word." : "again. ") + "(Or type \"quit\")");
			String guess = sc.nextLine();
			
			if (guess.equals(answer)) {
				quit = true;
				System.out.println("That's right!");
				System.out.println("You win!");
			} else if (guess.equals("quit")) {
				quit = true;
				System.out.println("You quit after " + rounds + (rounds==1 ? " guess." : " guesses."));			;
			} else {
				
				analyzeGuess(guess);
				
				System.out.println("You guessed " + guess);
				System.out.println("It is not correct.");
				rounds++;
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
	
	public static void analyzeGuess(String guess) {
		char[] guessCharArray = guess.toCharArray();
		for (char c : guessCharArray) {
		System.out.println(c);
		}

		guesses.add(guess);
		
		for(String str : guesses) {
			System.out.println(str);
		}
		
	}
	
	
}
