package oot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;

public class LecturerDashboard extends JFrame {

	private JPanel contentPane;
	
	private Image logo = new ImageIcon(this.getClass().getResource("/academia.png")).getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH);
	private Image tattendance = new ImageIcon(this.getClass().getResource("/Takeattendance.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	/*private Image ateacher = new ImageIcon(this.getClass().getResource("/ateacher.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vstudent = new ImageIcon(this.getClass().getResource("/vstudent.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vteacher = new ImageIcon(this.getClass().getResource("/vteacher.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vattendance = new ImageIcon(this.getClass().getResource("/vattendance.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);*/
	private Image logout = new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH);
	
	
	private PanelTakeAttendance panelTakeAttendance;
	//private PanelAddStudent panelAddStudent;
	//private PanelViewTeacher panelViewTeacher;
	//private PanelViewStudent panelViewStudent;
	//private PanelViewAttendance panelViewAttendance;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LecturerDashboard frame = new LecturerDashboard();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LecturerDashboard() {
		super("Attendance Reporting System - Lecturer Dashboard");
		getContentPane().setLayout(new FlowLayout());
		setBackground(new Color(0, 0, 255));
		
		setBounds(100, 100, 850, 470);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		//contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTakeAttendance = new PanelTakeAttendance();
		//panelAddTeacher.setBounds(270, 5, 1, 1);
		//panelAddStudent = new PanelAddStudent();
		//panelAddStudent.setBounds(276, 5, 1, 1);
		//panelViewStudent = new PanelViewStudent();
		//panelViewStudent.setBounds(288, 5, 1, 1);
		//panelViewTeacher = new PanelViewTeacher();
		//panelViewTeacher.setBounds(282, 5, 1, 1);
		//panelViewAttendance = new PanelViewAttendance();
		//panelViewAttendance.setBounds(294, 5, 1, 1);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(47, 79, 79));
		panelMenu.setBounds(0, 0, 249, 431);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 229, 145);
		lblIconLogo.setIcon(new ImageIcon(logo));
		panelMenu.add(lblIconLogo);
		
		JPanel paneTakeAttendance = new JPanel();
		paneTakeAttendance.addMouseListener(new PanelButtonMouseAdapter(paneTakeAttendance) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelTakeAttendance);
			}
			
		});
		paneTakeAttendance.setBackground(new Color(47, 79, 79));
		paneTakeAttendance.setBounds(0, 217, 249, 40);
		panelMenu.add(paneTakeAttendance);
		paneTakeAttendance.setLayout(null);
		
		JLabel TAlabel = new JLabel("TAKE ATTENDANCE");
		TAlabel.setIcon(new ImageIcon(tattendance));
		TAlabel.setHorizontalAlignment(SwingConstants.CENTER);
		TAlabel.setForeground(new Color(255, 255, 255));
		TAlabel.setFont(new Font("Dialog", Font.BOLD, 14));
		TAlabel.setBounds(30, 10, 169, 25);
		
		paneTakeAttendance.add(TAlabel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(20, 15, 46, 14);
		paneTakeAttendance.add(lblNewLabel_6);
		
		JPanel paneLogout = new JPanel();
		paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//if(
						//JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?"); //== 0) {
				front f = new front();
				f.show();
				dispose();
				/*FrameLogin frameLogin = new FrameLogin();
				frameLogin.setVisble(true);
				Dashboard.this.dispose();}*/
			}
		});
		paneLogout.setBackground(new Color(47, 79, 79));
		paneLogout.setBounds(0, 256, 249, 40);
		panelMenu.add(paneLogout);
		paneLogout.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel(" LOGOUT");
		lblNewLabel_5.setBounds(32, 11, 142, 19);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setIcon(new ImageIcon(logout));
		paneLogout.add(lblNewLabel_5);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(22, 9, 46, 14);
		paneLogout.add(lblNewLabel_11);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(259, 11, 565, 409);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		
		panelMainContent.add(panelTakeAttendance);
		//panelMainContent.add(panelAddStudent);
		//panelMainContent.add(panelViewTeacher);
		//panelMainContent.add(panelViewStudent);
		//panelMainContent.add(panelViewAttendance);
		  
		menuClicked(panelTakeAttendance);
		 
		
		
		
}
	public void menuClicked(JPanel selectedPanel) {
		panelTakeAttendance.setVisible(false);
		//panelAddStudent.setVisible(false);
	//	panelViewTeacher.setVisible(false);
		//panelViewStudent.setVisible(false);
		//panelViewAttendance.setVisible(false);
		
		selectedPanel.setVisible(true);
		
	}


  private class PanelButtonMouseAdapter extends MouseAdapter {
  
  JPanel panel; public PanelButtonMouseAdapter(JPanel panel) {
	  this.panel=panel; 
  }
  
  public void mouseEntered(MouseEvent e) { 
	  panel.setBackground(new Color(112,128,144));
  
  } 
  
  public void mouseExited(MouseEvent e) { 
	  panel.setBackground(new  Color(47,79,79)); 
	  
  } 
  
  public void mousePressed(MouseEvent e) {
	  panel.setBackground(new Color(60,179,113));
  
  } 
  
  public void mouseReleased(MouseEvent e) { 
	  panel.setBackground(new Color(112,128,144));
  
  }
  
  }
}
