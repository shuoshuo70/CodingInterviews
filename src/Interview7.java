import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview7 {

}

class MyQueue<T> {
    Stack<T> stack1, stack2;
    T front;

    MyQueue() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void add(T val) {
        if (stack1.isEmpty()) {
            front = val;
        }
        stack1.push(val);
    }

    public T poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public T peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        return front;
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}


class MyStack<T> {
    Queue<T> q;

    MyStack() {
        q = new LinkedList<>();
    }

    public void push(T val) {
        int size = q.size();
        q.add(val);

        for (int i = 0; i < size; i++) {
            q.add(q.poll());
        }
    }

    public T pop() {
        return q.poll();
    }

    public T peek() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}