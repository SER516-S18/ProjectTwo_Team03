package server;

/**
 * @SER516 Project2_Team03
 * @Version 3.0
 */

import utility.Console;

/**
* Class used for logging to the server's
* GUI console.
*/
public class ServerConsole extends Console
{
   private static ServerConsole instance = null;

    /*
    * getInstance returns the ServerConsole object
    *
    */
    
    public static ServerConsole getInstance() {
        if (instance == null) {
            instance = new ServerConsole();
        }
        return instance;
    }
    
}
