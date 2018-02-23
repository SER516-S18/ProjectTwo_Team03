package server;

import javax.swing.JTextPane;

import utility.Console;

/**
* Class used for logging to the server's
* GUI console.
*/
public class ServerConsole extends Console{

    /**
    * Private constructor for purpose of the singleton pattern.
    */
    private ServerConsole() {}

    /**
    * getInstance returns the singleton ServerConsole object
    *
    * @return the singleton ServerConsole object
    */
    @Override
    public Console getInstance() {
        if (instance == null) {
            instance = new ServerConsole();
        }
        return instance;
    }

    
}
