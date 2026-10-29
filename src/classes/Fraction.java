package classes;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0!");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction simplify() {
        int gcd = gcd(Math.abs(numerator), denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction sum(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator
        ).simplify();
    }

    public Fraction minus(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator
        ).simplify();
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        ).simplify();
    }

    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Fraction(
                this.numerator * other.denominator,
                this.denominator * other.numerator
        ).simplify();
    }

    public Fraction sum(int n) { return sum(new Fraction(n, 1)); }
    public Fraction minus(int n) { return minus(new Fraction(n, 1)); }
    public Fraction multiply(int n) { return multiply(new Fraction(n, 1)); }
    public Fraction div(int n) { return div(new Fraction(n, 1)); }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}