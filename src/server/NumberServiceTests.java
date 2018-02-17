import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class NumberServiceTests {

	@Test
	public void testNew() {
		new NumberService();
	}

	@Test
	public void testCreateChannel() {
		NumberService ns = new NumberService();
		int min = 1000;
		int max = 1050;
		int handle = ns.newChannel(min, max);
		int n = 0;
		try {
			n = ns.getNumber(handle);
		} catch (Exception e) {
			assertTrue(e.toString(), false);
		}
		assertTrue(new Integer(n).toString(), n >= min && n <= max);
	}

	@Test
	public void testMissingChannel() {
		NumberService ns = new NumberService();
		try {
			ns.getNumber(1);
		} catch (Exception e) {
			if (e instanceof NoSuchChannel) {
				return;
			}
			assertTrue(e.toString(), false);
		}
		assertTrue("Failed to raise NoSuchChannel exception", false);
	}
}