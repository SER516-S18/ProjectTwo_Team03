
package client;

/**
 * @SER516 Project2_Team03
 * @Version 3.0
 */
import utility.Console;

/**
* Class used for logging to the client's
* GUI console.
*/
public class ClientConsole extends Console
{
  private static ClientConsole instance = null;

    /*
    * getInstance returns the ClientConsole object
    *
    */

	public ClientConsole getInstance() {
        if (instance == null) {
            instance = new ClientConsole();
        }
        return instance;
    }
	
}

