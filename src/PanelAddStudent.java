package Attendance;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		lblNewLabel.setBounds(32, 37, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(32, 70, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		lblNewLabel_2.setBounds(32, 104, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course");
		lblNewLabel_3.setBounds(32, 142, 45, 13);
		panel.add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(83, 34, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(83, 67, 96, 19);
		panel.add(name);
		name.setColumns(10);
		
		cont = new JTextField();
		cont.setBounds(83, 101, 96, 19);
		panel.add(cont);
		cont.setColumns(10);
		
		course = new JTextField();
		course.setBounds(83, 139, 96, 19);
		panel.add(course);
		course.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 10, 408, 415);
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
		btnNewButton.setBounds(10, 233, 85, 21);
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
				 
				
				   id.setText("");
				   name.setText("");
				   cont.setText("");
				   course.setText("");
				   JOptionPane.showMessageDialog(null, "Saved Successfully :D");
				}
			}
		});
		panel.add(btnNewButton);
		//not good
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBounds(10, 298, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
				   model.removeRow(i);
				   JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setBounds(160, 233, 85, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>0)
				{
				   model.setValueAt(id.getText(), i, 0);
				   model.setValueAt(name.getText(), i, 1);
				   model.setValueAt(cont.getText(), i, 2);
				   model.setValueAt(course.getText(), i, 3);
				   JOptionPane.showMessageDialog(null,  "Updated Successfully ;)");
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Please Select a Row First");
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(160, 298, 85, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				cont.setText("");
				course.setText("");
			}
		});
		panel.add(btnNewButton_3);
		
		

	}

}
