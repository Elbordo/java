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

public class ReverseThread extends Thread {
	private int num;	
	static final int FIRST_THREAD = 1;
	static final int LAST_THREADS = 50;
    public ReverseThread(int numr) {
    	this.num = numr;
    }
    private void thread(int numr) throws InterruptedException{
    	ReverseThread thread = new ReverseThread(num);
    	thread.start();
    	thread.join();
    	System.out.println(String.format("Hello from Thread " + numr));
    }
    public void run() {	   	
    	try{
    		if(num <= LAST_THREADS) thread(num++);   			
    	}catch(Exception ex){
    		System.out.println(ex.toString());
    	}    	
    }
    public static void main(String[] args) throws InterruptedException {	
    	ReverseThread thread1 = new ReverseThread(FIRST_THREAD);
    	thread1.start();
	}	
}