package math;

import static math.BaseFunctions.*;

public class TargetSystem {
    public static double calculate(double x) {
        if (x <= 0) {
            return calcBelowZero(x);
        } else {
            return calcAboveZero(x);
        }

    }

    private static double calcBelowZero(double x) {
        double t = csc(x) / sec(x);
        t = t * t * t * sin(x);
        return t - (sec(x) * sec(x)) + csc(x);
    }

    private static double calcAboveZero(double x) {
        double t = ln(x);
        t = t * t * t;
        t = t * t;
        t = t + log(2, x) - (log(5, x) - log(10, x));
        return t * log(5, x) / log(2, x);

    }
}
