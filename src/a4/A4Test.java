package a4;
import edu.princeton.cs.algs4.Point2D;
import static edu.princeton.cs.introcs.StdDraw.*;
import static edu.princeton.cs.introcs.StdRandom.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class A4Test {
	
	private Double[] data;
	
	@Before
	public void setUp() throws Exception {
		data = new Double[100];
		for (int i = 0; i < data.length; i++) {
			data[i] = uniform();
		}
	}

	@Test
	public void testInsertionSort() {
		Insertion.sort(data);
	}

	@Test
	public void testSelectionSort() {
		Selection.sort(data);
	}

	@Test
	public void testTriplicates() {
		String[] a = {"Zoe", "Wash", "Mal", "Inara"};
		String[] b = {"Jayne", "Zoe", "Kaylee", "Simon"};
		String[] c = {"Mal", "River", "Book", "Zoe"};
		String[] d = {"Zoe", "Badger", "Mal", "Bester"};
		String[] e = {"Bridget", "Saffron", "Yolanda", "Niska"};
		assertEquals("Zoe", Triplicates.find(a, b, c));
		assertEquals("Mal", Triplicates.find(a, c, d));
		assertNull(Triplicates.find(a, b, e));
	}

	@Test
	public void testQuickWithCutoff() {
		Quick.sort(data, 5);
		for (int i = 0; i < data.length - 1; i++) {
			assertTrue(data[i] <= data[i+1]);
		}
	}

	@Test
	public void testInsert() {
		MaxPQ<Integer> priorityQueue = new MaxPQ<Integer>();
		// This test passes with the version of MaxPQ provided by the book
		// It should STILL pass after you have modified the class
		priorityQueue.insert(2);
		priorityQueue.insert(4);
		priorityQueue.insert(5);
		priorityQueue.insert(1);
		priorityQueue.insert(3);
		assertEquals(new Integer(5), priorityQueue.delMax());
		assertEquals(new Integer(4), priorityQueue.delMax());
		assertEquals(new Integer(3), priorityQueue.delMax());
		assertEquals(new Integer(2), priorityQueue.delMax());
		assertEquals(new Integer(1), priorityQueue.delMax());
		assertTrue(priorityQueue.isEmpty());
	}

	@Test
	public void testCaliforniaString() {
		CaliforniaString[] ballot = {
				new CaliforniaString("SCHWARTZENEGGER"),
				new CaliforniaString("BUSTAMANTE"),
				new CaliforniaString("MCCLINTOCK"),
				new CaliforniaString("CAMEJO"),
				new CaliforniaString("HUFFINGTON"),
				new CaliforniaString("UEBERROTH"),
				new CaliforniaString("FLYNT"),
				new CaliforniaString("COLEMAN"),
				new CaliforniaString("SCHWARTZMAN"),
				new CaliforniaString("CAREY"),
				new CaliforniaString("MARGOLIN"),
				new CaliforniaString("SIMON"),
				new CaliforniaString("VO")
		};
		Quick.sort(ballot);
		assertEquals("[MARGOLIN, MCCLINTOCK, VO, HUFFINGTON, BUSTAMANTE, SCHWARTZMAN, SCHWARTZENEGGER, SIMON, COLEMAN, CAREY, CAMEJO, UEBERROTH, FLYNT]", java.util.Arrays.toString(ballot));
	}
	
	@Test
	public void testDiamond() {
		Point2D[] corners = {
				new Point2D(0.0, 0.5),
				new Point2D(1.0, 0.5),
				new Point2D(0.5, 1.0),
				new Point2D(0.5, 0.0)
		};
		clear();
		new Polygon(corners).draw();
		show(1000);
	}

	@Test
	public void testHouse() {
		Point2D[] corners = {
				new Point2D(0.5, 1.0),
				new Point2D(0.0, 0.75),
				new Point2D(0.0, 0.0),
				new Point2D(1.0, 0.75),
				new Point2D(1.0, 0.0)
		};
		clear();
		new Polygon(corners).draw();
		show(1000);		
	}

}
