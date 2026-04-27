package oot;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

//import oot.AttendanceTime.DisplayHandler;
//import oot.AttendanceTime.clearHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PanelViewAttendance extends JPanel {
	private JButton DisplayButton;
	private JButton clearButton;
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton Print_Btn;
	private JLabel lblNewLabel_2;
	//FileOutputStream fos;
	/**
	 * Create the panel.
	 */
	public PanelViewAttendance() {
		initialize();}
	private void initialize() {
		
		setBounds(0, 0, 565, 415);
		setLayout(null);
		//setVisible(true);
		
		/*JLabel lblNewLabel = new JLabel("View Attendance");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 90, 265, 68);
		add(lblNewLabel);*/
		
		//String filename="Report.xlsx";
		
		
			
			
			setBackground(new Color(51, 204, 204));
			setLayout(null);
			
			 DisplayButton = new JButton("Search");
			 DisplayButton.setBounds(392, 90, 89, 23);
			add(DisplayButton);
			
			 clearButton = new JButton("clear");
			 clearButton.setBounds(21, 252, 89, 23);
			add(clearButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(153, 168, 368, 208);
			add(scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
			
			textField = new JTextField();
			textField.setBounds(205, 78, 121, 19);
			add(textField);
			textField.setColumns(10);
			
			lblNewLabel = new JLabel("Date From:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(106, 74, 97, 23);
			add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setBounds(205, 115, 121, 19);
			add(textField_1);
			textField_1.setColumns(10);
			
			lblNewLabel_1 = new JLabel("Date To:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(106, 107, 106, 31);
			add(lblNewLabel_1);
				
			
			Print_Btn = new JButton("Print");
			Print_Btn.setBounds(25, 306, 85, 21);
			add(Print_Btn);
			
			lblNewLabel_2 = new JLabel("Report");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_2.setBounds(153, 10, 239, 46);
			add(lblNewLabel_2);
			
			/*Print_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BufferedWriter bw = null;
				
					try{
						//Class.forName("com.mysql.jdbc.Driver");
						
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
						
						PreparedStatement st = conn.prepareStatement("SELECT * from AllStudents WHERE Date BETWEEN ? AND ? ");
						st.setString(1,textField.getText());
						st.setString(2,textField_1.getText());
						st.executeQuery();
						ResultSet rs = st.getResultSet();
						
						
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
						
						
					}catch(SQLException es){//catch connection error
						es.printStackTrace();
					}
				
					
				}
			});*/
			
	
			
			
			Print_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
						
						PreparedStatement st = conn.prepareStatement("SELECT * from allstudents WHERE Date BETWEEN ? AND ? ");
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
						//model.setColumnIdentifiers(colName);
							//String Firstname,Lastname,Date, No_of_Absence, Module;
						//while(rs.next()) {
							
							
							try (XSSFWorkbook book = new XSSFWorkbook()){
								XSSFSheet sheet = book.createSheet();
								XSSFRow header = sheet.createRow(0);
								
																
								for(int i=0; i<cols;i++) {
									XSSFCell cell = header.createCell(i);
									colName[i]=rmsd.getColumnName(i+1);
									cell.setCellValue(colName[i]);
									
								}
								
								int rowIndex=0;
								while(rs.next()) {
																
									Row row1=sheet.createRow(++rowIndex);
									for(int i=0;i<cols;i++) {
										XSSFCell cell = (XSSFCell) row1.createCell(i);
										String val = Objects.toString(rs.getObject(colName[i]));
										cell.setCellValue(val);
																											
									}
																										
								}
								
								//String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
								try(FileOutputStream fos = new FileOutputStream("Report.xlsx")){
									book.write(fos);
									fos.close();
								}
									
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						
						JOptionPane.showMessageDialog(null, "Excel Report Saved :D");
						
						
						
						st.close();
						conn.close();
						
				 } 
				 catch (ClassNotFoundException  | SQLException ae) {
					ae.printStackTrace();
					}	 		
								
				
				}
			});
			
			
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
						PreparedStatement st = conn.prepareStatement("SELECT * from allstudents WHERE Date BETWEEN ? AND ? ");
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
							String Name,Module,Date,Attendance;
						while(rs.next()) {
							Name=rs.getString(1);
							Module=rs.getString(2);
							Date=rs.getString(3);
							Attendance=rs.getString(4);
							
							
							String [] row= {Name,Module,Date,Attendance};
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

