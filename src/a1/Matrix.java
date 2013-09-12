package a1;

public class Matrix {

	public static double dot(double[] x, double[] y) {
		if (x.length != y.length) return -1; //lazy coding, should be an exception
		// rows into columns, bro
		double z = 0;
		for (int i = 0; i < x.length; i++) {
			z += x[i]*y[i];
		}
		return z;
	}

	public static double[][] mult(double[][] a, double[][] b) {
		double[][] j = transpose(b);
		double[][] z = new double[a.length][j.length];
		for (int row=0; row < a.length; row++) {
			for (int col=0; col < j.length; col++) {
				z[row][col] = dot(a[row], j[col]);
			}
		}
		return z;
	}

	public static double[][] transpose(double[][] a) {
		double[][] b = new double[a[0].length][a.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}

	public static double[] mult(double[][] a, double[] x) {
		double[] z = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			z[i] = dot(a[i], x);
		}
		return z;
	}

	public static double[] mult(double[] x, double[][] b) {
		return mult(transpose(b), x);
	}
    
    
}