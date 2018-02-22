package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

import server.ServerConstants;
import utility.Constants;

public class Client implements Runnable {

	private volatile Boolean isRunning = false;
	private volatile String channel;
	private SynchronousQueue<Boolean> shutdownSignal;
	private ConcurrentLinkedQueue<String> messageQueue;

	public Client() {
		this(new Integer(ClientConstants.CHANNELS));
	}

	public Client(Integer channel)  {
		this.channel = channel.toString() + "\n";
		this.shutdownSignal = new SynchronousQueue<Boolean>();
		this.messageQueue = new ConcurrentLinkedQueue<String>();
	}

	@Override
	public void run() {
		Socket client = null;
		BufferedReader input = null;
		DataOutputStream output = null;
		int retries = 0;
		String resp = null;
		try {
			client = new Socket(Constants.HOSTNAME, ServerConstants.PORT_NUMBER);
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			output = new DataOutputStream(client.getOutputStream());
		} catch (UnknownHostException e) {
			System.err.println("Unknown host: " + ClientConstants.HOSTNAME);
		} catch (IOException e) {
			System.err.println("Connection Exception " + ClientConstants.HOSTNAME + "error: " + e.toString());
		}
		this.isRunning = true;
		System.out.println("Connected");
		try {
			output.writeBytes(this.channel);
		} catch (Exception e) {
			System.err.println(e.toString());
			this.isRunning = false;
			return;
		}
		while (this.isRunning) {
			try {
				resp = input.readLine();
				if (resp.startsWith("ERROR")) {
					System.err.println(resp);
					retries++;
					if (retries >= ClientConstants.MAX_RETRIES) {
						System.err.println("Exceeded max retry attempts. Stopped reattempts.");
						return;
					}
				}
			} catch (UnknownHostException e) {
				System.err.println("Trying to connect to unknown host: " + e);
				retries++;
				if (retries >= ClientConstants.MAX_RETRIES) {
					System.err.println("Exceeded max retry attempts. Stopped reattempts.");
					return;
				}
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
				retries++;
				if (retries >= ClientConstants.MAX_RETRIES) {
					System.err.println("Exceeded max retry attempts. Stopped reattempts.");
					return;
				}
			}
			System.out.println("Enqueuing: " + resp);
			this.messageQueue.add(resp);
			// Reset retries after successful exchange.
			retries = 0;
		}
		try {
			output.writeBytes("stop\n");
			client.close();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		try {
			this.shutdownSignal.put(new Boolean(true));	
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
	}

	public void start() {
		new Thread(this).start();
	}

	public void stop() throws IOException {
		this.isRunning = false;
		try {
			this.shutdownSignal.take();	
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		System.out.println("Shutdown of number request service complete.");
	}

	public void updateChannels(Integer channel) throws IOException {
		if (this.isRunning) {
			this.stop();	
		}
		this.channel = channel.toString() + "\n";
		this.start();
	}

	public boolean getIsRunning() {
		return this.isRunning;
	}

	public int[] next() {
		String message = this.messageQueue.poll();
		if (message == null) {
			return new int[0];
		}
		String[] messages = message.split(" ");
		int[] integers = new int[messages.length];
		for (int i = 0; i < messages.length; i++) {
			try {
				integers[i] = Integer.parseInt(messages[i]);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		return integers;
	}

}
