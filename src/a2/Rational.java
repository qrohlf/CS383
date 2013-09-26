package a2;

public class Rational {
	final int numerator;
	final int denominator;

	public Rational(int i, int j) {
		if (j < 0) {
			i = -i;
			j = -j;
		}
		if (gcd(i, j) > 1) {
			int gcd = gcd(i, j);
			numerator = i/gcd;
			denominator = j/gcd;
			return;
		}
		numerator = i;
		denominator = j;
		// TODO Auto-generated constructor stub
	}

	public Rational plus(Rational t) {
		return new Rational(t.numerator*denominator + numerator*t.denominator,
							t.denominator*denominator);
	}

	public Rational minus(Rational t) {
		return this.plus(new Rational(-t.numerator, t.denominator));
	}

	public Rational times(Rational t) {
		return new Rational(t.numerator * numerator, t.denominator * denominator);
	}

	public Rational divides(Rational t) {
		return new Rational(t.denominator * numerator, t.numerator * denominator);
	}

	@Override
	public String toString() {
		return numerator+"/"+denominator;
	}

	//Auto-generated Eclipse equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}
	
	static int gcd(int p, int q) {
        if (q==0) return p;
        int r = p%q;
        return gcd(q, r);
    }
	

}
