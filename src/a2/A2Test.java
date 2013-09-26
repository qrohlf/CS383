package a2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class A2Test {

	private Rational twoThirds;
	
	private Rational threeQuarters;
	
	private Rational half;
	
	private Steque<Integer> steque;
	
	@Before
	public void setUp() throws Exception {
		twoThirds = new Rational(2, 3);
		threeQuarters = new Rational(3, 4);
		half = new Rational(1, 2);
		steque = new Steque<Integer>();
	}

	// Tests for Rational
	
	@Test
	public void testToString() {
		assertEquals("1/2", half.toString());
	}

	@Test
	public void testEquals() {
		assertEquals(new Rational(2, 3), new Rational(2, 3));
		assertFalse(new Rational(2, 3).equals(new Rational(3, 4)));
	}
	
	@Test
	public void testNegatives() {
		assertEquals("1/2", new Rational(1, 2).toString());
		assertEquals("-1/2", new Rational(-1, 2).toString());
		assertEquals("-1/2", new Rational(1, -2).toString());
		assertEquals("1/2", new Rational(-1, -2).toString());
	}

	@Test
	public void testLowestTerms() {
		assertEquals(half, new Rational(5, 10));
	}

	@Test
	public void testPlus() {
		assertEquals(new Rational(17, 12), twoThirds.plus(threeQuarters));
	}

	@Test
	public void testMinus() {
		assertEquals(new Rational(1, 12), threeQuarters.minus(twoThirds));
	}

	@Test
	public void testTimes() {
		assertEquals(new Rational(1, 2), twoThirds.times(threeQuarters));
	}

	@Test
	public void testDivides() {
		assertEquals(new Rational(8, 9), twoThirds.divides(threeQuarters));
	}

	// Tests for Steque
	
	@Test
	public void testPush() {
		assertTrue(steque.isEmpty());
		assertEquals("", steque.toString());
		steque.push(1);
		assertFalse(steque.isEmpty());
		steque.push(2);
		assertEquals("2 1 ", steque.toString());
	}

	@Test
	public void testPop() {
		steque.push(1);
		steque.push(2);
		steque.push(3);
		assertEquals("3 2 1 ", steque.toString());
		assertEquals(new Integer(3), steque.pop());
		assertEquals("2 1 ", steque.toString());
		assertFalse(steque.isEmpty());
		assertEquals(new Integer(2), steque.pop());
		assertEquals(new Integer(1), steque.pop());
		assertTrue(steque.isEmpty());
	}
	
	@Test
	public void testEnqueue() {
		steque.enqueue(1);
		steque.enqueue(2);
		steque.enqueue(3);
		assertEquals("1 2 3 ", steque.toString());
	}
	
	@Test
	public void testCatenate() {
		steque.enqueue(1);
		steque.enqueue(2);
		steque.enqueue(3);
		Steque<Integer> other = new Steque<Integer>();
		other.enqueue(4);
		other.enqueue(5);
		other.enqueue(6);
		steque.catenate(other);
		assertEquals("1 2 3 4 5 6 ", steque.toString());
	}
	
	// Tests for Josephus
	
	@Test
	public void testJosephus() {
		assertEquals("1 3 5 0 4 2 6 ", Josephus.run(7, 2));
	}
	
	
}
