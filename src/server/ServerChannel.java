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

	public synchronized int GetMin() {
		return this.min;
	}

	public synchronized int GetMax() {
		return this.max;
	}

	public synchronized void SetMin(int min) {
		this.min = min;
	}

	public synchronized void SetMax(int max) {
		this.max = max;
	}

	public synchronized int Next() {
		return this.rand.nextInt(this.max - this.min + 1) + this.min;
	}

}