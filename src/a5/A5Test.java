package a5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class A5Test {

	public static final double EPSILON = 0.0000001;
	
	private SMatrix a;
	
	private SMatrix b;
	
	private BloomFilter<String> filter;
	
	@Before
	public void setUp() throws Exception {
		a = new SMatrix();
		a.put(5, 5, 2.0);
		a.put(5, 999999999, 3.0);
		a.put(999999999, 999999999, 4.0);
		b = new SMatrix();
		b.put(5, 999999999, 5.0);
		b.put(999999999, 999999999, 6.0);
		filter = new BloomFilter<String>();
	}

	@Test
	public void testLevelOrder() {
		BST<String, Integer> tree = new BST<String, Integer>();
		tree.put("one", 1);
		tree.put("two", 2);
		tree.put("three", 3);
		tree.put("four", 4);
		tree.put("five", 5);
		tree.put("six", 6);
		tree.put("seven", 7);
		tree.put("eight", 8);
		tree.put("nine", 9);
		tree.put("ten", 10);
		assertEquals("one:1 four:4 two:2 five:5 nine:9 three:3 eight:8 six:6 seven:7 ten:10 ", tree.toStringLevelOrder());
	}

	@Test
	public void testGet() {
		assertEquals(2.0, a.get(5, 5), EPSILON);
		assertEquals(3.0, a.get(5, 999999999), EPSILON);
		assertEquals(0.0, a.get(999999999, 5), EPSILON);
		assertEquals(4.0, a.get(999999999, 999999999), EPSILON);
	}

	@Test
	public void testPlus() {
		SMatrix c = a.plus(b);
		assertEquals(2.0, c.get(5, 5), EPSILON);
		assertEquals(8.0, c.get(5, 999999999), EPSILON);
		assertEquals(0.0, c.get(999999999, 5), EPSILON);
		assertEquals(10.0, c.get(999999999, 999999999), EPSILON);
	}

	@Test
	public void testTimes() {
		SMatrix c = a.times(b);
		assertEquals(0.0, c.get(5, 5), EPSILON);
		assertEquals(28.0, c.get(5, 999999999), EPSILON);
		assertEquals(0.0, c.get(999999999, 5), EPSILON);
		assertEquals(24.0, c.get(999999999, 999999999), EPSILON);
	}
	
	@Test
	public void testHash() {
		assertEquals(106, filter.hash("example", 0));
		assertEquals(17, filter.hash("example", 1));
		assertEquals(37, filter.hash("example", 2));
		assertEquals(177, filter.hash("example", 3));
	}
	
	@Test
	public void testAdd() {
		assertFalse(filter.contains("something"));
		filter.add("something");
		assertTrue(filter.contains("something"));
		assertFalse(filter.contains("nothing"));
	}

	@Test
	public void testFalsePositive() {
		assertFalse(filter.contains("collision"));
		filter.add("unlimbers");
		assertFalse(filter.contains("collision"));
		filter.add("salivators");
		assertTrue(filter.contains("collision"));		
	}
	
	@Test
	public void testTranspose() {
		SMatrix a = new SMatrix();
		// [1 2]    [1 3]
		// [3 4] -> [2 4]
		a.put(0, 0, 1);
		a.put(0, 1, 2);
		a.put(1, 0, 3);
		a.put(1, 1, 4);
		SMatrix b = a.transpose();
		assertEquals(1, b.get(0, 0), EPSILON);
		assertEquals(3, b.get(0, 1), EPSILON);
		assertEquals(2, b.get(1, 0), EPSILON);
		assertEquals(4, b.get(1, 1), EPSILON);
	}

}
