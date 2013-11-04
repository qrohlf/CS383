package a6;

import org.junit.Test;

import static edu.princeton.cs.introcs.StdDraw.*;

/**
 * These "tests" don't actually include any assertions; they just cause the
 * drawings to be made so that they can be visually inspected.
 */
public class A6Test {

	@Test
	public void testSpaceDisagreement() {
		SpaceDisagreement map = new SpaceDisagreement(100);
		map.draw();
		show(5000);
	}

	@Test
	public void testAnimatedPrim() {
		new AnimatedPrim();
	}

}
