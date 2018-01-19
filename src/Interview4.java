/**
 * Created by shuoshu on 2018/1/19.
 */
public class Interview4 {
    public static void main(String[] args) {
        char[] ch = {'i', ' ', 'a', 'm', ' ', 'a', ' ', 'g', 'i', 'r', 'l',
                ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        Interview4 solution = new Interview4();
        solution.replaceBlank(ch, 11);

        for (char c : ch) {
            System.out.print(c + " ");
        }
    }

    public void replaceBlank(char[] ch, int n) {
        //count space
        int space = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == ' ') {
                space++;
            }
        }

        //calculate new length
        int newLen = n + space * 2;
        if (newLen > ch.length) {
            return;
        }

        //copy from right to left
        int j = newLen - 1, i = n - 1;
        while (j > i) {
            if (ch[i] != ' ') {
                ch[j--] = ch[i--];
            } else {
                ch[j--] = '0';
                ch[j--] = '2';
                ch[j--] = '%';
                i--;
            }
        }
    }
}
