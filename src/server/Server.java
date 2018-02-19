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

	public Server(int port) {
		this.port = port;
	}

	public void startServer() {

		try {
			ServerService = new ServerSocket(this.port);
		} catch (IOException e) {
			System.out.println(e);
		}
		ServerConsole.getInstance().print("Server is started");
		while (hasStopped()==false) {
			try {
				clientSocket = ServerService.accept();
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintStream(clientSocket.getOutputStream());
				String line;
				while ((line = in.readLine()) != null) {
					 if(line.contains("stop")==true){
						this.stop();

					}else if(line.contains("channels")==true){
						this.channels=Integer.parseInt(line.split(":")[1]);

					}
					out.println(line);
					System.out.println(line);
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
