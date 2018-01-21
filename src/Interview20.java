/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview20 {
    public static void main(String[] args) {
        Interview20 solution = new Interview20();
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        solution.printMatrixClockwise(nums);
    }

    public void printMatrixClockwise(int[][] nums) {
        if (nums.length == 0 || nums[0].length == 0) {
            return;
        }

        int ms = 0, me = nums.length - 1, ns = 0, ne = nums[0].length - 1;

        while (ms <= me && ns <= ne) {
            for (int j = ns; ms <= me && ns <= ne && j <= ne; j++) {
                System.out.println(nums[ms][j]);
            }
            ms++;

            for (int i = ms; ms <= me && ns <= ne && i <= me; i++) {
                System.out.println(nums[i][ne]);
            }
            ne--;

            for (int j = ne; ms <= me && ns <= ne && j >= ns; j--) {
                System.out.println(nums[me][j]);
            }
            me--;

            for (int i = me; ms <= me && ns <= ne && i >= ms; i--) {
                System.out.println(nums[i][ns]);
            }
            ns++;
        }
    }
}
