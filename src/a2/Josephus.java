package a2;

import edu.princeton.cs.algs4.Queue;

public class Josephus {

	public static String run(int n, int m) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> items = new Queue<Integer>();
		for (int i = 0; i < n; i++) {
			items.enqueue(i);
		}
		int i = 0;
		while (items.size() > 0) {
			i++;
			if (i%m == 0) {
				sb.append(items.dequeue()+" ");
			} else {
				items.enqueue(items.dequeue());
			}
		}
		return sb.toString();
	}

}
