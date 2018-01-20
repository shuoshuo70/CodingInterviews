/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview10 {
    public static void main(String[] args) {
        Interview10 solution = new Interview10();
        System.out.println(solution.numberOf1( -1 ));
    }

    public int numberOf1(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

}