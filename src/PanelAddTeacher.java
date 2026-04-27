package Attendance;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PanelAddTeacher extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAddTeacher() {
		
		
		setBounds(0, 0, 565, 409);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Add Teacher");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 63, 230, 59);
		add(lblNewLabel);

	}
}
