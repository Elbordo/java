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

public class Client9 {
   public static void main(String[] args) throws IOException {
       Socket socket = null;
       PrintWriter out = null;
       BufferedReader in = null;
       try {
           socket = new Socket("127.0.0.1", 8000);
           out = new PrintWriter(socket.getOutputStream(), true);
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       } catch (UnknownHostException e) {
           System.exit(1);
       } catch (IOException e) {
           System.exit(1);
       }
       BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
       String serv;
       String use;
       while ((serv = in.readLine()) != null) {
           System.out.println("Server: " + serv);
           if (serv.equals("quit"))break;
           use = read.readLine();
           if (use != null) {
               System.out.println("Client: " + use);
               out.println(use);
           }
       }
       out.close();
       in.close();
       read.close();
       socket.close();
   }
}