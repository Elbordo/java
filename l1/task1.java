/**********************************************
Workshop # 1
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 27.09.2022(dd.mm.yyyy)
**********************************************/ 
package test1;
import java.util.Scanner;
import java.text.DecimalFormat;

class MaxLocation{
    int Row;
    int Column;
    double maxValue;
    MaxLocation(int row, int col, double max){
        Row = row;
        Column = col;
        maxValue = max;
    }
}

public class task1{
    public static MaxLocation largestMethod(double[][] array){
        double max = array[0][0];
        MaxLocation m = new MaxLocation(0, 0, array[0][0]);
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] > max){
                    m = new MaxLocation(i, j, array[i][j]);
                    max = array[i][j];
                }
            }
        }       
        return m;
    }
    
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);	    
	    int row, col;	    
		System.out.print("Enter the number of rows and columns in the array: ");
		row = in.nextInt();
		col = in.nextInt();
		double[][] array = new double[row][col];		
		System.out.println("\nEnter the array:");
		for(int i = 0; i < row; i++){
		    for(int j = 0; j < col; j++){
		        array[i][j] = in.nextDouble();
		    }
		}
		MaxLocation m = largestMethod(array);
		System.out.println("The location of the largest element is " + m.maxValue + " at (" + m.Row + ", " + m.Column + ")");
	}
}
