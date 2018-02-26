package bt.torrent.messaging;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssignmentsTest {
	@Test
	public void testAssign() {
		Assignments as = new Assignments(null, null, null, null);
		
		
		as.assign(null);
		
	}
	
	@Test
	public void testUpdate() {
		Assignments as = new Assignments(null, null, null, null);
		
		as.update(null, null);
	}
}
