import java.util.Stack;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview22 {
    public static void main(String[] args) {
        Interview22 solution = new Interview22();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 1, 0};
        System.out.println(solution.isValid(push, pop));
    }

    public boolean isValid(int[] push, int[] pop) {
        if (push.length != pop.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (j < pop.length) {
            while (stack.isEmpty() || (i < push.length && pop[j] != stack.peek())) {
                stack.push(push[i++]);
            }

            if (stack.peek() != pop[j]) {
                return false;
            }

            stack.pop();
            j++;
        }

        return stack.isEmpty();
    }
}
