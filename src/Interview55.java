import java.util.Arrays;

/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview55 {
    public char getChar(String s) {
        int[] dict = new int[256];
        Arrays.fill(dict, -1);


        for (int i = 0; i < s.length(); i++) {
            if (dict[s.charAt(i)] == -1) {
                dict[s.charAt(i)] = i;
            } else {
                dict[s.charAt(i)] = -2;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (dict[i] >= 0) {
                minIndex = Math.min(minIndex, dict[i]);
            }
        }

        return (char) minIndex;
    }
}
