/**********************************************
Workshop # 8
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 24.11.2022(dd.mm.yyyy)
**********************************************/ 
package test1;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class W8T1 {

	public static void main(String[] args) {
		int size = 2000;
		double[][] a = new double[size][size];
		double[][] b = new double[size][size];
		double[][] c = new double[size][size];
		double[][] d = new double[size][size];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				a[i][j] = Math.random();
				b[i][j] = Math.random();
				c[i][j] = Math.random();
				d[i][j] = Math.random();
			}
		}
		long time = System.currentTimeMillis();
		parallelAddMatrix(a, b);
		System.out.println((System.currentTimeMillis() - time)	+ " milliseconds for parallelAddMatrix");
		time = System.currentTimeMillis();
		sequentialAddMatrix(c, d);
		System.out.println((System.currentTimeMillis() - time) + " milliseconds for sequentialAddMatrix");
	}

	public static double[][] parallelAddMatrix(double[][] a, double[][] b) {
		double[][] e = new double[a.length][a.length];
		double[][] g = new double[b.length][b.length];
		RecursiveAction action = new  sequentialAddMatrix(e, g);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(action);
		return e;
	}
	
	private static class  sequentialAddMatrix extends RecursiveAction {	
		private final static int MAX = 100;
		private double[][] a;
		private double[][] b;
		private double[][] c;
		private double[][] d;
		private int x1;
		private int x2;
		private int y1;		
		private int y2;
		public  sequentialAddMatrix(double[][] c,double[][] d) {
			this.c = c;
			this.d = d;			
		}
		protected void compute() {
			if (((x2 - x1) < MAX) || ((y2 - y1) < MAX)) {
				for (int i = x1; i < x2; i++) {
					for (int j = y1; j < y2; j++) {
						c[i][j] = a[i][j] + b[i][j]; 
						d[i][j] = a[i][j] + b[i][j]; 
					}
				}
			} else {
				invokeAll(
						new sequentialAddMatrix(c, d),
						new sequentialAddMatrix(c, d),
						new sequentialAddMatrix(c, d),
						new sequentialAddMatrix(c, d));
			}
		}
	}
	
	public static double[][] sequentialAddMatrix(double[][] c, double[][] d) {
		double[][] res = new double[c.length][c[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				res[i][j] = c[i][j] + d[i][j]; 
			}
		}
		return res;
	}
}