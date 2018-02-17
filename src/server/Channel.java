import java.util.Random;

public class Channel {

	private int min;
	private int max;
	private Random rand;

	public Channel() {
		this.rand = new Random();
	}

	public Channel(int min, int max) {
		this();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return this.min;
	}

	public int getMax() {
		return this.max;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int next() {
		return this.rand.nextInt(this.max - this.min + 1) + this.min;
	}

}