package client;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
 * @author Vivek Faldu
 * @Version 1.0
 */

public class ClientUi {
	private JFrame clientFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUi clientUi = new ClientUi();
					clientUi.clientFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the graphical user interface
	 */
	public ClientUi() {
		initialize();
	}
	/**
	 * Initialize the contents of the GUI.
	 */
	private void initialize(){
		clientFrame = new JFrame();
		clientFrame.getContentPane().setBackground(ClientConstants.BLUE);
		clientFrame.setTitle("Server");
		clientFrame.setBounds(100, 100, 800, 715);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.getContentPane().setLayout(null);
		
		JButton btnStartStopButton = new JButton("Start / Stop");
		btnStartStopButton.setBackground(ClientConstants.LIGHT_RED);
		btnStartStopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("Start/Stop");
			}
			
		});
		btnStartStopButton.setFont(ClientConstants.F1);
		btnStartStopButton.setBounds(580, 13, 190, 34);
		btnStartStopButton.setBorder(BorderFactory.createLineBorder(Color.black));
		clientFrame.getContentPane().add(btnStartStopButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 59, 760, 470);
		clientFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane textGraph = new JTextPane();
		textGraph.setBounds(22, 13, 440, 440);
		panel.add(textGraph);
		textGraph.setBackground(ClientConstants.LIGHT_RED);
		textGraph.setFont(ClientConstants.F1);
		textGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel lblHighValue = new JLabel("<html>Highest<br>value:</html>");
		lblHighValue.setBounds(470, 13, 133, 80);
		panel.add(lblHighValue);
		lblHighValue.setBackground(ClientConstants.LIGHT_BLUE);
		lblHighValue.setOpaque(true);
		lblHighValue.setFont(ClientConstants.F1);
		lblHighValue.setBorder(BorderFactory.createLineBorder(Color.black));
		lblHighValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighValue.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblLowValue = new JLabel("<html>Lowest<br>value:</html>");
		lblLowValue.setBounds(470, 103, 133, 80);
		panel.add(lblLowValue);
		lblLowValue.setFont(ClientConstants.F1);
		lblLowValue.setBorder(BorderFactory.createLineBorder(Color.black));
		lblLowValue.setOpaque(true);
		lblLowValue.setBackground(ClientConstants.LIGHT_RED);
		lblLowValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowValue.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblAverage = new JLabel("<html>Average:</html>");
		lblAverage.setBounds(470, 193, 133, 80);
		panel.add(lblAverage);
		lblAverage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowValue.setVerticalAlignment(SwingConstants.CENTER);
		lblAverage.setFont(ClientConstants.F1);
		lblAverage.setBorder(BorderFactory.createLineBorder(Color.black));
		lblAverage.setBackground(ClientConstants.LIGHT_BLUE);
		lblAverage.setOpaque(true);
		

		JLabel lblChannels = new JLabel("<html>Channels:</html>");
		lblChannels.setBounds(470, 283, 133, 80);
		panel.add(lblChannels);
		lblChannels.setHorizontalAlignment(SwingConstants.CENTER);
		lblChannels.setVerticalAlignment(SwingConstants.CENTER);
		lblChannels.setFont(ClientConstants.F1);
		lblChannels.setBorder(BorderFactory.createLineBorder(Color.black));
		lblChannels.setBackground(ClientConstants.LIGHT_RED);
		lblChannels.setOpaque(true);
		
		
		
		JLabel lblFrequency = new JLabel("<html>Frequency<br>(Hz):</html>");
		lblFrequency.setBounds(470, 373, 133, 80);
		panel.add(lblFrequency);
		lblFrequency.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrequency.setVerticalAlignment(SwingConstants.CENTER);
		lblFrequency.setFont(ClientConstants.F1);
		lblFrequency.setBorder(BorderFactory.createLineBorder(Color.black));
		lblFrequency.setBackground(ClientConstants.LIGHT_BLUE);
		lblFrequency.setOpaque(true);
		
		
		JTextPane textHighValue = new JTextPane();  
		textHighValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textHighValue.setBounds(615, 13, 126, 80);
		panel.add(textHighValue);
		textHighValue.setEditable(false);
		textHighValue.setBackground(ClientConstants.LIGHT_RED);
		textHighValue.setFont(ClientConstants.F1);
		textHighValue.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textLowValue = new JTextPane();
		textLowValue.setBounds(615, 103, 126, 80);
		panel.add(textLowValue);
		textLowValue.setEditable(false);
		textLowValue.setBackground(ClientConstants.LIGHT_BLUE);
		textLowValue.setFont(ClientConstants.F1);
		textLowValue.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextPane textAvg = new JTextPane(); 
		textAvg.setBounds(615, 193, 126, 80);
		panel.add(textAvg);
		textAvg.setEditable(false);
		textAvg.setBackground(ClientConstants.LIGHT_RED);
		textAvg.setFont(ClientConstants.F1);
		textAvg.setBorder(BorderFactory.createLineBorder(Color.black));
		
		String[] channels = { "1", "2", "3", "4", "5" };

		JComboBox<String> channelDropDown = new JComboBox<String>(channels);
		channelDropDown.setSelectedIndex(1);
		channelDropDown.setBounds(615,300,126,40);
		panel.add(channelDropDown);
		channelDropDown.setBackground(ClientConstants.LIGHT_BLUE);
		((JLabel)channelDropDown.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
		channelDropDown.setFont(ClientConstants.F1);
		channelDropDown.setBorder(BorderFactory.createLineBorder(Color.black));
		channelDropDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			System.out.print(channelDropDown.getSelectedItem());				
			}
		});
		
		JTextPane textFrequency = new JTextPane(); 
		textFrequency.setBounds(615, 373, 126, 80);
		panel.add(textFrequency);
		textFrequency.setBackground(ClientConstants.LIGHT_RED);
		textFrequency.setFont(ClientConstants.F1);
		textFrequency.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JTextPane textConsole = new JTextPane();
		textConsole.setText("Console:");
		textConsole.setFont(ClientConstants.F1);
		textConsole.setBackground(new Color(211, 211, 211));
		textConsole.setBounds(10, 550, 760, 100);
		textConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		clientFrame.getContentPane().add(textConsole);
	}
}