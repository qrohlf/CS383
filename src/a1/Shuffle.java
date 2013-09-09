package a1;

import static edu.princeton.cs.introcs.StdOut.*;
import static edu.princeton.cs.introcs.StdRandom.*;

public class Shuffle {

	// From p. 32
	public static void shuffle(double[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = i + uniform(N - i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

}
