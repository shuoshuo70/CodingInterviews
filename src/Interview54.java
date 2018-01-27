/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview54 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.trim();
        boolean isNumber = false;
        int exp = -1, doc = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i == s.length() - 1 || i != exp + 1) {
                    return false;
                }
            }

            else if (s.charAt(i) == '.') {
                if (doc != -1 || exp != -1) {
                    return false;
                }
                doc = i;
            }

            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (i == s.length() - 1 || exp != -1 || !isNumber) {
                    return false;
                }
                exp = i;
            }

            else if (Character.isDigit(s.charAt(i))) {
                isNumber = true;
            }

            else {
                return false;
            }
        }

        return isNumber;
    }
}
