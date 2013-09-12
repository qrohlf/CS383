package a1;

import edu.princeton.cs.introcs.StdDraw;
import java.lang.Math;

public class RandomConnections {

	/**
	 * Takes as arguments an integer n and a double
	 * p (between 0 and 1), plots N equally spaced dots
	 * of size .05 on the circumference of a circle, and 
	 * and then, with probability p for each pair of points
	 * draws a gray line connecting them
	 * @param n
	 * @param p
	 */
	public static void run(int n, double p) {
		double[][] dots = new double[n][2];
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.circle(.5, .5, .5);
		double offset = 2*Math.PI/n;
		for (int i = 0; i < n; i++) {
			dots[i][0] = Math.cos(offset*i)*.5+.5;
			dots[i][1] = Math.sin(offset*i)*.5+.5;
			StdDraw.filledCircle(dots[i][0], dots[i][1], 0.005);
		}
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int i = 0; i < dots.length; i++) {
			double[] theDot = dots[i];
			for (int j = 0; j < dots.length; j++) {
				if (Math.random() < p) StdDraw.line(theDot[0], theDot[1], dots[j][0], dots[j][1]);
			}
		}
		// TODO Auto-generated method stub
		
	}
    
}