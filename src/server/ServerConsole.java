package server;

import javax.swing.JTextPane;

/**
* Global singleton used for logging to the server's
* GUI console.
*/
public class ServerConsole {

    JTextPane consolePane;
    private static ServerConsole instance = null;

    /**
    * Prviate constructor for purposeso of the singleton pattern.
    */
    private ServerConsole() {}

    /**
    * getInstance returns the singleton ServerConsole object
    *
    * @return the singleton ServerConsole object
    */
    public static ServerConsole getInstance() {
        if (instance == null) {
            instance = new ServerConsole();
        }
        return instance;
    }

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
