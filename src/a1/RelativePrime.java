package a1;

public class RelativePrime {
    public static boolean[][] generateMatrix(int n) {
        boolean[][] matrix = null;
        return matrix;
    }
    
    /**
     * Compute the greatest common divisor of two 
     * nonnegative integers p and q. If q is 0, the 
     * answer is p. If not, divide p by q and take 
     * the remainder r. The answer is the greatest 
     * common divisor of q and r
     */
    static int gcd(int p, int q) {
        if (q==0) return p;
        int r = p%q;
        return gcd(q, r);
    }
    
}