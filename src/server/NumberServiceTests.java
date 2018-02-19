package server;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberServiceTests {

	@Test
	public void testNew() {
		new NumberService();
	}

	@Test
	public void testCreateChannel() throws Exception {
		NumberService ns = new NumberService();
		int min = 1000;
		int max = 1050;
		int handle = ns.newChannel(min, max);
		int n = 0;
		try {
			n = ns.getNumber(handle);
		} catch (Exception e) {
			throw e;
		}
		assertTrue(new Integer(n).toString(), n >= min && n <= max);
	}

	@Test
	public void testMissingChannel() throws Exception {
		NumberService ns = new NumberService();
		try {
			ns.getNumber(1);
		} catch (Exception e) {
			if (e instanceof NoSuchChannel) {
				return;
			}
			throw e;
		}
		assertTrue("Failed to raise NoSuchChannel exception", false);
	}
}