/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview42 {
    public static void main(String[] args) {
        Interview42 solution = new Interview42();
        System.out.println(solution.reverseWords("abcd"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int j = i;
            while (j < ch.length && ch[j] != ' ') {
                j++;
            }
            swap(ch, i, j - 1);
            i = j;
        }

        return new String(ch);
    }

    private void swap(char[] ch, int i, int j) {
        while(i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}
