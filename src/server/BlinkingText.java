package server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @SER516 Project2_Team03
 * @Version 1.0
 */
public class BlinkingText extends JLabel {
	private static final long serialVersionUID = 1L;		//Provides a version ID to the class.
	private static final int BLINKING_RATE = 1000;
	
	/**
	 * Starts a thread which displays the blinking text.
	 */
	public void start(){
		super.setText("Server Is Running");
		Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
	    timer.setInitialDelay(0);
	    timer.start();
	}
	
	/**
	 * Stops the thread.
	 */
	public void stop(){
		super.setText("");
	}
	
	/**
	 * Working of the thread class.
	 *
	 */
	private class TimerListener implements ActionListener {
		    private BlinkingText text;
		    private boolean isForeground = true;
		    
		    public TimerListener(BlinkingText text) {
		      this.text = text;
		    }
		 
		    public void actionPerformed(ActionEvent e) {
		        if (isForeground) {
		          text.setForeground(Color.BLACK);
		        }
		        else {
		          text.setForeground(Color.WHITE);
		        }
		        isForeground = !isForeground;
		    }
	}
}
