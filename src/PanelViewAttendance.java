package Attendance;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelViewAttendance extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelViewAttendance() {
		
		setBounds(0, 0, 565, 463);
		setLayout(null);
		//setVisible(true);
		
		JLabel lblNewLabel = new JLabel("View Attendance");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 90, 265, 68);
		add(lblNewLabel);

	}

}
