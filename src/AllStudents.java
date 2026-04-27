package oot;

import java.awt.event.*;
import java.sql.Statement;
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

public class AllStudents extends JFrame{
	private JButton DisplayButton;
	private JButton clearButton;
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	
	public AllStudents() {
		
		super("front page");
		getContentPane().setBackground(new Color(51, 204, 204));
		getContentPane().setLayout(null);
		
		 DisplayButton = new JButton("Search");
		 DisplayButton.setBounds(21, 106, 89, 23);
		getContentPane().add(DisplayButton);
		
		 clearButton = new JButton("clear");
		 clearButton.setBounds(21, 139, 89, 23);
		getContentPane().add(clearButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 10, 283, 231);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		textField = new JTextField();
		textField.setBounds(21, 58, 89, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setBounds(21, 35, 89, 13);
		getContentPane().add(lblNewLabel);
		
		clearButton.addActionListener(new clearHandler());
		DisplayButton.addActionListener(new DisplayHandler());
		
	}
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
					PreparedStatement st = conn.prepareStatement("SELECT * from AllStudents WHERE Name = ? ");
					st.setString(1,textField.getText());
					//st.setString(2,textField.getText());
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
