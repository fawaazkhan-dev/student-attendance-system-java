package oot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JRadioButton;

public class teach_table {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField Username;
	private JTextField Password;
	private JTable table;
	
	DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teach_table window = new teach_table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public teach_table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 598, 416);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lecturer_ID");
		lblNewLabel.setBounds(32, 37, 74, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(32, 70, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(32, 104, 62, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(32, 142, 62, 13);
		panel.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(104, 34, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(104, 67, 96, 19);
		panel.add(name);
		name.setColumns(10);
		
		Username = new JTextField();
		Username.setBounds(104, 101, 96, 19);
		panel.add(Username);
		Username.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(104, 139, 96, 19);
		panel.add(Password);
		Password.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 10, 295, 374);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				name.setText(model.getValueAt(i, 1).toString());
				Username.setText(model.getValueAt(i, 2).toString());
				Password.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setBackground(new Color(224, 255, 255));
		model= new DefaultTableModel();
		Object[] column = {"Lecture_ID", "Name","Username","Password"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("") || name.getText().equals("") || Username.getText().equals("") || Password.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
				}
				else
				{
				   row[0]=id.getText();
				   row[1]=name.getText();
				   row[2]=Username.getText();
				   row[3]=Password.getText();
				
			       model.addRow(row);
				 
				
				   /*id.setText("");
				   name.setText("");
				   cont.setText("");
				   course.setText("");
				   //JOptionPane.showMessageDialog(null, "Saved Successfully :D");*/
				   
				  try{
					  String dbURL = "jdbc:mysql://localhost:3306/attendance";
						String username = "root";
						String password = "";
					Connection conn = DriverManager.getConnection(dbURL,username,password);
					
					String ins = new String("INSERT INTO lecturer (Lecturer_ID, Name, Username, Password) VALUES (?,?,?,?,?)");
					PreparedStatement stmt = conn.prepareStatement(ins);
					//insert the textfields and butons...
					stmt.setString(1,id.getText());
					stmt.setString(2,name.getText());
					stmt.setString(3,Username.getText());
					stmt.setString(4,Password.getText());
					
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
		btnNewButton.setBounds(9, 233, 85, 21);
		panel.add(btnNewButton);
		//not good
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				//if(i>=0)
				//{
				   model.removeRow(i);
				   /*JOptionPane.showMessageDialog(null, "Deleted Successfully");
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
				String ins = new String("DELETE from lecturer where Lecturer_ID=?");
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
				conn.close();
				stmt.close();
				
			}catch(SQLException es){//catch connection error
				es.printStackTrace();
			}
				
		}
		});
		btnNewButton_1.setBounds(10, 298, 85, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int i=table.getSelectedRow();
				if(i>0)
				{
				   model.setValueAt(id.getText(), i, 0);
				   model.setValueAt(name.getText(), i, 1);
				   model.setValueAt(cont.getText(), i, 2);
				   model.setValueAt(course.getText(), i, 3);
				   JOptionPane.showMessageDialog(null,  "Updated Successfully ;)");*/
					try{
						  String dbURL = "jdbc:mysql://localhost:3306/attendance";
							String username = "root";
							String password = "";
						Connection conn = DriverManager.getConnection(dbURL,username,password);
						
						//String ins = new String("INSERT INTO student (ID, Name, Contact, Course) VALUES (?,?,?,?)");
						String ins = new String("UPDATE lecturer Set Name=?, Contact=?, Course=? where Lecturer_ID=?");
						PreparedStatement stmt = conn.prepareStatement(ins);
						//insert the textfields and butons...
						
						stmt.setString(1,name.getText());
						stmt.setString(2,Username.getText());
						stmt.setString(3,Password.getText());
						stmt.setString(4,id.getText());
						//execute the query
						int row = stmt.executeUpdate();
						if(row>0)
							JOptionPane.showMessageDialog(null,  "Updated Successfully ;)");
							//JOptionPane.showMessageDialog(null, "Saved Successfully :D");
							//System.out.println("inserted");
						conn.close();
						stmt.close();
						
					}catch(SQLException es){//catch connection error
						es.printStackTrace();
					}
				//}
				/*else
				{
					JOptionPane.showMessageDialog(null,  "Please Select a Row First");
				}*/
			}
		});
		btnNewButton_2.setBounds(160, 233, 85, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				Username.setText("");
				Password.setText("");
			}
		});
		btnNewButton_3.setBounds(160, 298, 85, 21);
		panel.add(btnNewButton_3);
		
		
	}
}

