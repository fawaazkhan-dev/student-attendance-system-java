package oot;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

//import oot.AllStudents.DisplayHandler;
//import oot.AllStudents.clearHandler;

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

public class PanelViewStudent extends JPanel {
	private JButton DisplayButton;
	private JButton clearButton;
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	
		
		
		//setVisible(true);
		
		/*JLabel lblNewLabel = new JLabel("View Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 75, 275, 66);
		add(lblNewLabel);*/
		
		
		
		public PanelViewStudent() {
			initialize();}
		private void initialize() {
			
			setBounds(0, 0, 565, 409);
			setLayout(null);
			
			
			setBackground(new Color(153, 255, 153));
			setLayout(null);
			
			 DisplayButton = new JButton("Search");
			 DisplayButton.setBackground(new Color(204, 255, 255));
			 DisplayButton.setBounds(21, 207, 89, 23);
			add(DisplayButton);
			
			 clearButton = new JButton("clear");
			 clearButton.setBackground(new Color(204, 255, 255));
			 clearButton.setBounds(21, 240, 89, 23);
			add(clearButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(204, 255, 255));
			scrollPane.setBounds(183, 79, 350, 267);
			add(scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
			
			textField = new JTextField();
			textField.setBounds(21, 110, 108, 19);
			add(textField);
			textField.setColumns(10);
			
			lblNewLabel = new JLabel("Student Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(21, 87, 108, 13);
			add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Student Attendance");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setBounds(134, 10, 317, 48);
			add(lblNewLabel_1);
			
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


