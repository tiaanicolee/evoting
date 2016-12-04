package VotingInterface;
import Voting.RegisterUserDBHandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Voting.RegisterUserDBHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoterLogin extends JFrame {

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
		textField.setBounds(147, 89, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 120, 146, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
			
				RegisterUserDBHandler validate = new RegisterUserDBHandler();
				if(validate.findUser(username, password, "voter").equals(username)) {
					Candidates c = new Candidates();
					c.setVisible(true);
				}
				else {
					OpeningScreen os = new OpeningScreen();
					os.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(288, 151, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(69, 92, 68, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(69, 123, 68, 14);
		contentPane.add(lblPassword);
		
		JLabel lblVoterLogin = DefaultComponentFactory.getInstance().createTitle("Voter Login");
		lblVoterLogin.setBounds(184, 26, 92, 14);
		contentPane.add(lblVoterLogin);
	}
}
