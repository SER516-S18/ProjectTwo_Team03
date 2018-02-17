package src.server;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

/**
 * @SER516 Project2_Team03
 * @Version 1.0
 */

public class ServerUi {
	private JFrame serverFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUi serverUi = new ServerUi();
					serverUi.serverFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerUi() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		serverFrame = new JFrame();
		serverFrame.getContentPane().setBackground(ServerConstants.BLUE);
		serverFrame.setTitle("Server");
		serverFrame.setBounds(100, 100, 670, 588);
		serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("start / stop");
		btnNewButton.setBackground(ServerConstants.SKIN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(ServerConstants.COURIERFONT);
		btnNewButton.setBounds(448, 13, 192, 34);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(ServerConstants.LIGHTGREY);
		panel.setBounds(12, 59, 628, 323);
		serverFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblhighestvalue = new JLabel("<html>Highest<br>value:</html>");
		lblhighestvalue.setBounds(345, 13, 133, 61);
		panel.add(lblhighestvalue);
		lblhighestvalue.setBackground(ServerConstants.LIGHTBLUE);
		lblhighestvalue.setOpaque(true);
		lblhighestvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lblhighestvalue.setFont(ServerConstants.COURIERFONT);
		lblhighestvalue.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lbllowestvalue = new JLabel("<html>Lowest<br>value:</html>");
		lbllowestvalue.setBounds(345, 87, 133, 61);
		panel.add(lbllowestvalue);
		lbllowestvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lbllowestvalue.setFont(ServerConstants.COURIERFONT);
		lbllowestvalue.setBorder(BorderFactory.createLineBorder(Color.black));
		lbllowestvalue.setOpaque(true);
		lbllowestvalue.setBackground(ServerConstants.SKIN);
		
		JLabel lblfrequencyhz = new JLabel("<html>Frequency<br>(Hz):</html>");
		lblfrequencyhz.setBounds(345, 161, 133, 61);
		panel.add(lblfrequencyhz);
		lblfrequencyhz.setHorizontalAlignment(SwingConstants.LEFT);
		lblfrequencyhz.setFont(ServerConstants.COURIERFONT);
		lblfrequencyhz.setBorder(BorderFactory.createLineBorder(Color.black));
		lblfrequencyhz.setBackground(ServerConstants.LIGHTBLUE);
		lblfrequencyhz.setOpaque(true);
		
		JTextPane textHighest = new JTextPane();
		textHighest.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textHighest.setBounds(490, 13, 126, 61);
		panel.add(textHighest);
		textHighest.setBackground(ServerConstants.SKIN);
		textHighest.setFont(ServerConstants.COURIERFONT);
		textHighest.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textLowest = new JTextPane();
		textLowest.setBounds(490, 87, 126, 61);
		panel.add(textLowest);
		textLowest.setBackground(ServerConstants.LIGHTBLUE);
		textLowest.setFont(ServerConstants.COURIERFONT);
		textLowest.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textFrequencyHZ = new JTextPane();
		textFrequencyHZ.setBounds(490, 161, 126, 61);
		panel.add(textFrequencyHZ);
		textFrequencyHZ.setBackground(ServerConstants.SKIN);
		textFrequencyHZ.setFont(ServerConstants.COURIERFONT);
		textFrequencyHZ.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(22, 13, 311, 296);
		panel.add(textPane_3);
		textPane_3.setBackground(ServerConstants.SKIN);
		textPane_3.setFont(ServerConstants.COURIERFONT);
		textPane_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textConsole = new JTextPane();
		textConsole.setText("Console:");
		textConsole.setFont(ServerConstants.COURIERFONT);
		textConsole.setBackground(ServerConstants.DARKGREY);
		textConsole.setBounds(12, 390, 628, 138);
		textConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(textConsole);
	}
}