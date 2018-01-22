/**
 * Created by shuoshu on 2018/1/22.
 */
public class Interview34 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] ugly = new int[n];
        int factor2 = 0, factor3 = 0, factor5 = 0, num2 = 1, num3 = 1, num5 = 1;

        for (int i = 0; i < n; i++) {
            ugly[i] = Math.min(num2, Math.min(num3, num5));

            if (ugly[i] == num2) {
                num2 = ugly[factor2++] * 2;
            }
            if (ugly[i] == num3) {
                num3 = ugly[factor3++] * 3;
            }
            if (ugly[i] == num5) {
                num5 = ugly[factor5++] * 5;
            }
        }

        return ugly[n - 1];
    }
}
