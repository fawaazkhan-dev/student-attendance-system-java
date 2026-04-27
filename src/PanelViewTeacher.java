package oot;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

//import oot.dl.DisplayHandler;
//import oot.dl.clearHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PanelViewTeacher extends JPanel {

	/**
	 * Create the panel.
	 */
	
		
		//setBounds(0, 0, 565, 409);
		//setLayout(null);
		//setVisible(true);
		
		/*JLabel lblNewLabel = new JLabel("View Teacher");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 98, 228, 62);
		add(lblNewLabel);*/
		private JButton DisplayButton;
		private JButton clearButton;
		private JTable table_1;
		private JTextField textField;
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		DefaultTableModel model;
		
		
		public PanelViewTeacher() {
			initialize();
		}
		private void initialize() {
			setBounds(0, 0, 601, 399);
			setLayout(null);
			//setVisible(true);
			
			//super("front page");
		setBackground(new Color(204, 204, 255));
			setLayout(null);
			
			 DisplayButton = new JButton("Search");
			 DisplayButton.setBackground(new Color(204, 255, 255));
			 DisplayButton.setBounds(21, 220, 89, 23);
			add(DisplayButton);
			
			 clearButton = new JButton("Clear");
			 clearButton.setBackground(new Color(204, 255, 255));
			 clearButton.setBounds(21, 275, 89, 23);
			add(clearButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(204, 255, 255));
			scrollPane.setBounds(140, 80, 376, 267);
			add(scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
			
			textField = new JTextField();
			textField.setBounds(21, 111, 89, 19);
			add(textField);
			textField.setColumns(10);
			
			lblNewLabel = new JLabel("Module:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(21, 72, 89, 29);
			add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Defaulter List");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(88, 10, 376, 52);
			add(lblNewLabel_1);
			
			clearButton.addActionListener(new clearHandler());
			DisplayButton.addActionListener(new DisplayHandler());
			
		}
		private class  DisplayHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
					 //model.setRowCount(0);
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
						
						//Statement st = conn.createStatement();
						//String squery = "SELECT * from default";
						//String squery = new String("SELECT * from student");
						//PreparedStatement st = conn.prepareStatement(squery);
						//ResultSet rs =  st.executeQuery("select * from absents");
						PreparedStatement st = conn.prepareStatement("SELECT * from absents WHERE Module = ? AND No_of_Absents > 2");
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
