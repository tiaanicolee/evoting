package VotingInterface;
import Voting.VoteDBHandler;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Candidates extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidates frame = new Candidates();
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
	public Candidates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton rdbtnNewRadioButton = new JButton("Squirtle");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteDBHandler squirtle = new VoteDBHandler();
				squirtle.saveVotes("squirtle");
				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
				dispose();
				VoterLogin voter = new VoterLogin();
				voter.setVisible(true);
				
				
			}
		});
		rdbtnNewRadioButton.setBounds(30, 47, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton rdbtnNewRadioButton_1 = new JButton("Charmander");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteDBHandler charmander = new VoteDBHandler();
				charmander.saveVotes("charmander");
				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
				dispose();
				VoterLogin voter = new VoterLogin();
				voter.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(30, 73, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton rdbtnNewRadioButton_2 = new JButton("Bulbasaur");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteDBHandler bulb = new VoteDBHandler();
				bulb.saveVotes("bulbasaur");
				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
				dispose();
				VoterLogin voter = new VoterLogin();
				voter.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_2.setBounds(30, 110, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton rdbtnNewRadioButton_3 = new JButton("Pikachu");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteDBHandler pik = new VoteDBHandler();
				pik.saveVotes("pikachu");
				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
				dispose();
				VoterLogin voter = new VoterLogin();
				voter.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_3.setBounds(30, 136, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(241, 182, 89, 23);
		contentPane.add(btnSubmit);
	}
}
