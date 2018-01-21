import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview28 {
    public static void main(String[] args) {
        Interview28 solution = new Interview28();
        List<String> res = solution.getCombinations2("abc");
        for (String s : res) {
            System.out.println(s);
        }
    }

    public List<String> getPermutation1(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }

        getPermutation1(s, new StringBuilder(), list);
        return list;
    }

    private void getPermutation1(String s, StringBuilder sb, List<String> list) {
        if (sb.length() == s.length()) {
            list.add(new String(sb));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf("" + s.charAt(i)) != -1) {
                continue;
            }
            sb.append(s.charAt(i));
            getPermutation1(s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> getCombinations1(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }

        for (int i = 1; i <= s.length(); i++) {
            getCombinations1(s, i, new StringBuilder(), list);
        }

        return list;
    }

    private void getCombinations1(String s, int len, StringBuilder sb, List<String> list) {
        if (0 == len) {
            list.add(new String(sb));
        }

        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf("" + s.charAt(i)) != -1) {
                continue;
            }
            sb.append(s.charAt(i));
            getCombinations1(s, len - 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> getCombinations2(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }

        for (int i = 1; i <= s.length(); i++) {
            getCombinations2(s, i, 0, new StringBuilder(), list);
        }

        return list;
    }

    private void getCombinations2(String s, int len, int start, StringBuilder sb, List<String> list) {
        if (0 == len) {
            list.add(new String(sb));
        }

        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            getCombinations2(s, len - 1, i + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
