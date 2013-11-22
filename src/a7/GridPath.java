package a7;

public class GridPath {

	
	public static final boolean DOWN = true;
	public static final boolean RIGHT = false;
	private boolean[] path;

	public GridPath(int[][] grid) {
		path = new boolean[grid.length + grid[0].length];
		int rcost, dcost;
		int i, j;
		for (i=grid.length-1; i>=0; i--) {
			for (j=grid[0].length-1; j>=0; j--) {
				if (i == grid.length-1 && j == grid[0].length - 1) continue;
				rcost = Integer.MAX_VALUE;
				dcost = Integer.MAX_VALUE;
				if (j+1 < grid[0].length) rcost = grid[i][j+1];
				if (i+1 < grid.length) dcost = grid[i+1][j];
				grid[i][j] += (rcost < dcost) ? rcost : dcost;
			}
		}
		int n = i = j = 0;
		while (i < grid.length-1 || j < grid.length-1) {
			rcost = Integer.MAX_VALUE;
			dcost = Integer.MAX_VALUE;
			if (j+1 < grid[0].length) rcost = grid[i][j+1];
			if (i+1 < grid.length) dcost = grid[i+1][j];
			if (rcost < dcost) {
				j++;
				path[n] = RIGHT;
			} else {
				i++;
				path[n] = DOWN;
			}
			n++;
		}
	}

	public boolean path(int i) {
		return path[i];
	}
}
