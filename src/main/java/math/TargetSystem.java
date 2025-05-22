package math;

import static math.BaseFunctions.*;

public class TargetSystem {
    private static final double DELTA = 0.00001;
    private static BaseFunctions baseF = new BaseFunctions();

    public static double calculate(double x) {
        if (x <= 0) {
            return calcBelowZero(x);
        } else {
            return calcAboveZero(x);
        }

    }

    private static double calcBelowZero(double x) {
        double t = baseF.csc(x) / baseF.sec(x);
        t = t * t * t * baseF.sin(x);
        return t - (baseF.sec(x) * baseF.sec(x)) + baseF.csc(x);
    }

    private static double calcAboveZero(double x) {
        double t = baseF.ln(x);
        t = t * t * t;
        t = t * t;
        t = t + baseF.log(2, x) - (baseF.log(5, x) - baseF.log(10, x));
        if (Math.abs(baseF.log(2, x)) >= DELTA)
            return t * baseF.log(5, x) / baseF.log(2, x);
        else throw new IllegalArgumentException();
    }
}
