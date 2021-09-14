public class Rational {

    private int numerator;
    private int denominator;


    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
	    return numerator;
    }

    public int getDenominator() {
	    return denominator;
    }

    public Rational plus(Rational other) {
        Rational sum = Rational.plus(this, other);
		numerator = sum.getNumerator();
		denominator = sum.getDenominator();
		return sum;
    }

    public static Rational plus(Rational a, Rational b) {
        int denominator = a.getDenominator() * b.getDenominator();
		int numerator = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
		return new Rational(numerator, denominator);
    }

    private void reduce() {
        if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		int gcd = gcd(numerator, denominator);
		numerator /= gcd;
		denominator /= gcd;
    }

    private int gcd(int a, int b) {
      a = Math.abs(a);
      while (a != b)
      if (a > b) a -= b;
      else b -= a;
      return a;
    }

    public int compareTo(Rational other) {
        double otherDouble = (double)other.getNumerator() / other.getDenominator();
		double difference = (double)numerator / denominator - otherDouble;
		if (difference > 0) {
			return 1;
		} else if (difference < 0) {
			return -1;
		} else {
			return 0;
		}
    }

    public boolean equals(Rational other) {
        return numerator == other.getNumerator() && denominator == other.getDenominator();
    }

    public String toString() {
    	if (denominator == 1) {
			return "" + numerator;
		} else {
			return String.format("%d/%d", numerator, denominator);
		}
    }
}