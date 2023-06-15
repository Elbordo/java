/**********************************************
Workshop # 6
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 10.11.2022(dd.mm.yyyy)
**********************************************/ 
package test1;
import java.util.Scanner;
public class W6T2{
    public interface ArrayProcessor {  
    	 double apply( double[] array );  
    	 }; 
	public static final ArrayProcessor max = 
		array->{
			double max = array[0];
			for(int i=0;i<array.length;i++) {
				if(array[i]>max) max = array[i];
			}
			return max;
		};
	public static final ArrayProcessor min = 
		array->{
			double min = array[0];
			for(int i=0;i<array.length;i++) {
				if(array[i]<min) min = array[i];
			}
			return min;
		};
	public static final ArrayProcessor sum = 
		array->{
			double sum = 0;
			for(int i=0;i<array.length;i++) {
				sum += array[i];
			}
			return sum;
		};
	public static final ArrayProcessor avg = 
		array->{
			double sum = 0;
			for(int i=0;i<array.length;i++) {
				sum += array[i];
			}
			return sum/array.length;
		};
	public static ArrayProcessor counter(double value){
		return array->{
			double num = 0;
			for(int i=0;i<array.length;i++) {
				if(array[i]==value) num++;
			}
			return num;
		};
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n = in.nextInt();
		double[] numbers = new double[n];
		System.out.print("Enter the numbers of array: ");
		for(int i=0;i<n;i++) {
			numbers[i] = in.nextDouble();
		}
		System.out.println("Max: " + max.apply(numbers));
		System.out.println("Min: " + min.apply(numbers));
		System.out.println("Sum: " + sum.apply(numbers));
		System.out.println("Average: " + avg.apply(numbers));
		System.out.print("Enter the value to count occurance of a number in an array: ");
		System.out.println(counter(in.nextDouble()).apply(numbers));
	}
}