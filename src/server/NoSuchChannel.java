package server;

public class NoSuchChannel extends Exception {

	public NoSuchChannel(String msg) {
		super(msg);
		ServerConsole.getInstance().print(msg);

	}
}