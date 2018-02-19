package server;

import java.util.HashMap;

public class NumberService {

	private int serial;
	private HashMap<Integer, Channel> channels;

	public NumberService() {
		this.channels = new HashMap<Integer, Channel>();
		this.serial = 0;
		for (int i = 0; i < 5; i++) {
			this.newChannel(ServerConstants.DEFAULT_MIN, ServerConstants.DEFAULT_MAX);
		}
	}

	public synchronized int getNumber(int channelID) throws NoSuchChannel {
		Channel chan = this.channels.get(new Integer(channelID));
		if (chan == null) {
			throw new NoSuchChannel();
		}
		return chan.next();
	}

	// newChannel persists a new channel with the given min/max and returns
	// the handle to the new channel.
	public synchronized int newChannel(int min, int max) {
		this.serial++;
		this.channels.put(new Integer(this.serial), new Channel(min, max));
		return this.serial;
	}

}
