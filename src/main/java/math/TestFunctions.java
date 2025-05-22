package math;

public class TestFunctions {
    static final double PI = 3.14159265358979323846;

    public static double sin(double x) {
        x = (x + PI) % PI * 2;
        for (int i = 0; i < TestTables.SIN_IN.length; i++) {
            if (x < TestTables.SIN_IN[i]) return TestTables.SIN_OUT[i];
        }
        return TestTables.SIN_OUT[TestTables.SIN_OUT.length - 1];
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
        boolean invert = false;
        if (x <= 0) return -1; // idk throw something
        if (x < 0.5) {
            invert = true;
            x = 1 / x;
        }
        for (int i = 0; i < TestTables.LN_IN.length; i++) {
            if (x < TestTables.LN_IN[i])
                return (invert ? -TestTables.LN_OUT[i] : TestTables.LN_OUT[i]);
        }
        return (invert ? -TestTables.LN_OUT[TestTables.LN_OUT.length] : TestTables.LN_OUT[TestTables.LN_OUT.length]);
    }

    public static double log(double l, double x) {
        return ln(x) / ln(l);
    }
}
