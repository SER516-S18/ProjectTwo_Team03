package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.net.Socket;
import java.net.UnknownHostException;

import server.ServerConstants;
import utility.Constants;

public class Client {
	Socket clientSocket = null;
	DataOutputStream output = null;
	BufferedReader input = null;
	Boolean isRunning=false;

	public static void main(String[] args) {

		Client client =new Client();

		client.start(2);
	}

	public void start(Integer channels){

		try {
			isRunning=true;
			clientSocket = new Socket(Constants.HOSTNAME, ServerConstants.PORT_NUMBER);
			System.out.println("Connected");
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			// sends output to the socket
			output = new DataOutputStream(clientSocket.getOutputStream());

		} catch (UnknownHostException e) {
			System.err.println("Unknown host: " + ClientConstants.HOSTNAME);
		} catch (IOException e) {
			System.err.println("Connection Exception " + ClientConstants.HOSTNAME + "error: " + e.toString());
		}

		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//			System.out.print("Enter S to start the client: ");
//			String userInp = br.readLine();

//			output.writeBytes(userInp + "\n");

			// request strings are space delimited structures.
			// 	channel frequency min max
			// For example, a channel of 4, with a frequency of 3 seconds and min of 100
			// and max of 2000 is
			// 	4 3 100 2000
			//
			// Responses are space delimited lists of numbers. So if the channel 5,
			// you may receive:
			//
			// 46 72 3 18 110
			StringBuilder request = new StringBuilder();
			request.append(channels.toString()).append(" ") // channel
					.append("2").append(" ") // frequency
					.append("0").append(" ") // min
					.append("100").append(" ") // max
					.append("\n"); // required newline
			output.writeBytes(request.toString());

			System.out.println(input.readLine());
			System.out.println(input.readLine());
			System.out.println(input.readLine());
			System.out.println("etc....you know what to do now.");
			output.writeBytes("stop\n");

////			int n = Integer.parseInt(userInp);
//			int n = Integer.parseInt(channels.toString());
//
//			while (true) {
//				if (n == 0 || n == -1) {
//					break;
//				}
//				String responseLine = input.readLine();
//				System.out.println(responseLine);
//			}




		} catch (UnknownHostException e) {
			System.err.println("Trying to connect to unknown host: " + e);
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}

	}

	public void updateChannels(Integer channels) throws IOException {

		output.writeBytes("channels:"+ channels.toString() + "\n");

//		int n = Integer.parseInt(channels.toString());
//
//		while (true) {
//			if (n == 0 || n == -1) {
//				break;
//			}
//			String responseLine = input.readLine();
//			System.out.println(responseLine);
//		}


	}


	public void stop() throws IOException {
		isRunning=false;
		input.close();
		output.close();
		clientSocket.close();

	}

}
