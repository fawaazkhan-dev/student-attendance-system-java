package oot;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelAddStudent extends JPanel{
	/*
	 * public PanelAddStudent() { }
	 */

	/**
	 * Create the panel.
	 */
	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField cont;
	private JTextField course;
	private JTable table;
	DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	
	
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PanelAddStudent window = new
	 * PanelAddStudent(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	 

	/**
	 * Create the application.
	 */
	
	  public PanelAddStudent() { 
		  initialize(); 
		  }
	 
	
	public void initialize() {
		
		
		
		
		//setBounds(0, 0, 565, 409);
		//setLayout(null);
		//setVisible(true);
		
		/*
		 * JLabel lblNewLabel = new JLabel("Add Student"); lblNewLabel.setFont(new
		 * Font("Tahoma", Font.BOLD, 25));
		 * lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblNewLabel.setBounds(126, 145, 252, 65); add(lblNewLabel);
		 */
		
		//frame = new JFrame();
		//setBounds(0, 0, 604, 433);
		setBounds(0, 0, 565, 409);
		setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 37, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 70, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setBounds(10, 104, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setBounds(10, 142, 45, 13);
		panel.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(54, 34, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(54, 67, 96, 19);
		panel.add(name);
		name.setColumns(10);
		
		cont = new JTextField();
		cont.setBounds(54, 101, 96, 19);
		panel.add(cont);
		cont.setColumns(10);
		
		course = new JTextField();
		course.setBounds(54, 139, 96, 19);
		panel.add(course);
		course.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setBounds(174, 10, 381, 371);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				name.setText(model.getValueAt(i, 1).toString());
				cont.setText(model.getValueAt(i, 2).toString());
				course.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setBackground(new Color(224, 255, 255));
		model= new DefaultTableModel();
		Object[] column = {"ID", "Name","Contact","Course"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setBounds(41, 190, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("") || name.getText().equals("") || course.getText().equals("") || cont.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else
				{
				   row[0]=id.getText();
				   row[1]=name.getText();
				   row[2]=cont.getText();
				   row[3]=course.getText();
			       model.addRow(row);
				 
				
				  /* id.setText("");
				   name.setText("");
				   cont.setText("");
				   course.setText("");*/
				  // JOptionPane.showMessageDialog(null, "Saved Successfully :D");
				   try{
						  String dbURL = "jdbc:mysql://localhost:3306/attendance";
							String username = "root";
							String password = "";
						Connection conn = DriverManager.getConnection(dbURL,username,password);
						
						String ins = new String("INSERT INTO student (ID, Name, Contact, Course) VALUES (?,?,?,?)");
						PreparedStatement stmt = conn.prepareStatement(ins);
						//insert the textfields and butons...
						stmt.setString(1,id.getText());
						stmt.setString(2,name.getText());
						stmt.setString(3,cont.getText());
						stmt.setString(4,course.getText());
						
						//execute the query
						int row = stmt.executeUpdate();
						if(row>0)
							JOptionPane.showMessageDialog(null, "Saved Successfully :D");
							//System.out.println("inserted");
						conn.close();
						stmt.close();
						
					}catch(SQLException es){//catch connection error
						es.printStackTrace();
					}
				}
			}
		});
		panel.add(btnNewButton);
		//not good
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setBounds(41, 273, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				/*if(i>=0)
				{
				   model.removeRow(i);
				   JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}*/
				try{
					  String dbURL = "jdbc:mysql://localhost:3306/attendance";
						String username = "root";
						String password = "";
					Connection conn = DriverManager.getConnection(dbURL,username,password);
					
					//String ins = new String("INSERT INTO student (ID, Name, Contact, Course) VALUES (?,?,?,?)");
					String ins = new String("DELETE from student where ID=?");
					PreparedStatement stmt = conn.prepareStatement(ins);
					//insert the textfields and butons...
					
					//stmt.setString(1,name.getText());
					//stmt.setString(2,cont.getText());
					//stmt.setString(3,course.getText());
					stmt.setString(1,id.getText());
					//execute the query
					int row = stmt.executeUpdate();
					if(row>0)
						JOptionPane.showMessageDialog(null,  "Deleted Successfully ;)");
						//JOptionPane.showMessageDialog(null, "Saved Successfully :D");
						//System.out.println("inserted");
					 id.setText(" ");
					  name.setText(" ");
					  cont.setText(" ");
					  course.setText(" ");
					conn.close();
					stmt.close();
					
				}catch(SQLException es){//catch connection error
					es.printStackTrace();
				}
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setBackground(new Color(204, 255, 255));
		btnNewButton_2.setBounds(41, 230, 85, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				/*if(i>0)
				{
				   model.setValueAt(id.getText(), i, 0);
				   model.setValueAt(name.getText(), i, 1);
				   model.setValueAt(cont.getText(), i, 2);
				   model.setValueAt(course.getText(), i, 3);
				   JOptionPane.showMessageDialog(null,  "Updated Successfully ;)");
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Please Select a Row First");*/

				
				
				
				try{
					  String dbURL = "jdbc:mysql://localhost:3306/attendance";
						String username = "root";
						String password = "";
					Connection conn = DriverManager.getConnection(dbURL,username,password);
					
					//String ins = new String("INSERT INTO student (ID, Name, Contact, Course) VALUES (?,?,?,?)");
					String ins = new String("UPDATE student Set Name=?, Contact=?, Course=? where ID=?");
					PreparedStatement stmt = conn.prepareStatement(ins);
					//insert the textfields and butons...
					
					stmt.setString(1,name.getText());
					stmt.setString(2,cont.getText());
					stmt.setString(3,course.getText());
					stmt.setString(4,id.getText());
					//execute the query
					int row = stmt.executeUpdate();
					if(row>0)
						JOptionPane.showMessageDialog(null,  "Updated Successfully ;)");
						//JOptionPane.showMessageDialog(null, "Saved Successfully :D");
					
					/*id.setText("");
					name.setText("");
					cont.setText("");
					course.setText("");*/
						//System.out.println("inserted");
					conn.close();
					stmt.close();
					
				}catch(SQLException es){//catch connection error
					es.printStackTrace();
				}
				
				
				
				}
			}
		);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBackground(new Color(204, 255, 255));
		btnNewButton_3.setBounds(41, 313, 85, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			//}
				
				
			}
		});
		panel.add(btnNewButton_3);
		
		

	}

}
