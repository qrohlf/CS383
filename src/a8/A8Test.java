package a8;

import static edu.princeton.cs.introcs.StdRandom.*;
import static a8.RabinKarp2D.*;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class A8Test {

	private RabinKarp2D matcher;
	
	/** Limerick source: unknown. */
	public static final char[][] LIMERICK = asCharArray(new String[] {
			"There was a young man from Japan",
			"whose poetry rhymed but didn't scan.",
			"He said, I don't know why",
			"it's just that I try",
			"to put as many syllables on the last line as I possibly can."});
	
	/** Converts strings into a two-dimensional array of chars. */
	public static char[][] asCharArray(String[] strings) {
		char[][] result = new char[strings.length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = strings[i].toCharArray();
		}
		return result;
	}

	@Test
	public void testFactors() {
		char[][] pattern = new char[20][20];
		matcher = new RabinKarp2D(pattern);
		long[] factors = matcher.getFactors();
		assertEquals(39, factors.length);
		assertEquals(1, factors[0]);
		for (int i = 1; i < factors.length; i++) {
			assertEquals(factors[i], (factors[i - 1] * RADIX) % MODULUS);
		}
	}

	@Test
	public void testHash1() {
		char[][] pattern = new char[2][2];
		matcher = new RabinKarp2D(pattern);
		assertEquals(0, matcher.hash(pattern));
	}

	@Test
	public void testHash2() {
		char[][] pattern = {{1, 2, 3}, {4, 5, 6}};
		matcher = new RabinKarp2D(pattern);
		long correct = 1 * 256 * 256 * 256
				     + 2 * 256 * 256
				     + 3 * 256
				     + 4 * 256 * 256
				     + 5 * 256
				     + 6;
		assertEquals(correct, matcher.hash(pattern));
	}

	@Test
	public void testHash3() {
		matcher = new RabinKarp2D(new char[3][8]);
		assertEquals(634001566, matcher.hash(LIMERICK));
	}

	@Test
	public void testCheck() {
		char[][] pattern = asCharArray(new String[] {
				"sai",
				"s j"});
		matcher = new RabinKarp2D(pattern);
		assertTrue(matcher.check(LIMERICK, 2, 3));
		assertFalse(matcher.check(LIMERICK, 2, 5));
	}
	
	@Test
	public void testEasyUpperLeft() {
		char[][] pattern = asCharArray(new String[] {
				"ab",
				"fg"});
		char[][] text = asCharArray(new String[] {
				"abcde",
				"fghij",
				"klmno",
				"pqrst"});
		matcher = new RabinKarp2D(pattern);
		assertEquals("[0, 0]", Arrays.toString(matcher.search(text)));
	}
	
	@Test
	public void testEasyTopRow() {
		char[][] pattern = asCharArray(new String[] {
				"de",
				"ij"});
		char[][] text = asCharArray(new String[] {
				"abcde",
				"fghij",
				"klmno",
				"pqrst"});
		matcher = new RabinKarp2D(pattern);
		assertEquals("[0, 3]", Arrays.toString(matcher.search(text)));
	}
	
	@Test
	public void testEasyLeftColumn() {
		char[][] pattern = asCharArray(new String[] {
				"fg",
				"kl"});
		char[][] text = asCharArray(new String[] {
				"abcde",
				"fghij",
				"klmno",
				"pqrst"});
		matcher = new RabinKarp2D(pattern);
		assertEquals("[1, 0]", Arrays.toString(matcher.search(text)));
	}
	
	@Test
	public void testEasyGeneral() {
		char[][] pattern = asCharArray(new String[] {
				"hi",
				"mn"});
		char[][] text = asCharArray(new String[] {
				"abcde",
				"fghij",
				"klmno",
				"pqrst"});
		matcher = new RabinKarp2D(pattern);
		assertEquals("[1, 2]", Arrays.toString(matcher.search(text)));
	}
	
	@Test
	public void testMedium() {
		char[][] pattern = new char[10][10];
		char[][] text = new char[100][100];
		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < text[0].length; j++) {
				text[i][j] = (char)(uniform(26) + 'a');
			}
		}
		int r = uniform(text.length - pattern.length + 1);
		int c = uniform(text[0].length - pattern[0].length + 1);
		// Include a character not found anywhere else in the text
		// to ensure a unique match
		text[r][c] = (char)(uniform(26) + 'A');
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[0].length; j++) {
				pattern[i][j] = text[i + r][j + c];
			}
		}
		matcher = new RabinKarp2D(pattern);
		assertEquals("[" + r + ", " + c + "]", Arrays.toString(matcher.search(text)));
	}

	@Test
	public void testHard() {
		char[][] pattern = new char[100][100];
		char[][] text = new char[1000][1000];
		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < text[0].length; j++) {
				text[i][j] = (char)(uniform(26) + 'a');
			}
		}
		int r = uniform(text.length - pattern.length + 1);
		int c = uniform(text[0].length - pattern[0].length + 1);
		// Include a character not found anywhere else in the text
		// to ensure a unique match
		text[r][c] = (char)(uniform(26) + 'A');
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[0].length; j++) {
				pattern[i][j] = text[i + r][j + c];
			}
		}
		matcher = new RabinKarp2D(pattern);
		assertEquals("[" + r + ", " + c + "]", Arrays.toString(matcher.search(text)));
	}


}
