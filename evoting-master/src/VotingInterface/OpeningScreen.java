package VotingInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpeningScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningScreen frame = new OpeningScreen();
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
	public OpeningScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAreYouA = DefaultComponentFactory.getInstance().createTitle("Are you a Voter or Election Officer?");
		lblAreYouA.setBounds(129, 53, 183, 43);
		contentPane.add(lblAreYouA);
		
		JButton btnVoter = new JButton("Voter");
		btnVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoterLogin v = new VoterLogin();
				v.setVisible(true);
			}
		});
		btnVoter.setBounds(58, 173, 89, 23);
		contentPane.add(btnVoter);
		
		JButton btnOfficer = new JButton("Officer");
		btnOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficerLogin o = new OfficerLogin();
				o.setVisible(true);
			}
		});
		btnOfficer.setBounds(272, 173, 89, 23);
		contentPane.add(btnOfficer);
	}
}
