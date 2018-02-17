import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ServerChannelTests {
	
	@Test
	public void testNew() {
		new ServerChannel();
		new ServerChannel(1, 2);
	}

	@Test
	public void testRandNormal() {
		int min = 1000;
		int max = 1050;
		ServerChannel chan = new ServerChannel(min, max);
		for (int i = 0; i < 1000; i++) {
			int n = chan.Next();
			assertTrue(new Integer(n).toString(), n >= min && n <= max);
		}
	}

	@Test
	public void testRandSameMinMax() {
		int min = 1000;
		int max = 1000;
		ServerChannel chan = new ServerChannel(min, max);
		for (int i = 0; i < 1000; i++) {
			int n = chan.Next();
			assertTrue(new Integer(n).toString(), n == min);
		}
	}

	@Test
	public void testRandWrongMinMax() {
		int min = 1000;
		int max = 999;
		ServerChannel chan = new ServerChannel(min, max);
		int n;
		try {
			n = chan.Next();
		} catch (Exception e) {
			if (e instanceof java.lang.IllegalArgumentException) {
				return;
			}
			throw e;
		}
		assertTrue(new Integer(n).toString(), false);
	}
}