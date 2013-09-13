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
	
	public static void badShuffle(double[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = uniform(N);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void testShuffle(int m, int n) {
		double[] a = new double[m];
		int[][] results = new int[m][m];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < n; i++) {
			shuffle(a);
			for (int j = 0; j < a.length; j++) {
				results[(int)a[j]][j]++;
			}
		}
		printResults(results);
	}

	private static void printResults(int[][] results) {
		int m = results.length;
		println("            # of times in position");
		println();
		printf("           ");
		for (int i = 0; i < m; i++) {printf("%-7d", i);}
		printf("\n         ");
		for (int i = 0; i < m*7; i++) {printf("-");}
		println();
		for (int i = 0; i < results.length; i++) {
			printf("%s%6d| ", (i==m/2)?"# ":"  ", i);
			for (int j = 0; j < results[i].length; j++) {
				printf("%-6d ", results[i][j]);
			}
			println();
		}
		
	}

	public static void testBadShuffle(int m, int n) {
		double[] a = new double[m];
		double[] b;
		int[][] results = new int[m][m];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < n; i++) {
			b = a.clone();
			badShuffle(b);
			for (int j = 0; j < b.length; j++) {
				results[(int)b[j]][j]++;
			}
		}
		printResults(results);
	}

}
