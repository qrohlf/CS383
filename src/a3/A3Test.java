package a3;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class A3Test {

	private TwoStackQueue<String> q;
	
	private QuickUnionUF cluster;
	
	@Before
	public void setUp() throws Exception {
		q = new TwoStackQueue<String>();
		cluster = new QuickUnionUF(6);
	}

	@Test
	public void testEnqueue() {
		assertTrue(q.isEmpty());
		q.enqueue("foo");
		assertFalse(q.isEmpty());
	}

	@Test
	public void testDequeue() {
		q.enqueue("a");
		q.enqueue("b");
		assertEquals("a", q.dequeue());
		q.enqueue("c");
		q.enqueue("d");
		assertEquals("b", q.dequeue());
		assertEquals("c", q.dequeue());
		assertFalse(q.isEmpty());
		assertEquals("d", q.dequeue());
		assertTrue(q.isEmpty());
	}

	@Test
	public void testPathCompression() {
		assertTrue(Arrays.equals(new int[] {0, 1, 2, 3, 4, 5}, cluster.getId()));
		cluster.union(0, 1);
		assertTrue(Arrays.equals(new int[] {1, 1, 2, 3, 4, 5}, cluster.getId()));
		cluster.union(1, 2);
		assertTrue(Arrays.equals(new int[] {1, 2, 2, 3, 4, 5}, cluster.getId()));
		cluster.union(2, 3);
		assertTrue(Arrays.equals(new int[] {1, 2, 3, 3, 4, 5}, cluster.getId()));
		cluster.union(5, 4);
		assertTrue(Arrays.equals(new int[] {1, 2, 3, 3, 4, 4}, cluster.getId()));
		cluster.union(5, 0);
		assertArrayEquals(new int[] {3, 3, 3, 3, 3, 4}, cluster.getId());
	}

}
