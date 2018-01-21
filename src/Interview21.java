import java.util.Stack;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview21 {

}

class MinStack {
    Stack<Integer> stack, min;

    MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(Integer x) {
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
        stack.push(x);
    }

    public Integer pop() {
        Integer val = stack.pop();

        if (val == min.peek()) {
            min.pop();
        }

        return val;
    }

    public int getMin() {
        return min.peek();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
