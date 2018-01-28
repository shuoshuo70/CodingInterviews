/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview66 {
    public static void main(String[] args) {
        Interview66 solution = new Interview66();
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(solution.canReach(matrix, "bce"));
    }

    public boolean canReach(char[][] matrix, String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(matrix, i, j, s, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, String s, int index, boolean[][] visited) {
        if (index == s.length()) {
            return true;
        }

        if (!isValid(matrix, i, j) || visited[i][j] || matrix[i][j] != s.charAt(index)) {
            return false;
        }

        boolean flag = false;
        visited[i][j] = true;

        flag = dfs(matrix, i + 1, j, s, index + 1, visited) || dfs(matrix, i - 1, j, s, index + 1, visited)
                || dfs(matrix, i, j + 1, s, index + 1, visited) || dfs(matrix, i, j - 1, s, index + 1, visited);

        visited[i][j] = false;

        return flag;
    }

    private boolean isValid(char[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
