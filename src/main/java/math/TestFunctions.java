package math;

public class TestFunctions {
    static final double PI = 3.14159265358979323846;

    private static final double DELTA = 0.00001;

    public double sin(double x) {
        //x = (x + PI) % (PI * 2);
        for (int i = 0; i < TestTables.SIN_IN.length; i++) {
            if (x == TestTables.SIN_IN[i]) return TestTables.SIN_OUT[i];
        }
        return TestTables.SIN_OUT[TestTables.SIN_OUT.length - 1];
    }

    public double cos(double x) {
        return sin(PI / 2 - x);
    }

    public double csc(double x) {
        if (Math.abs(sin(x)) >= DELTA) return 1 / sin(x); else throw new IllegalArgumentException();
    }

    public double sec(double x) {
        if (Math.abs(cos(x)) >= DELTA)  return 1 / cos(x);  else throw new IllegalArgumentException();
    }

    public double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException();
        for (int i = 0; i < TestTables.LN_IN.length; i++) {
            if (x == TestTables.LN_IN[i])
                return TestTables.LN_OUT[i];
        }
        return TestTables.LN_OUT[TestTables.LN_OUT.length - 1];
    }

    public double log(double l, double x) {
        return ln(x) / ln(l);
    }
}
