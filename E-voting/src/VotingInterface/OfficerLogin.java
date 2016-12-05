package VotingInterface;
import Voting.RegisterUserDBHandler;
import Voting.User;
import Voting.VoteSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OfficerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerLogin frame = new OfficerLogin();
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
	public OfficerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User Name:");
		label.setBounds(72, 103, 68, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(72, 128, 68, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(136, 100, 163, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 125, 163, 17);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				
				VoteSystem officer = new VoteSystem();
				
				
				if(officer.login(username, password, "eo") == true) {
					EoDecision eo = new EoDecision();
					eo.setVisible(true);
				}
				
				else{
					JOptionPane.showMessageDialog(contentPane, "You are not a registered User! Please Try Again.");
				}
			}
		});
		btnNewButton.setBounds(296, 163, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblOfficerLogin = DefaultComponentFactory.getInstance().createTitle("Officer Login");
		lblOfficerLogin.setBounds(174, 30, 88, 14);
		contentPane.add(lblOfficerLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpeningScreen os = new OpeningScreen();
				os.setVisible(true);
			}
		});
		btnBack.setBounds(54, 163, 89, 23);
		contentPane.add(btnBack);
	}
}
