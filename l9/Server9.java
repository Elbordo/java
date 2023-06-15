/**********************************************
Workshop # 9
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 12.01.2022(dd.mm.yyyy)
**********************************************/ 
package test1;

import java.net.*;
import java.io.*;

public class Server9 {
   public static void main(String[] args) throws IOException {
       ServerSocket server = null;
       try {
           server = new ServerSocket(8000);
       } catch (IOException e) {
           System.exit(1);
       }
       Socket client = null;
       System.out.println("Server is empty");
       try {
    	   client = server.accept();
       } catch (IOException e) {
           System.exit(1);
       }
       System.out.println("Connection successful");
       System.out.println("Type here: ");
       PrintWriter out = new PrintWriter(client.getOutputStream(), true);
       BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
       String line;
       while ((line = in.readLine()) != null) {
           System.out.println("Server: " + line);
           out.println(line);
           if (line.equals("quit")) {
        	   System.out.println("Exit");
        	   break;
           }
               
       }
       out.close();
       in.close();
       client.close();
       server.close();
   }
}