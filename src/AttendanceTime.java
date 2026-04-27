package oot;

import java.awt.event.*;
import java.io.*;
import java.sql.Statement;
import java.util.Formatter;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class AttendanceTime extends JFrame{
	private JButton DisplayButton;
	private JButton clearButton;
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton Print_Btn;
	
	
	public AttendanceTime() {
		
		super("front page");
		getContentPane().setBackground(new Color(51, 204, 204));
		getContentPane().setLayout(null);
		
		 DisplayButton = new JButton("Search");
		 DisplayButton.setBounds(21, 129, 89, 23);
		getContentPane().add(DisplayButton);
		
		 clearButton = new JButton("clear");
		 clearButton.setBounds(21, 162, 89, 23);
		getContentPane().add(clearButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 10, 283, 231);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		textField = new JTextField();
		textField.setBounds(21, 35, 89, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Date From:");
		lblNewLabel.setBounds(21, 22, 89, 13);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(21, 88, 89, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Date To:");
		lblNewLabel_1.setBounds(23, 74, 59, 13);
		getContentPane().add(lblNewLabel_1);
			
		
		Print_Btn = new JButton("Print");
		Print_Btn.setBounds(25, 195, 85, 21);
		getContentPane().add(Print_Btn);
		
		Print_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter bw = null;
			//	Formatter outfile = null;
				/*try {
				//	outfile = new Formatter ("Enroll.txt");
					bw = new BufferedWriter(new FileWriter ("C:\\Users\\atis\\eclipse-workspace\\assignment\\oot ass\\Enroll.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				try{
					//Class.forName("com.mysql.jdbc.Driver");
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
					
					PreparedStatement st = conn.prepareStatement("SELECT * from AllStudents WHERE Date BETWEEN ? AND ? ");
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.executeQuery();
					ResultSet rs = st.getResultSet();
					
					//try{
						
						//outfile = new Formatter("Report.txt");
						//outfile.format("%s %s %s \n", "Name","Module","Date");
					try {
						//	outfile = new Formatter ("Enroll.txt");
							bw = new BufferedWriter(new FileWriter ("C:\\Users\\atis\\eclipse-workspace\\assignment\\oot ass\\roll.txt"));
							bw.write("Name"+"    "+"Module"+"    "+ "Date"+"       "+ "Attendance");
							bw.newLine();
						while(rs.next()){
							//System.out.println(rs.getString("Name")+ rs.getString("Module")+ rs.getString("Date")+ rs.getString("Attendance"));
						//	outfile.format("%s %s %s \n", rs.getString("Name"), rs.getString("Module"), rs.getString("Date"));
							bw.write(rs.getString("Name")+"    "+rs.getString("Module")+"    "+ rs.getString("Date")+"     "+ rs.getString("Attendance"));
							bw.newLine();
						}
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					JOptionPane.showMessageDialog(null, "Saved Successfully :D");
					conn.close();
					st.close();
					//}catch(FileNotFoundException es){
						//System.out.println(es);
					//}
					
				}catch(SQLException es){//catch connection error
					es.printStackTrace();
				}
			
				
			}
		});
		//btnNewButton_1.setBounds(25, 220, 85, 21);
		//getContentPane().add(btnNewButton_1);
		
		
		
		clearButton.addActionListener(new clearHandler());
		DisplayButton.addActionListener(new DisplayHandler());
		
	}
	/*private class  PrintHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		
			}
		}*/
		

	private class  DisplayHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
					
					//Statement st = conn.createStatement();
					//String squery = "SELECT * from default";
					//String squery = new String("SELECT * from student");
					//PreparedStatement st = conn.prepareStatement(squery);
					//ResultSet rs =  st.executeQuery("select * from absents");
					PreparedStatement st = conn.prepareStatement("SELECT * from AllStudents WHERE Date BETWEEN ? AND ? ");
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.executeQuery();
					ResultSet rs = st.getResultSet();
					ResultSetMetaData rmsd= rs.getMetaData();
					DefaultTableModel model= (DefaultTableModel) table_1 .getModel();
					int cols= rmsd.getColumnCount();
					String [] colName= new String [cols];
					for(int i=0; i<cols;i++) 
						colName[i]=rmsd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
						String Firstname,Lastname,No_of_Absents, Module;
					while(rs.next()) {
						Firstname=rs.getString(1);
						Lastname=rs.getString(2);
						No_of_Absents=rs.getString(3);
						Module=rs.getString(4);
						
						String [] row= {Firstname,Lastname,No_of_Absents, Module};
						model.addRow(row);
					}
					
					st.close();
					conn.close();
					
			 } 
			 catch (ClassNotFoundException  | SQLException ae) {
				ae.printStackTrace();
				}
			 
			 
			
			
		}
	}
	
	private class clearHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			table_1.setModel(new DefaultTableModel());
			
			
		}
	}
		}
