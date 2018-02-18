package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) {

		Server server = new Server(ServerConstants.PORT_NUMBER);
		server.startServer();
	}

	ServerSocket ServerService = null;
	Socket clientSocket = null;
	int port;
	BufferedReader in;
	PrintStream out;

	public Server(int port) {
		this.port = port;
	}

	public void stopServer() {
		System.out.println("Server cleaning up.");
		try {
			ServerService.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);
	}

	public void startServer() {

		try {
			ServerService = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("Server is ready...");

		while (true) {
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
				System.out.println(e);
			}
		}
	}
}
