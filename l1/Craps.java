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
import java.util.Random;

public class Craps {
	 public static void main(String[] args) 
	       {
	        Random r1 = new Random();
	        int min = 1, max = 6;
	        int dice1 = r1.nextInt(max-min)+min;
	        int dice2 = r1.nextInt(max-min)+min;
	        int sum = dice1+dice2;
	        System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
	        if(sum==2||sum==3||sum==12){
	            System.out.println("Craps ,Better Luck Next Time..!! You lose");
	        }
	        if(sum==7||sum==11){
	            System.out.println("Congratulation..!! You win the Game");
	        }
	        if(sum>=4&&sum<=10&&sum!=7){
	            System.out.println("Point is (established) set to "+sum);
	            int win = sum;	          
	            while(true){
	            	dice1 = r1.nextInt(max-min)+min;
	            	dice2 = r1.nextInt(max-min)+min;
	                sum = dice1+dice2;
	                System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
	                if(sum==win){
	                    System.out.println("Congratulation..!! You Win");
	                    break;
	                }
	                if(sum==7){
	                    System.out.println("Craps, Better luck Next Time, You Lose");
	                    break;
	                }
	            }
	        }	        
	      }
}
