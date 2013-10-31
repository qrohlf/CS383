package a5;

import edu.princeton.cs.algs4.ST;

public class SMatrix {

	private ST<Integer, ST<Integer, Double>> matrix = new ST<Integer, ST<Integer, Double>>();
	
	public void put(int i, int j, double d) {
		if (get(i, j) == d) return;
		ST<Integer, Double> row = matrix.get(i);
		if (row != null) row.put(j, d);
		else {
			row = new ST<Integer, Double>();
			row.put(j, d);
			matrix.put(i, row);
		}
	}

	public double get(int i, int j) {
		try {
			return matrix.get(i).get(j);
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public SMatrix plus(SMatrix that) {
		SMatrix result = new SMatrix();
		//For each row in this matrix do stuff
		for (Integer row : this.matrix) {
			if (that.matrix.get(row) == null) {
				result.matrix.put(row, this.matrix.get(row));
			} else {
				result.matrix.put(row, add_rows(this.matrix.get(row), that.matrix.get(row)));
			}
		}
		
		for (Integer row : that.matrix) {
			if (result.matrix.get(row) != null) continue; //don't do work that's already been done.
			result.matrix.put(row, add_rows(this.matrix.get(row), that.matrix.get(row)));
		}
		return result;
	}
	
	private static ST<Integer, Double> add_rows(ST<Integer, Double> a, ST<Integer, Double> b) {
		ST<Integer, Double> c = new ST<Integer, Double>();
		for (Integer col : a) {
			if (b.get(col) == null) c.put(col, a.get(col));
			else c.put(col, a.get(col) + b.get(col));
		}
		for (Integer col : b) {
			if (c.get(col) != null) continue; //don't do work that's already been done.
			c.put(col, b.get(col));
		}
		return c;
	}
	
	private static ST<Integer, Double> mult_rows(ST<Integer, Double> a, ST<Integer, Double> b) {
		ST<Integer, Double> c = new ST<Integer, Double>();
		for (Integer col : a) {
			if (b.get(col) == null) continue;
			else c.put(col, a.get(col) * b.get(col));
		}
		return c;
	}

	public SMatrix times(SMatrix that) {
		SMatrix result = new SMatrix();
		ST<Integer, ST<Integer, Double>> that_t = that.transpose().matrix;
		//For each row in this matrix do stuff
		for (Integer i : this.matrix) {
			// rows of this multiplied by cols of that
			for (Integer j : that_t) {
				result.put(i, j, dot_rows(this.matrix.get(i), that_t.get(j)));
			}
		}
		return result;
	}
	
	private double dot_rows(ST<Integer, Double> a, ST<Integer, Double> b) {
		double sum = 0;
		double x;
		for (Integer i : a) {
			if (b.get(i) != null) {
				sum += a.get(i) * b.get(i);
			}
		}
		return sum;
	}

	public SMatrix transpose() {
		SMatrix result = new SMatrix();
		for (Integer i : this.matrix) {
			for (Integer j : this.matrix.get(i)) {
				result.put(j, i, this.get(i, j));
			}
		}
		return result;
	}

}
