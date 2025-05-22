package math;

public class BaseFunctions {
    static final double PI = 3.14159265358979323846;
    static final double LN2 = 0.6931471805599453;
    static double terms = 100;
    private static final double DELTA = 0.00001;


    public double sin(double x) {
        //x = (x + PI) % (PI * 2);
        double mid = x, sum = x;
        int f = 1;
        for (int i = 0; i < terms; i++) {
            f += 2;
            mid = -mid * x * x / f / (f - 1);
            sum += mid;
        }
        return sum;
    }

    public double cos(double x) {
        return sin(PI / 2 - x);
    }

    public double csc(double x) {
        if (Math.abs(sin(x)) >= DELTA) return 1 / sin(x);
        else throw new IllegalArgumentException();
    }

    public double sec(double x) {
        if (Math.abs(cos(x)) >= DELTA) return 1 / cos(x);
        else throw new IllegalArgumentException();
    }

    public double ln(double x) {
        boolean invert = false;
        if (x <= 0) throw new IllegalArgumentException();
        if (x < 0.5) {
            invert = true;
            x = 1.0 / x;
        }
        int k = 0;
        double rx = x;
        while (rx >= 1.5) {
            rx /= 2;
            k++;
        }
        double y = (rx - 1) / (rx + 1);
        double y2 = y * y, res = 0, pow = y;
        for (int n = 0; n < terms; ++n) {
            res += pow / (2 * n + 1);
            pow *= y2;
        }
        return (invert ? -(2 * res) - k * LN2 : (2 * res) + k * LN2);
    }

    public double log(double l, double x) {
        return ln(x) / ln(l);
    }
}
