package a3;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.*;
import edu.princeton.cs.introcs.Stopwatch;

public class DoublingRatio
{
	public static void main(String[] args) {
		final int N_START = 1000;
		final int N_STEP = 1000;
		final int MAX_N = 20000;
		final int NUM_TRIALS = 1000;
		double resizingArrayStackTime;
		double linkedListStackTime;
		double ratioTotal = 0;
		System.out.printf("Note that all times given are the total from "+NUM_TRIALS+" trials \n");
		System.out.printf("\n");
		System.out.printf("     N | ResizingArray time |  LinkedList time | ratio (linkedlist/resizing) \n");
		System.out.printf("-----------------------------------------------------------------------------\n");
		for (int N=N_START; N<=MAX_N; N+=N_STEP) {
			resizingArrayStackTime=0;
			linkedListStackTime=0;
			for (int i=0; i<NUM_TRIALS; i++) {
				LinkedListStack<Integer> llStack = new LinkedListStack<Integer>();
				ResizingArrayStack<Integer> raStack = new ResizingArrayStack<Integer>();
				resizingArrayStackTime += timeTrial(raStack, N);
				linkedListStackTime += timeTrial(llStack, N);
			}
			double ratio = linkedListStackTime/resizingArrayStackTime;
			ratioTotal += ratio;
			System.out.printf(" %5d | %18.3f | %16.3f | %.3f \n", N, resizingArrayStackTime, linkedListStackTime, ratio);
		}
		int num_tests = (MAX_N-N_START)/N_STEP+1;
		double ratioavg = ratioTotal/(double)num_tests;
		System.out.printf("\n\nSummary:\n");
		System.out.printf("%d values tested from N=%d to N=%d in increments of %d, with %d trials per test.\n", num_tests, N_START, MAX_N, N_STEP, NUM_TRIALS);
		System.out.printf("ResizingArrayStack was %.2f times %s than LinkedListStack (average of all values tested)", ratioavg, (ratioavg>1)?"faster":"slower");
	}
	
	
	//Time how long it takes to push N items to the stack and pop N items from the stack
	public static double timeTrial(Stack<Integer> s, int N) {  
	      Stopwatch timer = new Stopwatch();
	     for (int i=0; i<N; i++) {
	    	 s.push(i);
	     }
	     for (int i=0; i<N; i++) {
	    	 s.pop();
	     }
	      return timer.elapsedTime();
	}
}
