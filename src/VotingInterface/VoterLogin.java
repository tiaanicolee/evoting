package VotingInterface;
import Voting.RegisterUserDBHandler;
import Voting.VoteSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Voting.RegisterUserDBHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VoterLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoterLogin frame = new VoterLogin();
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
	public VoterLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 89, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				VoteSystem officer = new VoteSystem();
				int id = officer.login(username, password, "V");
				if(id >= 0 && officer.canVote())  {
					dispose();
					Candidates c = new Candidates(id);
					c.setVisible(true);
				} 
				else if (id >= 0  && !officer.canVote()) {
					JOptionPane.showMessageDialog(contentPane, "This user has already voted once.");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You are not a registered User! Please Try Again.");
			}
		}});
		btnNewButton.setBounds(293, 167, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(96, 92, 92, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(96, 125, 68, 14);
		contentPane.add(lblPassword);
		
		JLabel lblVoterLogin = DefaultComponentFactory.getInstance().createTitle("Voter Login");
		lblVoterLogin.setBounds(184, 26, 92, 14);
		contentPane.add(lblVoterLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpeningScreen os = new OpeningScreen();
				os.setVisible(true);
			}
		});
		btnBack.setBounds(75, 167, 89, 23);
		contentPane.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(183, 121, 146, 28);
		contentPane.add(passwordField);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //Close program
				dispose(); //Close window
				contentPane.setVisible(false); //Hide window
			}
		});
		btnExit.setBounds(168, 217, 117, 29);
		contentPane.add(btnExit);
		
		JLabel lblEnterTheUsername = new JLabel("Enter The Username and Password Given to You");
		lblEnterTheUsername.setBounds(96, 51, 242, 14);
		contentPane.add(lblEnterTheUsername);
	}
}
