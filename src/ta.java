package oot;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.BoxLayout;
//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

//import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ta extends JFrame {
	private JTable table;
	private String[] subjects = new String[]{"oot", "Operating systems"};
	JButton okButton;
	JComboBox comboBox;
	DefaultTableModel db;
	public ta() {
		getContentPane().setLayout(null);
		
		 comboBox = new JComboBox(subjects);
		comboBox.setBounds(22, 11, 100, 22);
		getContentPane().add(comboBox);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 15, 261, 235);
		getContentPane().add(scrollPane);*/
		
		 db= new DefaultTableModel() {
			public Class getColumnClass(int column) {
				if (column == 2) {
					return Boolean.class;
					
				}else {
					return String.class;
				}
			}
		};
		String header[]= {"username", "date", "present/absent"};
		Object [][] data = {{" ", " ", false}};
		db.setDataVector(data, header);
		
		table = new JTable(db);
		//scrollPane.setViewportView(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(132, 15, 261, 235);
		getContentPane().add(scrollPane);
		
		 okButton = new JButton("ok");
		okButton.setBounds(22, 163, 89, 23);
		getContentPane().add(okButton);
		setVisible(true);
		//TableColumn col =table.getColumnModel().getColumn(3); 
		okButton.addActionListener(new okHandler());
		//comboHandler cHandler = new comboHandler();
		comboBox.addItemListener(new comboHandler());
	}
	//
	private class  okHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*Object [] data = {"sega1", "07/07/2022", true};
			db.addRow(data);
			
			Object [] data1 = {"sega2", "07/07/2022", true};
			db.addRow(data1);*/
				JOptionPane.showMessageDialog(null, "data successfully saved");
			//db.removeRow(0);
			// db.removeRow(1);
				db.setRowCount(0);
		}
	}
	private class  comboHandler implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			db.setRowCount(0);
			if((comboBox.getSelectedItem()).equals("oot")) {
				Object []data8 = {"segaoot", "07/07/2022", true};
				db.addRow(data8);
				
				Object []data12 = {"segaoot", "07/07/2022", true};
				db.addRow(data12);
				//JOptionPane.showMessageDialog(null, "oot check");
			}
			//li pe run 2 kote?\
			
			if(comboBox.getSelectedItem().equals("Operating systems")) {
				Object []data2 = {"segaos2", "06/07/2022", true};
				Object []data5 = {"segaos3", "06/07/2022", true};
				Object []data6 = {"segaos4", "06/07/2022", true};
				Object []data7 = {"segaos5", "06/07/2022", true};
				
				
				Object []data3 = {"segaos6", "08/07/2022", false};
				db.addRow(data3);
				db.addRow(data2);
				db.addRow(data5);
				db.addRow(data6);
				db.addRow(data7);
				//JOptionPane.showMessageDialog(null, "os check");
			}
			
				//JOptionPane.showMessageDialog(null, "succesful enter in admin","check", JOptionPane.PLAIN_MESSAGE);
			//db.removeRow(0);
			
		}
	}
}