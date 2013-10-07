package a3;

import static edu.princeton.cs.introcs.StdIn.*;
import static edu.princeton.cs.introcs.StdOut.*;

public class QuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    // instantiate N isolated components 0 through N-1
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // Modified for path compression
    // return root of component corresponding to element p
    public int find(int p) {
        int i = p;
        while (p != id[p])
            p = id[p];
        int root = p;
        int j;
        while (i != id[i]) {
        	j = i;
        	i = id[i];
        	id[j] = root;
        }
        return root;
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // merge components containing p and q
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j; 
        count--;
    }

    public static void main(String[] args) {
        int N = readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        // read in a sequence of pairs of integers (each in the range 0 to N-1),
        // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!isEmpty()) {
            int p = readInt();
            int q = readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            println(p + " " + q);
        }
        println("# components: " + uf.count());
    }

    // These getters added by Peter Drake for purposes of JUnit testing
	protected int[] getId() {
		return id;
	}

	protected int getCount() {
		return count;
	}

}
