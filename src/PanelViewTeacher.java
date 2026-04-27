package Attendance;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelViewTeacher extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelViewTeacher() {
		
		setBounds(0, 0, 565, 409);
		setLayout(null);
		//setVisible(true);
		
		JLabel lblNewLabel = new JLabel("View Teacher");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(147, 98, 228, 62);
		add(lblNewLabel);

	}

}
