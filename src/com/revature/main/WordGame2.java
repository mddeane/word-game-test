package com.revature.main;

import java.util.Scanner;
import java.util.ArrayList;

public class WordGame2 {

	private static Scanner sc = new Scanner(System.in);
	
	public static int maxLetters = 5; 

	public static String answer = chooseWord();
	public static char[] answerCharArray = answer.toCharArray();

	public static boolean isCorrectAnswer = false;	//tracks if guess is correct

	public static boolean quit = false;	//tracks whether player quit

	public static int rounds = 0; 	//holds the number of times the player guesses
									//does not include when too few/many letters in guess
	
	public static ArrayList<String> guesses = new ArrayList<String>();	//list of guesses
	
	public static ArrayList<String> guessResults = new ArrayList<String>(); //list of guess results

	// public static char[] guessArray = new char[5];

	public static void main(String[] args) {

		// check to see if the correct answer was guessed
		// or if the player quit

		while (isCorrectAnswer == false && quit == false) {
			System.out.println("Guess a word with " + maxLetters + " letters" + (rounds == 0 ? "." : " again.") + " (Or type \"quit\")");
			String guess = sc.nextLine();

			if (guess.length() == maxLetters) { 	//check is letter count is maxLetters
				if (guess.equals(answer)) {	//if guess is correct
					quit = true;
					System.out.println("That's right!");
					System.out.println("You win!");
				} else {
	
					analyzeGuess(guess);
	
					System.out.println("You guessed " + guess);
					System.out.println("It is not correct.");
					rounds++;
			   	}
			}  else if (guess.equals("quit")) {
				quit = true;
				onQuit();
			} else {
				System.out.println("Guess needs to have " + maxLetters + " letters.");
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
		String[] words = { "arise", "faith", "table", "array" };
		String word;
		int randomInt = (int) (Math.random() * words.length);
		word = words[randomInt];
		return word;
	}

	public static void analyzeGuess(String guess) {
		char[] guessCharArray = guess.toCharArray();
		char[] analyzeCharArray = new char[maxLetters];
		
		for(int i=0; i<maxLetters; i++) {
			if (guessCharArray[i]==answerCharArray[i]) {
				analyzeCharArray[i] = answerCharArray[i];
			} else {
				analyzeCharArray[i] = '-';
			}
		}
		
		System.out.println(new String(analyzeCharArray));
		
//		for (char c : analyzeCharArray) {
//			System.out.println(c);
//		}
//
//		guesses.add(guess);
//
//		for (String str : guesses) {
//			System.out.println(str);
//		}

	}

	public static void yourGuesses() {
		System.out.println("Your guesses:");
		for (String element : guesses) {
			System.out.println("\t" + element);
		}
	}

	public static void onQuit() {
		System.out.println("You quit after " + rounds + (rounds == 1 ? " guess." : " guesses."));
		yourGuesses();
	}

}
