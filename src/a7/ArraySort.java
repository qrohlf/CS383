package a7;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class ArraySort {
    private static final int CUTOFF =  15;   // cutoff to insertion sort
    
    // sort the array a[] of strings
    public static void sort(int[][] a) {
        // StdRandom.shuffle(a);
        sort(a, 0, a.length-1, 0);
        //assert isSorted(a);
    }


    private static void sort(int[][] a, int lo, int hi, int d) { 
    	if(hi <= lo) return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if      (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }
    
    private static int charAt(int[] s, int d) {
        if (d >= s.length) return -1;
        return s[d];
    }

    // exchange a[i] and a[j]
    private static void exch(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}