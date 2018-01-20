/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview9 {
    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        int f1 = 0, f2 = 1, f3 = 1;

        for (int i = 2; i <=  n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2= f3;
        }

        return f3;
    }
}
