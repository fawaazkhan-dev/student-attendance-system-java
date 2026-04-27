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
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;



import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;

public class front extends JFrame{
	private JButton AdminButton;
	private JButton LectureButton;
	
	public front() {
		//super("main frame");
		setUndecorated(false);
		//setSize(878, 758);
		setBounds(300, 0, 899, 689);
		getContentPane().setBackground(new Color(51, 102, 102));
		getContentPane().setLayout(null);
		//getContentPane().setSize(400, 400);
		JLabel lblNewLabel = new JLabel("Attendance System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(260, 24, 387, 35);
		getContentPane().add(lblNewLabel);
		//JButton button = new JButton(new ImageIcon(((new ImageIcon("images/pic.jpg")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
//(((new ImageIcon(""C:\\Users\\USER 1\\Desktop\\picture.png"")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH))
		JButton AdminButton = new JButton("");
		AdminButton.setBorder(null);
		
		AdminButton.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\atis\\Downloads\\admin.png")).getImage()).getScaledInstance(165, 145, java.awt.Image.SCALE_SMOOTH)));
		AdminButton.setBackground(new Color(51, 102, 102));
		AdminButton.setBounds(196, 415, 169, 150);
		getContentPane().add(AdminButton);
		
		JButton LectureButton = new JButton("");
		LectureButton.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\atis\\Downloads\\lect.png")).getImage()).getScaledInstance(165, 145, java.awt.Image.SCALE_SMOOTH)));
		LectureButton.setBackground(new Color(51, 102, 102));
		LectureButton.setBounds(521, 415, 169, 150);
		getContentPane().add(LectureButton);
		
		/*JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\atis\\Downloads\\picatt.png")).getImage()).getScaledInstance(165, 245, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(55, 91, 535, 211);
		getContentPane().add(lblNewLabel_1);*/
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(190, 97, 500, 224);
		lblNewLabel_1.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\atis\\Downloads\\picatt.png")).getImage()).getScaledInstance(565, 245, java.awt.Image.SCALE_SMOOTH)));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN");
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(236, 575, 115, 35);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LECTURER");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(542, 575, 135, 35);
		getContentPane().add(lblNewLabel_3);
		
		//handler p= new handler();
		
		
		AdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//private class  adminhandler implements ActionListener{
			//public void actionPerformed(ActionEvent e) {
				
				
					//JOptionPane.showMessageDialog(null, "succesful enter in admin","check", JOptionPane.PLAIN_MESSAGE);
				
				FrameLogin f = new FrameLogin();
				f.show();
				dispose();
				
				//setVisible(false);
				//f.setVisible(true);
				//front.this.dispose();
				
			}
		});
		LectureButton.addActionListener(new lecturerhandler());
		
	}
	
	private class  lecturerhandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			LoginLecturer f = new LoginLecturer();
			f.show();
			dispose();
				//JOptionPane.showMessageDialog(null, "succesful enter in lecturer","check", JOptionPane.PLAIN_MESSAGE);
			
			
		}
	}
}

