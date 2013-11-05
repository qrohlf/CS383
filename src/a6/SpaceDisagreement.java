package a6;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

public class SpaceDisagreement {
	Graph g;
	double[][] coords;

	public SpaceDisagreement(int n) {
		
		g = new Graph(n);
		coords = new double[n][2];
		for (int i=0; i<n; i++) {
			coords[i][0] = StdRandom.uniform();
			coords[i][1] = StdRandom.uniform();
		}
		double x1, y1, x2, y2;
		for (int i=0; i<n; i++) {
			x1 = coords[i][0];
			y1 = coords[i][1];
			for(int j=0; j<n; j++) {
				x2 = coords[j][0];
				y2 = coords[j][1];
				if (connected(x1, y1, x2, y2)) {
					g.addEdge(i, j);
				}
			}
		}
	}

	private boolean connected(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) < 0.15;
	}

	public void draw() {
		StdDraw.clear();
		StdDraw.show(1); //Turn on animation mode
		Biconnected b = new Biconnected(g);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i=0; i<coords.length; i++) {
			for (int j : g.adj(i)) {
				StdDraw.line(coords[i][0], coords[i][1],coords[j][0], coords[j][1]);
			}
		}
		
		for (int i=0; i<coords.length; i++) {
			if (b.isArticulation(i)) StdDraw.setPenColor(StdDraw.RED);
			else StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(coords[i][0], coords[i][1], .01);
			
		}
		
	}

}
