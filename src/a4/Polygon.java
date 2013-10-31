package a4;

import java.util.Arrays;
import java.util.Collections;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.introcs.StdDraw;

public class Polygon {
	private Point2D[] vertices;

	public Polygon(Point2D[] vertices) {
		this.vertices = vertices;
	}

	public void draw() {
		StdDraw.setXscale();
		StdDraw.setYscale();
		Point2D minY = Collections.min(Arrays.asList(vertices), Point2D.Y_ORDER);
		Arrays.sort(vertices, minY.POLAR_ORDER);
		Point2D p1;
		Point2D p2;
		for (int i=0; i<vertices.length; i++) {
			p1 = vertices[i];
			p2 = vertices[(i+1)%vertices.length];
			StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
		}
	}

}
