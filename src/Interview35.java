/**
 * Created by shuoshu on 2018/1/23.
 */
public class Interview35 {
    public static void main(String[] args) {
        Interview35 solution = new Interview35();
        System.out.println(solution.firstNotRepeatingChar("abaccdeff"));
    }

    public char firstNotRepeatingChar(String s) {
        int[] counts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }

        return '0';
    }
}
