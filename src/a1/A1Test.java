package a1;

import edu.princeton.cs.introcs.*;

import static org.junit.Assert.*;
import org.junit.Test;
import static java.util.Arrays.*;

public class A1Test {

	/**
	 * Two doubles within EPSILON of each other are considered equal for these
	 * tests.
	 */
	public static final double EPSILON = 0.0000001;

	@Test
	public void testRelativePrime() {
		boolean[][] a = RelativePrime.generateMatrix(7);
		assertTrue(deepEquals(new boolean[][] {
				{ false, true, false, false, false, false, false },
				{ true, true, true, true, true, true, true },
				{ false, true, false, true, false, true, false },
				{ false, true, true, false, true, true, false },
				{ false, true, false, true, false, true, false },
				{ false, true, true, true, true, false, true },
				{ false, true, false, false, false, true, false } }, a));
	}

	@Test
	public void testRandomConnections() {
		// This is graphical and inspected visually
		RandomConnections.run(17, 0.25);
		StdDraw.show(2000); // Pause for 2 seconds
	}

	@Test
	public void testDot() {
		double[] x = { 1.0, 2.0, 3.0 };
		double[] y = { 1.0, 0.5, 2.5 };
		assertEquals(9.5, Matrix.dot(x, y), EPSILON);
	}

	@Test
	public void testMatrixMatrixMult() {
		double[][] a = { { 3, -1, 4 }, { 1, 0, 2 } };
		double[][] b = { { 1, 2 }, { 0, -3 }, { 2, 1 } };
		double[][] ab = { { 11, 13 }, { 5, 4 } };
		double[][] ba = { { 5, -1, 8 }, { -3, 0, -6 }, { 7, -2, 10 } };
		assertTrue(deepEquals(ab, Matrix.mult(a, b)));
		assertTrue(deepEquals(ba, Matrix.mult(b, a)));
	}

	@Test
	public void testTranspose() {
		double[][] a = { { 3, -1, 4 }, { 1, 0, 2 } };
		double[][] aT = { { 3, 1 }, { -1, 0 }, { 4, 2 } };
		assertTrue(deepEquals(aT, Matrix.transpose(a)));
	}

	@Test
	public void testMatrixVectorMult() {
		double[][] a = { { 3, -1, 4 }, { 1, 0, 2 } };
		double[] x = { 1.0, 2.0, 3.0 };
		double[] ax = { 13, 7 };
		assertTrue(java.util.Arrays.equals(ax, Matrix.mult(a, x)));
	}

	@Test
	public void testVectorMatrixMult() {
		double[] x = { 1.0, 2.0, 3.0 };
		double[][] b = { { 1, 2 }, { 0, -3 }, { 2, 1 } };
		double[] xb = { 7, -1 };
		assertTrue(java.util.Arrays.equals(xb, Matrix.mult(x, b)));
	}

	@Test
	public void testShuffle() {
		StdOut.println("Good shuffle:");
		Shuffle.testShuffle(10, 100000);
	}

	@Test
	public void testBadShuffle() {
		StdOut.println("Bad shuffle:");
		Shuffle.testBadShuffle(10, 100000);
	}

}
