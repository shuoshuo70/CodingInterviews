/**
 * Created by shuoshu on 2018/1/22.
 */
public class Interview32 {
    public static void main(String[] args) {
        Interview32 solution = new Interview32();
        System.out.println(solution.countOne(3418));
    }

    public int countOne(int n) {
        int count = 0, factor = 1;

        while (n / factor > 0) {
            int cur = n / factor % 10, high = n / factor / 10, low = n - n / factor * factor;
            if (cur == 1) {
                count += high * factor + low + 1;
            } else if (cur > 1) {
                count += (high + 1) * factor;
            } else {
                count += high * factor;
            }

            factor *= 10;
        }

        return count;
    }
}