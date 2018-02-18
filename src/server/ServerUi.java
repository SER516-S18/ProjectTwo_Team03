package server;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * @SER516 Project2_Team03
 * @Version 1.0
 */

public class ServerUi {
	private JFrame serverFrame;
	private boolean serverRunning = false;

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
		serverFrame.getContentPane().setBackground(ServerConstants.FRAMECOLOR);
		serverFrame.setTitle("Server");
		serverFrame.setBounds(100, 100, 670, 588);
		serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setBackground(ServerConstants.MAINPANELCOLOR);
		mainPanel.setBounds(12, 59, 628, 323);
		serverFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JPanel display = new JPanel();
		display.setBorder(BorderFactory.createLineBorder(Color.black));
		display.setBackground(ServerConstants.SKIN);
		display.setBounds(22, 13, 311, 296);
		display.setLayout(new GridBagLayout());
		mainPanel.add(display);
		
		BlinkingText T = new BlinkingText();
		T.setFont(ServerConstants.BLINKINGTEXTFONT);
		display.add(T);

		JButton btnNewButton = new JButton("start / stop");
		btnNewButton.setBackground(ServerConstants.SKIN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverRunning = !serverRunning;
				if(serverRunning == true){
					T.start();
				}
				else{
					T.stop();
				}
			}
		});
		btnNewButton.setFont(ServerConstants.COURIERFONT);
		btnNewButton.setBounds(448, 13, 192, 34);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(btnNewButton);


		JLabel lblhighestvalue = new JLabel("<html>Highest<br>value:</html>");
		lblhighestvalue.setBounds(345, 13, 133, 61);
		mainPanel.add(lblhighestvalue);
		lblhighestvalue.setBackground(ServerConstants.LIGHTBLUE);
		lblhighestvalue.setOpaque(true);
		lblhighestvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lblhighestvalue.setFont(ServerConstants.COURIERFONT);
		lblhighestvalue.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel lbllowestvalue = new JLabel("<html>Lowest<br>value:</html>");
		lbllowestvalue.setBounds(345, 87, 133, 61);
		mainPanel.add(lbllowestvalue);
		lbllowestvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lbllowestvalue.setFont(ServerConstants.COURIERFONT);
		lbllowestvalue.setBorder(BorderFactory.createLineBorder(Color.black));
		lbllowestvalue.setOpaque(true);
		lbllowestvalue.setBackground(ServerConstants.SKIN);

		JLabel lblfrequencyhz = new JLabel("<html>Frequency<br>(Hz):</html>");
		lblfrequencyhz.setBounds(345, 161, 133, 61);
		mainPanel.add(lblfrequencyhz);
		lblfrequencyhz.setHorizontalAlignment(SwingConstants.LEFT);
		lblfrequencyhz.setFont(ServerConstants.COURIERFONT);
		lblfrequencyhz.setBorder(BorderFactory.createLineBorder(Color.black));
		lblfrequencyhz.setBackground(ServerConstants.LIGHTBLUE);
		lblfrequencyhz.setOpaque(true);

		JTextPane textHighest = new JTextPane();
		textHighest.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textHighest.setBounds(490, 13, 126, 61);
		mainPanel.add(textHighest);
		textHighest.setBackground(ServerConstants.SKIN);
		textHighest.setFont(ServerConstants.COURIERFONT);
		textHighest.setBorder(BorderFactory.createLineBorder(Color.black));

		JTextPane textLowest = new JTextPane();
		textLowest.setBounds(490, 87, 126, 61);
		mainPanel.add(textLowest);
		textLowest.setBackground(ServerConstants.LIGHTBLUE);
		textLowest.setFont(ServerConstants.COURIERFONT);
		textLowest.setBorder(BorderFactory.createLineBorder(Color.black));

		JTextPane textFrequencyHZ = new JTextPane();
		textFrequencyHZ.setBounds(490, 161, 126, 61);
		mainPanel.add(textFrequencyHZ);
		textFrequencyHZ.setBackground(ServerConstants.SKIN);
		textFrequencyHZ.setFont(ServerConstants.COURIERFONT);
		textFrequencyHZ.setBorder(BorderFactory.createLineBorder(Color.black));

		JTextPane textConsole = new JTextPane();

		// textConsole.setText("Console:");
		textConsole.setFont(ServerConstants.COURIERFONT);
		textConsole.setBackground(ServerConstants.CONSOLECOLOR);
		textConsole.setBounds(12, 390, 628, 138);
		textConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		ServerConsole sc = ServerConsole.getInstance();
		sc.setJtextPane(textConsole);
		sc.print("hello");
		serverFrame.getContentPane().add(textConsole);
	}
}