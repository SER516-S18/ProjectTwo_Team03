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

	public Server(int port) {
		this.port = port;
	}

	public void startServer() {

		try {
			ServerService = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println(e);
		}
		ServerConsole.getInstance().print("Server is started");
		while (hasStopped()) {
			try {
				clientSocket = ServerService.accept();
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintStream(clientSocket.getOutputStream());
				String line;
				while ((line = in.readLine()) != null) {

					out.println(line);
					System.out.println(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
				ServerConsole.getInstance().print(e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		startServer();

	}

	public synchronized void stop() {

		this.isStopped = true;
		try {
			ServerConsole.getInstance().print("Server is Stopped");
			this.ServerService.close();
		} catch (IOException e) {
			ServerConsole.getInstance().print(e.getMessage());
			e.printStackTrace();
		}
	}

	public static Server createServerThread() {
		Server server = new Server(ServerConstants.PORT_NUMBER);
		new Thread(server).start();
		return server;

	}

}
