/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview49 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        int i = 0;
        boolean flag = false;

        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            flag = true;
        }

        double sum = 0.0;
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                sum = sum * 10 + str.charAt(i) - '0';
            }
        }

        if (flag) {
            sum = -sum;
            if (sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int) sum;
    }
}
