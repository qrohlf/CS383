package a6;

import static edu.princeton.cs.introcs.StdDraw.show;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;

public class AnimatedPrim {
	EdgeWeightedGraph g;
	public static final int n = 100;
	double[][] coords = new double[n][2];
	
	public AnimatedPrim() {
		g = new EdgeWeightedGraph(n);
		for (int i=0; i<n; i++) {
			coords[i][0] = StdRandom.uniform();
			coords[i][1] = StdRandom.uniform();
		}
		double x1, y1, x2, y2, distance;
		for (int i=0; i<n; i++) {
			x1 = coords[i][0];
			y1 = coords[i][1];
			for(int j=0; j<n; j++) {
				x2 = coords[j][0];
				y2 = coords[j][1];
				distance = distance(x1, y1, x2, y2);
				if (distance < .15) {
					g.addEdge(new Edge(i, j, distance));
				}
			}
		}
		draw(); //Render the initial map
		animate(); //Animate Prim's Algorithm
		show(5000); //Pause for 5s when animation is complete
	}
	
	private void animate() {
		AnimatedPrimMST p = new AnimatedPrimMST(g, coords);
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	// Render the initial graph
	public void draw() {
		StdDraw.clear();
		StdDraw.show(1); //Turn on animation mode
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int i=0; i<coords.length; i++) {
			for (Edge j : g.adj(i)) {
				StdDraw.line(coords[i][0], coords[i][1],coords[j.other(i)][0], coords[j.other(i)][1]);
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i=0; i<coords.length; i++) {
			StdDraw.filledCircle(coords[i][0], coords[i][1], .01);
			
		}
		
	}

}
