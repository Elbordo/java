/**********************************************
Workshop # 2
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 04.10.2022(dd.mm.yyyy)
**********************************************/ 
package test1;
import java.util.Scanner;
public class IncomeTax {
	private int fillingStatus;
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	public static final int MARRIED_SEPARATELY = 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	private int[][] intervals;
	private double rates[];
	private double taxableIncome;
	public IncomeTax() {}
	public IncomeTax(int filling, int[][] interval, double[] rate, double taxable) {
		fillingStatus = filling;
		intervals = interval;
		rates = rate;
		taxableIncome = taxable;
	}
	public int getFillingStatus() {
		return fillingStatus;
	}
	public void setFillingStatus(int filling) {
		fillingStatus = filling;
	}
	public int[][] getIntervals() {
		return intervals;
	}
	public void setIntervals(int[][] interval) {
		intervals = interval;
	}
	public double[] getRates() {
		return rates;
	}
	public void setRates(double[] rate) {
		rates = rate;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxable) {
		taxableIncome = taxable;
	}
	public double getIncomeTax() {
		double tax = 0;
		for(int i = 0; i < intervals.length; i++) {			
			if(i == 0 && intervals[i][fillingStatus] <= taxableIncome) tax = intervals[i][fillingStatus] * rates[i]/100;
			else if(i == 0) return taxableIncome * rates[i]/100;			
			else if(intervals[i][fillingStatus] <= taxableIncome) tax += (intervals[i][fillingStatus] - intervals[i-1][fillingStatus]) * rates[i]/100;			
			else {
				tax += (taxableIncome - intervals[i-1][fillingStatus]) * rates[i]/100;
				return tax;
			}			
		}
		return tax;
	}
	 private static final int[][] y2001 = new int[][] {
		 {27050, 45200, 22600, 36250},
		 {65550, 109250, 54625, 93650},
		 {136750, 166500, 83250, 151650},
		 {297350, 297350, 148675, 297350},
		 {297351, 297351, 148676, 297351}
	 };
	 private static final int[][] y2009 = new int[][] {
		 {8350, 16700, 8350, 11950},
		 {33950, 67900, 33950, 45500},
		 {82250, 137050, 68525, 117450},
		 {171550, 208850, 104425, 190200},
		 {372950, 372950, 186475, 372950},
		 {372951, 186476, 372951, 372951}
	 };	 
	 private static double []r2001 = {15, 27.5, 30.5, 35.5, 39.1};
	 private static double []r2009 = {10, 15, 25, 28, 33, 35};	 
	public static void main(String[] args) {				
		Scanner in = new Scanner(System.in);	
		boolean flag = false;	
		while(!flag) {		
			System.out.print("1. Compute personal income Tax \n");
			System.out.print("2. Print the tax tables for taxable incomes (with range) \n");
			System.out.print("3. Exit ");		
			int k = in.nextInt();		
			if(k == 1) {				
				System.out.print("\n0 - single filer \n");
				System.out.print("1 - married filing jointly or qualifying widow(er) \n");
				System.out.print("2 - married filing separately \n");
				System.out.print("3 - head of household.");				
				System.out.print("\nEnter a filling status: ");
				int fillingStatus = in.nextInt();				
				System.out.print("\nEnter the taxable income: $");
				double taxableIncome = in.nextDouble();				
				IncomeTax iT = new IncomeTax(fillingStatus, y2009, r2009, taxableIncome);				
				System.out.printf("\nTax is: $%.2f\n", iT.getIncomeTax());			
			}
			else if(k == 2) {			
				System.out.print("\nEnter amount from : $");
				int from = in.nextInt();				
				System.out.print("\nEnter amount To : $");
				int to = in.nextInt();				
				System.out.println("\n2001 tax tables for taxable income from $"+from +" to $"+to);				
				IncomeTax iT = new IncomeTax();
				iT.setIntervals(y2001);
				iT.setRates(r2001);				
				display(iT, from, to);				
				System.out.println("\n2009 tax tables for taxable income from $"+from +" to $"+to);				
				iT = new IncomeTax();
				iT.setIntervals(y2009);
				iT.setRates(r2009);				
				display(iT, from, to);								
			}
			else if(k == 3) {
				flag = true;
			}
			else {
				System.out.println("Invalid choice! Try again.");
			}
		}		
		in.close();

	}
	public static void display(IncomeTax iT, int from, int to){		
		System.out.println("\n-----------------------------------------------------\n");
		System.out.println  ("Taxable   Single    Married Joint  Married   Head of   \n");
		System.out.println  ("Income              or Qualifying  Separate  a House\n");
		System.out.println  ("                    Widow(er) \n");
		System.out.println("-----------------------------------------------------\n");
		for(int i = from; i <= to; i+=1000) {			
			System.out.printf("%-10d", i);			
			for(int j = 0; j < 4; j++) {				
				iT.setFillingStatus(j);
				iT.setTaxableIncome(i);				
				System.out.printf("%-12.2f", iT.getIncomeTax());				
			}			
			System.out.print("\n");
		}		
	}
}