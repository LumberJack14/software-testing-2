package math;

public class BaseFunctions {
    static final double PI = 3.14159265358979323846;

    static double sin(double x) {
        double mid = x, sum = x;
        int f = 1;
        for (int i = 0; i < 100; i++) {
            f += 2;
            mid = -mid * x * x / f / (f - 1);
            sum += mid;
        }
        return sum;
    }

    static double cos(double x) {
        return sin(PI / 2 - x);
    }

    static double csc(double x) {
        return 1 / sin(x);
    }

    static double sec(double x) {
        return 1 / cos(x);
    }

    static double ln(double x) {
        if (x <= 0) return -1; // idk throw something
        double y = (x - 1) / (x + 1);
        double y2 = y * y, res = 0, pow = y;
        for (int n = 0; n < 100; ++n) {
            res += pow / (2 * n + 1);
            pow *= y2;
        }
        return 2 * res;
    }

    static double log(double l, double x) {
        return ln(x) / ln(l);
    }

    public static void main(String[] args) {
        System.out.println("real ln(0.00001): " + Math.log(0.00001));
        System.out.println("our ln(0.00001): " + ln(0.00001));

    }
}
