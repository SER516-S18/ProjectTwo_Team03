import java.util.Random;

public class ServerChannel {

	private int min;
	private int max;
	private Random rand;

	public ServerChannel() {
		this.rand = new Random();
	}

	public ServerChannel(int min, int max) {
		this();
		this.min = min;
		this.max = max;
	}

}