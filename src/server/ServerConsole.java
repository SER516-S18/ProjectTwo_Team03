package server;

import javax.swing.JTextPane;

public class ServerConsole {

	JTextPane consolePane;
	private static ServerConsole instance = null;

	public ServerConsole() {

	}

	public static ServerConsole getInstance() {
		if (instance == null)
			instance = new ServerConsole();
		return instance;

	}

	public void print(String msg) {
		this.consolePane.setText("Console: " + msg);
	}

	public void setJtextPane(JTextPane consolePane) {
		this.consolePane = consolePane;
	}
}
