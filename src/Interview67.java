/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview67 {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold <= 0) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        return dfs(0, 0, rows, cols, threshold, visited);
    }

    private int dfs(int i, int j, int rows, int cols, int threshold, boolean[][] visited) {
        int count = 0;
        if (!isValid(i, j, rows, cols, threshold)) {
            return count;
        }

        if (visited[i][j]) {
            return count;
        }

        visited[i][j] = true;
        count++;

        count += dfs(i + 1, j, rows, cols, threshold, visited) + dfs(i - 1, j, rows, cols, threshold, visited)
                + dfs(i, j + 1, rows, cols, threshold, visited) + dfs(i, j - 1, rows, cols, threshold, visited);

        visited[i][j] = false;

        return count;
    }

    private boolean isValid(int i, int j, int rows, int cols, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        int num = 0;
        while (i > 0) {
            num += i % 10;
            i /= 10;
        }
        while (j > 0) {
            num += j % 10;
            j /= 10;
        }

        return num <= threshold;
    }
}
