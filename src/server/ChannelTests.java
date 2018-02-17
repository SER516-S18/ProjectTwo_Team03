import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ChannelTests {
	
	@Test
	public void testNew() {
		new Channel();
		new Channel(1, 2);
	}

	@Test
	public void testRandNormal() {
		int min = 1000;
		int max = 1050;
		Channel chan = new Channel(min, max);
		for (int i = 0; i < 1000; i++) {
			int n = chan.next();
			assertTrue(new Integer(n).toString(), n >= min && n <= max);
		}
	}

	@Test
	public void testRandSameMinMax() {
		int min = 1000;
		int max = 1000;
		Channel chan = new Channel(min, max);
		for (int i = 0; i < 1000; i++) {
			int n = chan.next();
			assertTrue(new Integer(n).toString(), n == min);
		}
	}

	@Test
	public void testRandWrongMinMax() {
		int min = 1000;
		int max = 999;
		Channel chan = new Channel(min, max);
		int n;
		try {
			n = chan.next();
		} catch (Exception e) {
			if (e instanceof java.lang.IllegalArgumentException) {
				return;
			}
			throw e;
		}
		assertTrue(new Integer(n).toString(), false);
	}
}