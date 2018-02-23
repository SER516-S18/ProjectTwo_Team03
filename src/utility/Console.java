package utility;

/**
 * @SER516 Project2_Team03
 * @Version 4.0
 */

import javax.swing.JTextPane;

/**
* This class is used for logging messages to the 
* GUI console.
*/
public  class Console {

    protected JTextPane consolePane;

    
    /**
    * Sets the GUI console text to the provided message.
    *
    * @param msg text to display in the GUI console.
    */
  
    public void print(String msg) {
        this.consolePane.setText("Console: " + msg);
    }

    /**
    * Setter for the target GUI element.
    *
    * @param consolePane the pane to which logged messages will appear.
    */
    
    public void setJtextPane(JTextPane consolePane) {
        this.consolePane = consolePane;
    }
}
