package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import server.ServerConstants;
import utility.Constants;

public class Client {
	public static void main(String[] args) {

		Socket clientSocket = null;
		DataOutputStream output = null;
		BufferedReader input = null;

		try {

			clientSocket = new Socket(Constants.HOSTNAME, ServerConstants.PORT_NUMBER);
			System.out.println("Connected");
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// sends output to the socket
			output = new DataOutputStream(clientSocket.getOutputStream());

		} catch (UnknownHostException e) {
			System.err.println("Unknown host: " + ClientConstants.HOSTNAME);
		} catch (IOException e) {
			System.err.println("Connection Exception " + ClientConstants.HOSTNAME);
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter S to start the client: ");
			String userInp = br.readLine();

			output.writeBytes(userInp + "\n");
			int n = Integer.parseInt(userInp);

			while (true) {
				if (n == 0 || n == -1) {
					break;
				}
				String responseLine = input.readLine();
				System.out.println(responseLine);
			}

			input.close();
			output.close();
			clientSocket.close();

		} catch (UnknownHostException e) {
			System.err.println("Trying to connect to unknown host: " + e);
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}

	}

	public void close() {

	}

}
