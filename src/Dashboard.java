package Attendance;

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

public class Dashboard extends JFrame {

	private JPanel contentPane;
	
	private Image logo = new ImageIcon(this.getClass().getResource("/academia.png")).getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH);
	private Image astudent = new ImageIcon(this.getClass().getResource("/astudent.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image ateacher = new ImageIcon(this.getClass().getResource("/ateacher.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vstudent = new ImageIcon(this.getClass().getResource("/vstudent.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vteacher = new ImageIcon(this.getClass().getResource("/vteacher.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image vattendance = new ImageIcon(this.getClass().getResource("/vattendance.png")).getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	private Image logout = new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH);
	
	private PanelAddTeacher panelAddTeacher;
	private PanelAddStudent panelAddStudent;
	private PanelViewTeacher panelViewTeacher;
	private PanelViewStudent panelViewStudent;
	private PanelViewAttendance panelViewAttendance;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		super("Attendance Reporting System");
		getContentPane().setLayout(new FlowLayout());
		setBackground(new Color(0, 0, 255));
		
		setBounds(100, 100, 850, 470);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		//contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelAddTeacher = new PanelAddTeacher();
		//panelAddTeacher.setBounds(270, 5, 1, 1);
		panelAddStudent = new PanelAddStudent();
		//panelAddStudent.setBounds(276, 5, 1, 1);
		panelViewStudent = new PanelViewStudent();
		//panelViewStudent.setBounds(288, 5, 1, 1);
		panelViewTeacher = new PanelViewTeacher();
		//panelViewTeacher.setBounds(282, 5, 1, 1);
		panelViewAttendance = new PanelViewAttendance();
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
		
		JPanel paneAddTeacher = new JPanel();
		paneAddTeacher.addMouseListener(new PanelButtonMouseAdapter(paneAddTeacher) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAddTeacher);
			}
			
		});
		paneAddTeacher.setBackground(new Color(47, 79, 79));
		paneAddTeacher.setBounds(0, 159, 249, 40);
		panelMenu.add(paneAddTeacher);
		paneAddTeacher.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD TEACHER");
		lblNewLabel.setIcon(new ImageIcon(ateacher));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 169, 25);
		
		paneAddTeacher.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(20, 15, 46, 14);
		paneAddTeacher.add(lblNewLabel_6);
		
		JPanel paneAddStudent = new JPanel();
		paneAddStudent.addMouseListener(new PanelButtonMouseAdapter(paneAddStudent) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAddStudent);
			}
		});
		paneAddStudent.setBackground(new Color(47, 79, 79));
		paneAddStudent.setBounds(0, 197, 249, 40);
		panelMenu.add(paneAddStudent);
		paneAddStudent.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 11, 146, 19);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(astudent));
		paneAddStudent.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(20, 10, 46, 14);
		paneAddStudent.add(lblNewLabel_7);
		
		JPanel paneViewTeacher = new JPanel();
		paneViewTeacher.addMouseListener(new PanelButtonMouseAdapter(paneViewTeacher) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelViewTeacher);
			}
		});
		paneViewTeacher.setBackground(new Color(47, 79, 79));
		paneViewTeacher.setBounds(0, 237, 249, 40);
		panelMenu.add(paneViewTeacher);
		paneViewTeacher.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" VIEW TEACHER");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(37, 9, 138, 19);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon(vteacher));
		paneViewTeacher.add(lblNewLabel_2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(24, 14, 46, 14);
		paneViewTeacher.add(lblNewLabel_8);
		
		JPanel paneViewStudent = new JPanel();
		paneViewStudent.addMouseListener(new PanelButtonMouseAdapter(paneViewStudent) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelViewStudent);
			}
		});
		paneViewStudent.setBackground(new Color(47, 79, 79));
		paneViewStudent.setBounds(0, 277, 249, 40);
		panelMenu.add(paneViewStudent);
		paneViewStudent.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(" VIEW STUDENT");
		lblNewLabel_3.setBounds(40, 9, 146, 19);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(vstudent));
		paneViewStudent.add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(21, 14, 46, 14);
		paneViewStudent.add(lblNewLabel_9);
		
		JPanel paneViewAttendance = new JPanel();
		paneViewAttendance.addMouseListener(new PanelButtonMouseAdapter(paneViewAttendance) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelViewAttendance);
			}
		});
		paneViewAttendance.setBackground(new Color(47, 79, 79));
		paneViewAttendance.setBounds(0, 317, 249, 40);
		panelMenu.add(paneViewAttendance);
		paneViewAttendance.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("VIEW ATTENDANCE");
		lblNewLabel_4.setBounds(43, 9, 177, 19);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setIcon(new ImageIcon(vattendance));
		paneViewAttendance.add(lblNewLabel_4);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(23, 9, 46, 14);
		paneViewAttendance.add(lblNewLabel_10);
		
		JPanel paneLogout = new JPanel();
		paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//if(
						JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?"); //== 0) {
				/*FrameLogin frameLogin = new FrameLogin();
				frameLogin.setVisble(true);
				Dashboard.this.dispose();}*/
			}
		});
		paneLogout.setBackground(new Color(47, 79, 79));
		paneLogout.setBounds(0, 357, 249, 40);
		panelMenu.add(paneLogout);
		paneLogout.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel(" LOGOUT");
		lblNewLabel_5.setBounds(44, 11, 142, 19);
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
		
		
		panelMainContent.add(panelAddTeacher);
		panelMainContent.add(panelAddStudent);
		panelMainContent.add(panelViewTeacher);
		panelMainContent.add(panelViewStudent);
		panelMainContent.add(panelViewAttendance);
		  
		menuClicked(panelAddTeacher);
		 
		
		
		
}
	public void menuClicked(JPanel selectedPanel) {
		panelAddTeacher.setVisible(false);
		panelAddStudent.setVisible(false);
		panelViewTeacher.setVisible(false);
		panelViewStudent.setVisible(false);
		panelViewAttendance.setVisible(false);
		
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
