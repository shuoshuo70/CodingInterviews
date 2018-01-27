import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview45 {
    public static void main(String[] args) {
        Interview45 solution = new Interview45();
        int n = 500, m = 5;
        System.out.println(solution.lastNumberInCircle(n, m));
        System.out.println(solution.LastRemaining(n, m));
    }

    public int lastNumberInCircle(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index += m - 1;
            index = index % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    int LastRemaining(int n,int m){
        if(n<1||m<1) return -1;
        int last=0;
        for(int i=2;i<=n;i++)
            last=(last+m)%i;
        return last;
    }
}
