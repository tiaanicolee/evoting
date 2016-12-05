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
					Candidates frame = new Candidates(0);
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
	public Candidates(int id) {
		final OpeningScreen os = new OpeningScreen();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final int ID = id;
		
		JButton rdbtnNewRadioButton = new JButton("Squirtle");
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, please", "No, thanks"};
                int n = JOptionPane.showOptionDialog(contentPane,
                   "Are you sure?",
                   "A Follow-up Question",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
                if (n == JOptionPane.YES_OPTION) {
                	VoteDBHandler squirtle = new VoteDBHandler();
    				squirtle.saveVotes("squirtle", ID);
    				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
    				dispose();
    				os.setVisible(true);
                } else if (n == JOptionPane.NO_OPTION) {
                	Candidates c = new Candidates(ID);
					c.setVisible(true);
                } 
				
				
				
			}
		});
		rdbtnNewRadioButton.setBounds(248, 57, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton rdbtnNewRadioButton_1 = new JButton("Charmander");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, please", "No, thanks"};
                int n = JOptionPane.showOptionDialog(contentPane,
                   "Are you sure?",
                   "A Follow-up Question",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
                if (n == JOptionPane.YES_OPTION) {
                	VoteDBHandler squirtle = new VoteDBHandler();
    				squirtle.saveVotes("charmander", ID);
    				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
    				dispose();
    				os.setVisible(true);
                } else if (n == JOptionPane.NO_OPTION) {
                	Candidates c = new Candidates(ID);
					c.setVisible(true);
                } 
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(248, 92, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton rdbtnNewRadioButton_2 = new JButton("Bulbasaur");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, please", "No, thanks"};
                int n = JOptionPane.showOptionDialog(contentPane,
                   "Are you sure?",
                   "A Follow-up Question",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
                if (n == JOptionPane.YES_OPTION) {
                	VoteDBHandler squirtle = new VoteDBHandler();
    				squirtle.saveVotes("bulbasaur", ID);
    				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
    				dispose();
    				os.setVisible(true);
                } else if (n == JOptionPane.NO_OPTION) {
                	Candidates c = new Candidates(ID);
					c.setVisible(true);
                } 
				
			}
		});
		rdbtnNewRadioButton_2.setBounds(248, 127, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton rdbtnNewRadioButton_3 = new JButton("Pikachu");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes, please", "No, thanks"};
                int n = JOptionPane.showOptionDialog(contentPane,
                   "Are you sure?",
                   "A Follow-up Question",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   options,
                   options[0]);
                if (n == JOptionPane.YES_OPTION) {
                	VoteDBHandler squirtle = new VoteDBHandler();
    				squirtle.saveVotes("pikachu", ID);
    				JOptionPane.showMessageDialog(contentPane, "Thank you For Voting!");
    				dispose();
    				os.setVisible(true);
                } else if (n == JOptionPane.NO_OPTION) {
                	Candidates c = new Candidates(ID);
					c.setVisible(true);
                } 				
			}
		});
		rdbtnNewRadioButton_3.setBounds(248, 162, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblDemocraticParty = new JLabel("Democratic Party");
		lblDemocraticParty.setBounds(113, 59, 123, 16);
		contentPane.add(lblDemocraticParty);
		
		JLabel lblRepublicanParty = new JLabel("Republican Party");
		lblRepublicanParty.setBounds(112, 94, 109, 16);
		contentPane.add(lblRepublicanParty);
		
		JLabel lblGreenParty = new JLabel("Green Party");
		lblGreenParty.setBounds(113, 129, 108, 16);
		contentPane.add(lblGreenParty);
		
		JLabel lblLibertarianParty = new JLabel("Libertarian Party");
		lblLibertarianParty.setBounds(113, 164, 108, 16);
		contentPane.add(lblLibertarianParty);
	}
}
