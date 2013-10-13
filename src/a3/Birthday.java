package a3;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdRandom;

public class Birthday {

	public static void main(String[] args) {
		final int num_trials = 10000; //Number of trials for each n
		final int max_n = 1000; //Largest number of n to test
		final int n_step = 10;
		for (int N=0; N<=max_n; N+=n_step) {
			int total = 0;
			for (int i=0; i<num_trials; i++) {
				total += generate(N);
			}
			//System.out.println("average location of first repeated value for N="+N+" was "+total/(double)num_trials+". Ã(¹"+N+"/2)="+Math.sqrt(Math.PI*N/2.0));
			System.out.println(N+"\t"+total/(double)num_trials+"\t"+Math.sqrt(Math.PI*N/2.0));
		}
	}

	/**
	 * Generate a sequence of integers a_n where 0 < a_n < N
	 * @return the index (n) of the first repeated value
	 */
	private static int generate(int N) {
		List<Integer> seq = new ArrayList<Integer>();
		int j;
		for (int n=0; n<N; n++) {
			j = StdRandom.uniform(N);
			if (seq.contains(j)) return n;
			seq.add(j);
		}
		return N;
	}
}
