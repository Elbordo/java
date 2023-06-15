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
package hellofx;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import org.w3c.dom.Text;
public class Main extends JFrame {
	Main(){
   setLayout(null);
   JLabel labelF=new JLabel("Enter the Year:");
   labelF.setBounds(30,20,200,20);
 add(labelF);   
    JLabel labelL=new JLabel("Enter the Gender:");
    labelL.setBounds(30,50,200,20);
 add(labelL);
  JLabel labelC=new JLabel("Enter the Name:");
  labelC.setBounds(30,80,100,20);
 add(labelC);
 JLabel labelR=new JLabel("");
 labelR.setBounds(175,220,500,20);
add(labelR);
 JTextField textY=new JTextField();
 textY.setBounds(200, 20, 200, 20);
 add(textY);
 JTextField textG=new JTextField();
 textG.setBounds(200, 50, 200, 20);
   add(textG);
 JTextField textN=new JTextField();
   textN.setBounds(200, 80, 200, 20);
 add(textN);
 JLabel labelS=new JLabel("Do you want to Search for another Name:");
 labelS.setBounds(170,250,500,20);
add(labelS);
labelS.setVisible(false);
 JButton nBut =new JButton("No");
 nBut.setBounds(300, 280, 80, 20);
 add(nBut);
 nBut.setVisible(false);
 nBut.addActionListener(e -> System.exit(0));
 JButton yBut =new JButton("Yes");
 yBut.setBounds(200, 280, 80, 20);
add(yBut);
yBut.setVisible(false);
yBut.addActionListener(e -> {
	textY.setText("");
	textG.setText("");
	textN.setText("");
	labelR.setText("");
	yBut.setVisible(false);
	nBut.setVisible(false);
	labelS.setVisible(false);
});
   JButton sub =new JButton("Submit Query");
   sub.setBounds(60, 110, 140, 20);
  add(sub);
  sub.addActionListener(e -> { 
	  int rank = 0;
	  boolean flag = false;
	  String gen = "";
	  if(textG.getText().charAt(0) == 'm' || textG.getText().charAt(0)== 'M') gen = "Boy";
      if(textG.getText().charAt(0) == 'f' || textG.getText().charAt(0) == 'F') gen = "Girl";
	  try {
	      Scanner file = new Scanner(new FileReader("babynamesranking"+ textY.getText() + ".txt"));
	      while (file.hasNext()&& !flag) {
	        rank = file.nextInt();
	        String boyName = file.next();
	        int mNum = file.nextInt();
	        String girlName = file.next();
	        int fNum = file.nextInt();
	        if ((boyName.equals(textN.getText()) || girlName.equals(textN.getText()))) {
	            flag = true;
	            labelR.setText(gen + " named " + textN.getText() + " is ranked #" + rank + " in " + textY.getText());
	            yBut.setVisible(true);
	            nBut.setVisible(true);
	            labelS.setVisible(true);
	          }
	        }
	        if (!flag) {
	          labelR.setText(gen + " named " + textN.getText() + " is not in a register of " + textY.getText());
	        }
	      } catch (Exception ex) {
	    	  labelR.setText("File not found");
	      } 
        }); 
 
  JButton exit =new JButton("Exit");
  exit.setBounds(400, 110, 140, 20);
  add(exit);
  exit.addActionListener(e -> System.exit(0));
   setTitle("Search Name Ranking Application");
   setSize(600,400);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
}
 public static void main(String args[]) {
	 Main start=new Main();
	 
  }

}  


