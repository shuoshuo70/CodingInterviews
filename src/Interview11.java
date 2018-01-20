/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview11 {
    public double pow(double base, int exponent) {
        if (Math.abs(base - 0) < 10e-6) {
            return 0;
        }

        if (exponent == 0) {
            return 1;
        }

        if (exponent == Integer.MIN_VALUE) {
            return pow (1.0 / base, - (exponent + 1)) / base;
        }

        if (exponent < 0) {
            return pow(1.0 / base, -exponent);
        }

        double part = pow(base, exponent >> 1);
        if ((exponent & 1) == 0) {
            return part * part;
        }

        return part * part * base;
    }
}
