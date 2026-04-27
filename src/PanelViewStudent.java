package Attendance;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelViewStudent extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelViewStudent() {
		
		setBounds(0, 0, 565, 409);
		setLayout(null);
		//setVisible(true);
		
		JLabel lblNewLabel = new JLabel("View Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 75, 275, 66);
		add(lblNewLabel);

	}

}
