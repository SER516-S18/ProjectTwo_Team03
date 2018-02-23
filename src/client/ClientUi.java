package client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
//import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.io.IOException;


/**
 * @SER516 Project2_Team03
 * @Version 1.0
 */

public class ClientUi implements ActionListener {
    private JFrame clientFrame;
    private Client client = new Client();
    JComboBox<String> channelDropDown = null;

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
        
        CalculateValues valueObject = new CalculateValues(); 
        clientFrame = new JFrame();
        clientFrame.getContentPane().setBackground(ClientConstants.FRAMECOLOR);
        clientFrame.setTitle("Client");
        clientFrame.setBounds(100, 100, 800, 715);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.getContentPane().setLayout(null);

        JButton btnStartStopButton = new JButton("Start / Stop");
        btnStartStopButton.setBackground(ClientConstants.LIGHTRED);
        btnStartStopButton.addActionListener(this);
        btnStartStopButton.setFont(ClientConstants.COURIERFONT);
        btnStartStopButton.setBounds(580, 13, 190, 34);
        btnStartStopButton.setBorder(BorderFactory.createLineBorder(Color.black));
        clientFrame.getContentPane().add(btnStartStopButton);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(ClientConstants.MAINPANELCOLOR);
        panel.setBounds(10, 59, 760, 470);
        clientFrame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel graph = new JPanel();
        graph.setBounds(22, 13, 440, 440);
        panel.add(graph);
        graph.setBackground(ClientConstants.LIGHTRED);
        graph.setBorder(BorderFactory.createLineBorder(Color.black));
        
        DisplayGraph g = new DisplayGraph();

        JLabel lblHighValue = new JLabel("<html>Highest<br>value:</html>");
        lblHighValue.setBounds(470, 13, 133, 80);
        panel.add(lblHighValue);
        lblHighValue.setBackground(ClientConstants.LIGHTBLUE);
        lblHighValue.setOpaque(true);
        lblHighValue.setFont(ClientConstants.COURIERFONT);
        lblHighValue.setBorder(BorderFactory.createLineBorder(Color.black));
        lblHighValue.setHorizontalAlignment(SwingConstants.CENTER);
        lblHighValue.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lblLowValue = new JLabel("<html>Lowest<br>value:</html>");
        lblLowValue.setBounds(470, 103, 133, 80);
        panel.add(lblLowValue);
        lblLowValue.setFont(ClientConstants.COURIERFONT);
        lblLowValue.setBorder(BorderFactory.createLineBorder(Color.black));
        lblLowValue.setOpaque(true);
        lblLowValue.setBackground(ClientConstants.LIGHTRED);
        lblLowValue.setHorizontalAlignment(SwingConstants.CENTER);
        lblLowValue.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lblAverage = new JLabel("<html>Average:</html>");
        lblAverage.setBounds(470, 193, 133, 80);
        panel.add(lblAverage);
        lblAverage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLowValue.setVerticalAlignment(SwingConstants.CENTER);
        lblAverage.setFont(ClientConstants.COURIERFONT);
        lblAverage.setBorder(BorderFactory.createLineBorder(Color.black));
        lblAverage.setBackground(ClientConstants.LIGHTBLUE);
        lblAverage.setOpaque(true);

        JLabel lblChannels = new JLabel("<html>Channels:</html>");
        lblChannels.setBounds(470, 283, 133, 80);
        panel.add(lblChannels);
        lblChannels.setHorizontalAlignment(SwingConstants.CENTER);
        lblChannels.setVerticalAlignment(SwingConstants.CENTER);
        lblChannels.setFont(ClientConstants.COURIERFONT);
        lblChannels.setBorder(BorderFactory.createLineBorder(Color.black));
        lblChannels.setBackground(ClientConstants.LIGHTRED);
        lblChannels.setOpaque(true);

