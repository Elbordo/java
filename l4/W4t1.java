/**********************************************
Workshop # 4
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 18.10.2022(dd.mm.yyyy)
**********************************************/ 
package test1;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class W4t1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		String promt; 
		do {
			int wrong = 0; 
			char[] word = randomWord();
			char[] aster = new char[word.length];
			hideWord(aster);		
			while (!roundEnd(aster)) {	
				Scanner inn = new Scanner(System.in);
				System.out.print("(Guess) Enter a letter in word ");
				System.out.print(aster);
				System.out.print(" > ");
				String line = inn.next();
				char letter = line.charAt(0);
				if (!checkLetter(word, aster, letter)) wrong++;				
			} 
			display(word, wrong);
			System.out.println("Do you want to guess another word? Enter y or n>");
			promt = in.next();
		} while (promt.charAt(0) == 'y');
	}
	public static char[] randomWord() throws FileNotFoundException {
		File f = new File("hangman.txt");
		if (!f.exists()) {
            System.out.println(f + " doesn't exist");
            System.exit(1);
        }
		ArrayList<String> word = new ArrayList<>();
		try (
			Scanner in = new Scanner(f);
		) {
			while (in.hasNext()) word.add(in.next());
		}
		String pick = word.get((int)(Math.random() * word.size()));
		char[] random = pick.toCharArray();
		return random;
	}
	public static void hideWord(char[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = '*';
		}
	}
	public static boolean roundEnd(char[] aster) {
		for (int i=0; i<aster.length;i++) {
			if (aster[i] == '*') return false;
		}
		return true;
	}
	public static boolean checkLetter(char[] word, char[] blanks, char letter) {
		boolean flag = false;
		int check=2;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == letter) {
				flag = true;
				if (blanks[i] == letter) check = 1;
				else { 
					blanks[i] = letter;
					check = 0;
				}
			}
		}
		if (check > 0) displayW(check, letter);
		return flag;
	}
	public static void display(char[] word, int wrong) {
		System.out.print("The word is ");
		System.out.print(word);
		System.out.println(" You missed " + wrong + " times");
	}
	public static void displayW(int check, char letter) {
		System.out.print("\t" + letter);
		if(check == 1) System.out.println(" is already in the word");	
		else System.out.println(" is not in the word");
	}	
}