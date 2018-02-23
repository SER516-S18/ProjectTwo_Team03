/**
 * 
 */
package client;

import server.ServerConsole;
import utility.Console;

/**
* Class used for logging to the client's
* GUI console.
*/
public class ClientConsole extends Console{

	@Override
	public Console getInstance() {
        if (instance == null) {
            instance = new ClientConsole();
        }
        return instance;
    }
	

}