        JLabel lblFrequency = new JLabel("<html>Frequency<br>(Hz):</html>");
        lblFrequency.setBounds(470, 373, 133, 80);
        panel.add(lblFrequency);
        lblFrequency.setHorizontalAlignment(SwingConstants.CENTER);
        lblFrequency.setVerticalAlignment(SwingConstants.CENTER);
        lblFrequency.setFont(ClientConstants.COURIERFONT);
        lblFrequency.setBorder(BorderFactory.createLineBorder(Color.black));
        lblFrequency.setBackground(ClientConstants.LIGHTBLUE);
        lblFrequency.setOpaque(true);

        JTextPane textHighValue = new JTextPane();
        textHighValue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        textHighValue.setBounds(615, 13, 126, 80);
        panel.add(textHighValue);
        textHighValue.setEditable(false);
        textHighValue.setBackground(ClientConstants.LIGHTRED);
        textHighValue.setFont(ClientConstants.COURIERFONT);
        textHighValue.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextPane textLowValue = new JTextPane();
        textLowValue.setBounds(615, 103, 126, 80);
        panel.add(textLowValue);
        textLowValue.setEditable(false);
        textLowValue.setBackground(ClientConstants.LIGHTBLUE);
        textLowValue.setFont(ClientConstants.COURIERFONT);
        textLowValue.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextPane textAvg = new JTextPane();
        textAvg.setBounds(615, 193, 126, 80);
        panel.add(textAvg);
        textAvg.setEditable(false);
        textAvg.setBackground(ClientConstants.LIGHTRED);
        textAvg.setFont(ClientConstants.COURIERFONT);
        textAvg.setBorder(BorderFactory.createLineBorder(Color.black));

        String[] channels = { "1", "2", "3", "4", "5" };

        channelDropDown = new JComboBox<String>(channels);
        channelDropDown.setSelectedIndex(1);
        ClientConstants.CHANNELS = Integer.parseInt(channelDropDown.getSelectedItem().toString());
        channelDropDown.setBounds(615, 300, 126, 40);
        panel.add(channelDropDown);
        channelDropDown.setBackground(ClientConstants.LIGHTBLUE);
        ((JLabel) channelDropDown.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        channelDropDown.setFont(ClientConstants.COURIERFONT);
        channelDropDown.setBorder(BorderFactory.createLineBorder(Color.black));
        channelDropDown.addActionListener(this);
        
        JTextPane textFrequency = new JTextPane();
        textFrequency.setBounds(615, 373, 126, 80);
        panel.add(textFrequency);
        textFrequency.setBackground(ClientConstants.LIGHTRED);
        textFrequency.setFont(ClientConstants.COURIERFONT);
        textFrequency.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextPane textConsole = new JTextPane();
        textConsole.setText("Console:");
        textConsole.setFont(ClientConstants.COURIERFONT);
        textConsole.setBackground(ClientConstants.CONSOLECOLOR);
        textConsole.setBounds(10, 550, 760, 100);
        textConsole.setBorder(BorderFactory.createLineBorder(Color.black));
        ClientConsole cc = ClientConsole.getInstance();
		cc.setJtextPane(textConsole);
        clientFrame.getContentPane().add(textConsole);
        
        Thread t = new Thread(new Runnable() { 
            @Override
            public void run() {
                while(true)
                {
                    textHighValue.setText(valueObject.HighestValue());
                    textLowValue.setText(valueObject.LowestValue());
                    textAvg.setText(valueObject.AverageValue());
                    g.addValues(client.next());
                    graph.add(g,BorderLayout.CENTER);
                    graph.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }       
            }

        });
        t.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String event = ev.getActionCommand();
        System.out.println(event);

        if (event.equalsIgnoreCase("comboBoxChanged")) {
            System.out.print(channelDropDown.getSelectedItem());
            ClientConstants.CHANNELS = Integer.parseInt(channelDropDown.getSelectedItem().toString());
            if (client != null) {
                try {
                    client.updateChannels(ClientConstants.CHANNELS);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        else if (event.equalsIgnoreCase("Start / Stop")) {
            if (client == null || !client.getIsRunning()) {
                client = new Client(ClientConstants.CHANNELS);
                client.start();
            } else if (client.getIsRunning()) {
                try {
                    client.stop();
                    client = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
