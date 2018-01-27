/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview43 {
    public static void main(String[] args) {
        Interview43 solution = new Interview43();
        solution.printProbability(2);
    }

    public void printProbability(int n) {
        if (n <= 0) {
            return;
        }

        int[][] dp = new int[n + 1][6 * n + 1];
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for (int sum = n; sum <= 6 * n; sum++) {
                for (int j = 1; sum - j >= 1 && j <= 6; j++) {
                    dp[k][sum] += dp[k - 1][sum - j];
                }
            }
        }

        double total = Math.pow(6, n);
        for (int sum = n; sum <= 6 * n; sum++) {
            System.out.println(sum + ": " + dp[n][sum] / total);
        }
    }
}
