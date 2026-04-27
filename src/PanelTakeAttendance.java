package oot;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

//import oot.ta.comboHandler;
//import oot.ta.okHandler;

//import oot.AttendanceTime.DisplayHandler;
//import oot.AttendanceTime.clearHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PanelTakeAttendance extends JPanel {
	private JTable table;
	private String[] subjects = new String[]{"oot", "Operating systems"};
	JButton okButton;
	JComboBox comboBox;
	DefaultTableModel db;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	
	public PanelTakeAttendance() {
		setBackground(new Color(204, 204, 153));
		initialize();}
	private void initialize() {
		//initialize();}
	//private void initialize() {
		
		setBounds(0, 0, 565, 415);
		setLayout(null);
		setVisible(true);
		
		/*JLabel lblNewLabel = new JLabel("Take Attendance");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 90, 265, 68);
		add(lblNewLabel);*/

		
			setLayout(null);
			
			 comboBox = new JComboBox(subjects);
			comboBox.setBounds(22, 112, 100, 22);
			add(comboBox);
			
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
			String header[]= {"username", "date", "present"};
			Object [][] data = {{" ", " ", false}};
			db.setDataVector(data, header);
			
			table = new JTable(db);
			//scrollPane.setViewportView(table);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(132, 70, 393, 236);
			add(scrollPane);
			
			 okButton = new JButton("ok");
			 okButton.setBackground(new Color(204, 255, 255));
			okButton.setBounds(22, 230, 89, 23);
			add(okButton);
			
			lblNewLabel = new JLabel("Select Module:");
			lblNewLabel.setBounds(22, 89, 100, 13);
			add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Take Attendance");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setBounds(150, 23, 336, 32);
			add(lblNewLabel_1);
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
	

