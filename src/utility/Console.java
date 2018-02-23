package utility;

import javax.swing.JTextPane;

/**
* This class is used for logging messages to the 
* GUI console.
*/
public abstract class Console {

    JTextPane consolePane;
    private static Console instance = null;

    /*
    * getInstance returns the Console object
    *
    */
  public abstract Console getInstance();
        
    
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
