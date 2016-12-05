package VotingInterface;
import Voting.VoteDBHandler;
import Voting.VoteSystem;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EoDecision extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EoDecision frame = new EoDecision();
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
	public EoDecision() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouWish = new JLabel("Do you wish to view results or do a recount?");
		lblDoYouWish.setBounds(102, 55, 251, 14);
		contentPane.add(lblDoYouWish);
		
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteSystem results = new VoteSystem();
				JOptionPane.showMessageDialog(contentPane, results.calcResults());
				
				
			}
		});
		btnResults.setBounds(164, 104, 89, 23);
		contentPane.add(btnResults);
		
		JButton btnRecount = new JButton("Recount");
		btnRecount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoteDBHandler results = new VoteDBHandler();
				System.out.println(results.giveVotes());
				JOptionPane.showMessageDialog(contentPane, results.giveVotes());
				//Recount rec = new Recount();
				//rec.setVisible(true);
			}
		});
		btnRecount.setBounds(164, 138, 89, 23);
		contentPane.add(btnRecount);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpeningScreen os = new OpeningScreen();
				os.setVisible(true);
			}
		});
		btnNewButton.setBounds(164, 172, 89, 23);
		contentPane.add(btnNewButton);
	}

}


