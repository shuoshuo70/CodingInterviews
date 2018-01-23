/**
 * Created by shuoshu on 2018/1/23.
 */
public class Interview36 {
    public static void main(String[] args) {
        Interview36 solution = new Interview36();
        int[] nums = {1, 5, 3,2, 6};
        System.out.println(solution.inversePair(nums));
    }

    int count = 0;
    public int inversePair(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] L = new int[mid - l + 1], R = new int[r - mid];

        for (int i = l; i <= mid; i++) {
            L[i - l] = nums[i];
        }

        for (int i = mid + 1; i <= r; i++) {
            R[i - mid - 1] = nums[i];
        }

        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                count += L.length - i;
                nums[k++] = R[j++];
            }
        }

        while (i < L.length) {
            nums[k++] = L[i++];
        }

        while (j < R.length) {
            nums[k++] = R[j++];
        }
    }
}
