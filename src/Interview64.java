import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview64 {
    public static void main(String[] args) {
        Interview64 solution = new Interview64();
        solution.add(40);
        System.out.println(solution.getMid());
        solution.add(1);
        System.out.println(solution.getMid());
        solution.add(2);
        System.out.println(solution.getMid());
        solution.add(5);
        System.out.println(solution.getMid());
    }

    PriorityQueue<Integer> min = new PriorityQueue<>(),
            max = new PriorityQueue<>(Collections.reverseOrder());

    public void add(int num) {
        if (((min.size() + max.size()) & 1) == 0) {
            if (!min.isEmpty() && min.peek() < num) {
                min.add(num);
                num = min.poll();
            }
            max.add(num);
        } else {
            if (!max.isEmpty() && max.peek() > num) {
                max.add(num);
                num = max.poll();
            }
            min.add(num);
        }
    }

    public int getMid() {
        if (((min.size() + max.size()) & 1) == 0) {
            return (min.peek() + max.peek()) / 2;
        } else {
            return max.peek();
        }
    }
}
