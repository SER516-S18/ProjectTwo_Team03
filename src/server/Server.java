package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	ServerSocket ServerService = null;
	Socket clientSocket = null;
	int port;
	BufferedReader in;
	PrintStream out;
	boolean isStopped;
	Integer channels;
	NumberService numberService;

	public Server(int port) {
		this.port = port;
		this.numberService = new NumberService();
	}

	public void startServer() {
		int channel;
		int response;
		String request;
		try {
			ServerService = new ServerSocket(this.port);
		} catch (IOException e) {
			System.out.println(e);
		}
		ServerConsole.getInstance().print("Server is started");
		while (!hasStopped()) {
			try {
				clientSocket = ServerService.accept();
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintStream(clientSocket.getOutputStream());
				while ((request = in.readLine()) != null) {
					 if (request.contains("stop")) {
					 	out.println(request);
					 	ServerConsole.getInstance().print("Closing connection to client.");
					 	clientSocket.close();
						this.stop();
					} else if (request.contains("new")) {
						int id = this.numberService.newChannel(ServerConstants.DEFAULT_MIN, ServerConstants.DEFAULT_MAX);
						out.println(new Integer(id).toString());
					} else if (request.contains("channels")){
						channel = Integer.parseInt(request.split(":")[1]);
						ServerConsole.getInstance().print("received request for channel: "+ new Integer(channel).toString());
						try {
							response = this.numberService.getNumber(channel);
						} catch (NoSuchChannel e) {
							out.println("No such channeld: " + new Integer(channel).toString());
							continue;
						}
						out.println(new Integer(response).toString());
						ServerConsole.getInstance().print("Responded to request on channel " + new Integer(channel).toString() + " with value " + new Integer(response).toString());
					} else {
						ServerConsole.getInstance().print("Couldn't understand request: " + request);
					}
				}
			} catch (IOException e) {
				ServerConsole.getInstance().print(e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		startServer();

	}

	private synchronized boolean hasStopped() {
		return this.isStopped;
	}

	public synchronized void stop() {

		this.isStopped = true;
		try {
			ServerConsole.getInstance().print("Server is Stopped");
			this.ServerService.close();
		} catch (IOException e) {
			ServerConsole.getInstance().print(e.getMessage());			
		}
	}

	public static Server createServerThread() {
		Server server = new Server(ServerConstants.PORT_NUMBER);
		new Thread(server).start();
		return server;

	}

}
