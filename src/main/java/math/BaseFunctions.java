package math;

public class BaseFunctions {
    static final double PI = 3.14159265358979323846;
    static final double LN2 = 0.6931471805599453;
    static double terms = 100;


    public static double sin(double x) {
        x = (x + PI) % PI * 2;
        double mid = x, sum = x;
        int f = 1;
        for (int i = 0; i < terms; i++) {
            f += 2;
            mid = -mid * x * x / f / (f - 1);
            sum += mid;
        }
        return sum;
    }

    public static double cos(double x) {
        return sin(PI / 2 - x);
    }

    public static double csc(double x) {
        return 1 / sin(x);
    }

    public static double sec(double x) {
        return 1 / cos(x);
    }

    public static double ln(double x) {
        if (x <= 0) return -1; // idk throw something
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
        return (2 * res) + k * LN2;
    }

    public static double log(double l, double x) {
        return ln(x) / ln(l);
    }

    public static void main(String[] args) {
        System.out.println("real ln(0.00001): " + Math.log(100000));
        System.out.println("our ln(0.00001): " + ln(100000));

    }
}
