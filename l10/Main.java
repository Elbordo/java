/**********************************************
Workshop # 10
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 10.12.2022(dd.mm.yyyy)
**********************************************/ 
package hellofx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
	private Connection conn;
	private Statement stmt; 
	private ResultSet res;
	private JFrame frame;
	private Container cPane;
	private JLabel sIDLabel;
	private JTextField sIDField;
	private JLabel sNameLabel;
	private JTextField sNameField;
	private JLabel sEmailLabel;
	private JTextField sEmailField;
    private JLabel sAddLabel;
	private JTextField sAddField;
	private JLabel sYearLabel;
	private JTextField sYearField;
	private JLabel sProgLabel;
	private JTextField sProgField;
	private JButton bInsert;
	private JButton bSelect;
	private JButton bUpdate;
	private JButton bDelete;
	private JButton bNext;
    private JButton bExit;
  
  public Main() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Unable to load JDBC driver");
    }
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","123456");
      stmt = conn.createStatement();
      System.out.println("Connected to the database");
    } catch (SQLException e) {
      System.out.println("Connection failed");
    }
    frame = new JFrame("Workshop-10 Student SQL");
    cPane = frame.getContentPane();
    cPane.setLayout(new GridLayout(9,2));
    sIDLabel = new JLabel("Student ID");
    sIDField = new JTextField();
    sNameLabel = new JLabel("Student Name");
    sNameField = new JTextField();
    sEmailLabel = new JLabel("Student E-mail");
    sEmailField = new JTextField();
    sAddLabel = new JLabel("Mailing Address");
    sAddField = new JTextField();
    sYearLabel = new JLabel("Enrolment year");
    sYearField = new JTextField();
    sProgLabel = new JLabel("Program");
    sProgField = new JTextField();
    bInsert = new JButton("Insert");
    bSelect = new JButton("Select");
    bUpdate = new JButton("Update");
    bDelete = new JButton("Delete");
    bNext = new JButton("Next");
    bExit = new JButton("Exit");
    cPane.add(sIDLabel);
    cPane.add(sIDField);
    cPane.add(sNameLabel);
    cPane.add(sNameField);
    cPane.add(sEmailLabel);
    cPane.add(sEmailField);
    cPane.add(sAddLabel);
    cPane.add(sAddField);
    cPane.add(sYearLabel);
    cPane.add(sYearField);
    cPane.add(sProgLabel);
    cPane.add(sProgField);
    cPane.add(bInsert);
    cPane.add(bSelect);
    cPane.add(bUpdate);
    cPane.add(bDelete);
    cPane.add(bNext);
    cPane.add(bExit);
    frame.setSize(500,500);
    frame.setVisible(true);
    bInsert.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String sID = sIDField.getText();
        String sName = sNameField.getText();
        String sEmail = sEmailField.getText();
        String sAdd = sAddField.getText();
        String sYear = sYearField.getText();
        String sProg = sProgField.getText();
        try {
          PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?,?)");
          pstmt.setString(1, sID);
          pstmt.setString(2, sName);
          pstmt.setString(3, sEmail);
          pstmt.setString(4, sAdd);
          pstmt.setString(5, sYear);
          pstmt.setString(6, sProg);
          pstmt.executeUpdate();
          JOptionPane.showMessageDialog(frame, "New record under ID: " + sID + " has been added");
        } catch (SQLException ex) {
          System.out.println("Error has occured");
        }
      }
    });
    bSelect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String sID = sIDField.getText();
        try {
          PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE sID=?");
          pstmt.setString(1, sID);
          res = pstmt.executeQuery();
          if (res.next()) {
            sNameField.setText(res.getString("sName"));
            sEmailField.setText(res.getString("sEmail"));
            sAddField.setText(res.getString("sAdd"));
            sYearField.setText(res.getString("sYear"));
            sProgField.setText(res.getString("sProg"));
          }
          JOptionPane.showMessageDialog(frame, "Looking for ID: " + sID);
        } catch (SQLException ex) {
          System.out.println("Error has occured");
        }
      }
    });
    bUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  String sID = sIDField.getText();
          String sName = sNameField.getText();
          String sEmail = sEmailField.getText();
          String sAdd = sAddField.getText();
          String sYear = sYearField.getText();
          String sProg = sProgField.getText();
        try {
          PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET sName=?,sEmail=?,sAdd=?,sYear=?,sProg=? WHERE sID=?");
          
          pstmt.setString(1, sName);
          pstmt.setString(2, sEmail);
          pstmt.setString(3, sAdd);
          pstmt.setString(4, sYear);
          pstmt.setString(5, sProg);
          pstmt.setString(6, sID);
          pstmt.executeUpdate();
          JOptionPane.showMessageDialog(frame, "Updating ID: " + sID);
        } catch (SQLException ex) {
          System.out.println("Error has occured");
        }
      }
    });
    bDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int dialogResult = JOptionPane.showConfirmDialog(frame, "Please, confirm your action", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
          String sID = sIDField.getText();
          try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM student WHERE sID=?");
            pstmt.setString(1, sID);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Record under ID: " + sID + " has been deleted");
          } catch (SQLException ex) {
            System.out.println("Error has occured");
          }
        }
      }
    });
    bExit.addActionListener(new ActionListener() {
  	  public void actionPerformed(ActionEvent e) {
  		JOptionPane.showMessageDialog(frame, "Bye, Bye!");
  		System.exit(0);
  	  }
  });
  }
  
  public static void main(String[] args) {
    new Main();
  }
  
}