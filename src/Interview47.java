/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview47 {
    public static void main(String[] args) {
        Interview47 solution = new Interview47();
        System.out.println(solution.add(576, 4));
    }

    public int add(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        int sum = n1 ^ n2;
        int carry = (n1 & n2) << 1;

        return add(sum, carry);
    }
}
