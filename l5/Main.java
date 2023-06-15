/**********************************************
Workshop # 5
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 01.11.2022(dd.mm.yyyy)
**********************************************/ 
package hellofx;
import javafx.application.Application;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;
public class Main extends JFrame {
	Main(){
   setLayout(null);
   JLabel labelF=new JLabel("First Name:");
   labelF.setBounds(20,20,200,20);
 add(labelF);   
    JLabel labelL=new JLabel("Last Name:");
    labelL.setBounds(20,50,100,20);
 add(labelL);
  JLabel labelC=new JLabel("City:");
  labelC.setBounds(20,80,100,20);
 add(labelC);
   JLabel labelP=new JLabel("Province:");
   labelP.setBounds(210,80,100,20);
 add(labelP);
   JLabel labelPC=new JLabel("Postal Code:");
   labelPC.setBounds(370,80,100,20);
 add(labelPC);
 JTextField textF=new JTextField();
 textF.setBounds(100, 20, 450, 20);
 add(textF);
 JTextField textL=new JTextField();
 textL.setBounds(100, 50, 450, 20);
   add(textL);
 JTextField textC=new JTextField();
   textC.setBounds(60, 80, 150, 20);
 add(textC);
 String arr[]={"Select Province","Ontario","Quebec"};
 JComboBox box=new JComboBox(arr);
 box.setBounds(270, 80, 100, 20);
    add(box);
 JTextField textPC=new JTextField();
 textPC.setBounds(450, 80, 100, 20);
   add(textPC);
   JButton add =new JButton("Add");
   add.setBounds(20, 110, 90, 20);
  add(add);
  JButton first =new JButton("First");
   first.setBounds(110, 110, 90, 20);
  add(first);
  JButton next =new JButton("Next");
  next.setBounds(200, 110, 90, 20);
  add(next);
  JButton pre =new JButton("Previous");
   pre.setBounds(290, 110, 90, 20);
  add(pre);
  JButton last =new JButton("Last");
   last.setBounds(380, 110, 90, 20);
  add(last);
  JButton upd =new JButton("Update");
   upd.setBounds(470, 110, 90, 20);
  add(upd);
   setTitle("Address Book");
   setSize(600,180);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
}
 public static void main(String args[]) {
	 Main start=new Main();
  }
}  


