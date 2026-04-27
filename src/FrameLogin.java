package oot;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mysql.cj.xdevapi.Statement;

import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameLogin extends JFrame {
	
	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("/high-school.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_username = new ImageIcon(FrameLogin.class.getResource("/businessman.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(FrameLogin.class.getResource("/padlock.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_login = new ImageIcon(FrameLogin.class.getResource("/key.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_cancel = new ImageIcon(FrameLogin.class.getResource("/cancel.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JPanel pnlBtnLogin;
	private JLabel lblLoginMessage = new JLabel("");
	private JTextField txtAdmin;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		super("LOGIN");
		setSize(660,457);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(180, 141, 250, 40);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//same as password i explained down 
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 10, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		//image next to username
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(204, 0, 46, 40);
		lblIconUsername.setIcon(new ImageIcon(img_username));
		panel.add(lblIconUsername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(180, 191, 250, 40);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//when click on text box password, when clicked it becomes empty(focus gained) and by default password (focus lost)
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
				txtPassword.setEchoChar('●');
				txtPassword.setText("");
				}
				else
				{
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 10, 170, 18);
		panel_1.add(txtPassword);
		
		//image next to password
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(204, 0, 46, 40);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		panel_1.add(lblIconPassword);
		
		
		//LOGIN BUTTON
		pnlBtnLogin = new JPanel();
		
		/*pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUsername.getText().equals("admin")&& txtPassword.getText().equals("admin123")) {
					//if user inputs are correct
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("") || 
						txtPassword.getText().equals("Password")) {
					lblLoginMessage.setText("Please input all requirements!");
				}
				else {
					lblLoginMessage.setText("INVALID USERNAME OR PASSWORD!");
				}
			}
		});*/
		
		pnlBtnLogin.setBackground(new Color(255, 255, 204));
		pnlBtnLogin.setBounds(180, 256, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JButton btnNewLabel = new JButton("LOGIN");
		
		btnNewLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql1.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","");
					//String username= txtUsername.getText();
					//String password= txtPassword.getText();
					
					//java.sql.Statement stm = con.createStatement(); ///maybe not good
					
					//String sql = new String("select * from admin where username =? and password=?");  //
					
					PreparedStatement stm = con.prepareStatement("select * from admin where username =? and password=?");
					stm.setString(1, txtUsername.getText());
					stm.setString(2, String.valueOf(txtPassword.getPassword()));
					ResultSet rs = stm.executeQuery();
					if (rs.next()) {
						//JOptionPane.showMessageDialog(null,"Login sucessfully");
						//dispose();
						//else if(txtUsername.getText()="" &&  "String.valueOf(txtPassword.getPassword()") {
						Dashboard d = new Dashboard();
						d.show();
						dispose();	
							
						//}
					}else {
						JOptionPane.showMessageDialog(null, "username or password wrong");  
						txtUsername.setText("");
						txtPassword.setText("");
					}
					con.close();
				}
				catch(Exception E) {
					System.out.println(E.getMessage());
				}
			}
			
		});
		/*btnNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtUsername.getText().equals("admin")&& txtPassword.getText().equals("admin123")) {
					//if user inputs are correct
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("") || 
						txtPassword.getText().equals("Password")) {
					lblLoginMessage.setText("Please input all requirements!");
				}
				else {
					lblLoginMessage.setText("INVALID USERNAME OR PASSWORD!");
				}
			}
		});*/
		btnNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewLabel.setBorder(null);
		btnNewLabel.setBackground(new Color(255, 255, 204));
		btnNewLabel.setForeground(new Color(128, 0, 0));
		btnNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewLabel.setBounds(104, 10, 128, 28);
		pnlBtnLogin.add(btnNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setBounds(20, 0, 50, 50);
		lblIconLogin.setIcon(new ImageIcon(img_login));
		pnlBtnLogin.add(lblIconLogin);
		
		
		//Close Button
		/*
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		*/
		
		//high school logo
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(180, -14, 250, 123);
		contentPane.add(lblIconLogo);
		setUndecorated(false);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setForeground(new Color(128, 0, 0));
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setBounds(179, 284, 251, 14);
		contentPane.add(lblLoginMessage);
		
		//admin text next to school logo
		txtAdmin = new JTextField();
		txtAdmin.setEditable(false);
		txtAdmin.setBorder(null);
		txtAdmin.setBackground(new Color(51, 0, 51));
		txtAdmin.setForeground(new Color(255, 255, 255));
		txtAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdmin.setText("ADMIN");
		txtAdmin.setBounds(258, 99, 86, 20);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		/*JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.setBounds(487, 334, 93, 25);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(102, 0, 51));
		btnNewButton.setBackground(new Color(255, 255, 204));*/
		
		JPanel pnlBtnCancel = new JPanel();
		pnlBtnCancel.setLayout(null);
		pnlBtnCancel.setBackground(new Color(255, 255, 204));
		pnlBtnCancel.setBounds(180, 316, 250, 50);
		contentPane.add(pnlBtnCancel);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setForeground(new Color(128, 0, 0));
		btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(255, 255, 204));
		btnCancel.setBounds(104, 10, 128, 28);
		pnlBtnCancel.add(btnCancel);
		
		JLabel lblIconCancel = new JLabel("");
		lblIconCancel.setBounds(20, 0, 50, 50);
		lblIconCancel.setIcon(new ImageIcon(img_cancel));
		pnlBtnCancel.add(lblIconCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front f = new front();
				f.show();
				dispose();
			}
			
		});
		
		
		setLocationRelativeTo(null);
		
	}
}
