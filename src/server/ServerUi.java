import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
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
 * @author Rahul Gupta
 * @Version 1.0
 */

public class ServerUi {
	private JFrame serverFrame;
	public static final Color LIGHTBLUE = new Color(230, 230, 250);
	public static final Color LIGHTRED = new Color(255, 218, 185);
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
		serverFrame.getContentPane().setBackground(new Color(173, 216, 230));
		serverFrame.setTitle("Server");
		serverFrame.setBounds(100, 100, 670, 588);
		serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("start / stop");
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 18));
		btnNewButton.setBounds(448, 13, 192, 34);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(12, 59, 628, 323);
		serverFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Highest<br>value:</html>");
		lblNewLabel.setBounds(345, 13, 133, 61);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(LIGHTBLUE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lbllowestvalue = new JLabel("<html>Lowest<br>value:</html>");
		lbllowestvalue.setBounds(345, 87, 133, 61);
		panel.add(lbllowestvalue);
		lbllowestvalue.setHorizontalAlignment(SwingConstants.LEFT);
		lbllowestvalue.setFont(new Font("Courier New", Font.PLAIN, 18));
		lbllowestvalue.setBorder(BorderFactory.createLineBorder(Color.black));
		lbllowestvalue.setOpaque(true);
		lbllowestvalue.setBackground(new Color(255, 228, 225));
		
		JLabel lblfrequencyhz = new JLabel("<html>Frequency<br>(Hz):</html>");
		lblfrequencyhz.setBounds(345, 161, 133, 61);
		panel.add(lblfrequencyhz);
		lblfrequencyhz.setHorizontalAlignment(SwingConstants.LEFT);
		lblfrequencyhz.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblfrequencyhz.setBorder(BorderFactory.createLineBorder(Color.black));
		lblfrequencyhz.setBackground(LIGHTBLUE);
		lblfrequencyhz.setOpaque(true);
		
		JTextPane textPane = new JTextPane();
		textPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textPane.setBounds(490, 13, 126, 61);
		panel.add(textPane);
		textPane.setBackground(new Color(255, 228, 225));
		textPane.setFont(new Font("Courier New", Font.PLAIN, 18));
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(490, 87, 126, 61);
		panel.add(textPane_1);
		textPane_1.setBackground(LIGHTBLUE);
		textPane_1.setFont(new Font("Courier New", Font.PLAIN, 18));
		textPane_1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(490, 161, 126, 61);
		panel.add(textPane_2);
		textPane_2.setBackground(new Color(255, 228, 225));
		textPane_2.setFont(new Font("Courier New", Font.PLAIN, 18));
		textPane_2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(22, 13, 311, 296);
		panel.add(textPane_3);
		textPane_3.setBackground(new Color(255, 228, 225));
		textPane_3.setFont(new Font("Courier New", Font.PLAIN, 18));
		textPane_3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textConsole = new JTextPane();
		textConsole.setText("Console:");
		textConsole.setFont(new Font("Courier New", Font.PLAIN, 18));
		textConsole.setBackground(new Color(211, 211, 211));
		textConsole.setBounds(12, 390, 628, 138);
		textConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		serverFrame.getContentPane().add(textConsole);
	}
}