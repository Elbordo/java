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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W4t2{
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter file name: ");
        File f = new File(new Scanner(System.in).next());
        if (!f.exists()) {
            System.out.println(f + " doesn't exist");
            System.exit(1);
        }
        String line = "";
        int[] number = new int[58];
        try (Scanner in = new Scanner(f)) {
            while (in.hasNext()) {
            	line = in.nextLine();
                for (char ch : line.toCharArray()) {
                    if (isLetter(ch))  number[ch - 'A']++;                    
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 26; i++) {
            System.out.println("Number of " + (char)(i + 'A') + "'s: " + number[i]);
            System.out.println("Number of " + (char)(i + 'A'+32) + "'s: " + number[i+32]);
        }
    }
    private static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z');
    }


}