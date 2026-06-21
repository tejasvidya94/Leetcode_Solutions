public class leetcode_712 {
    public void mergeSort(int[] nums, int left, int right, int mid) {
        int[] arr = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int idx = 0;
        while (l <= mid && r <= right) {
            if (nums[l] > nums[r]) {
                arr[idx] = nums[r];
                r++;
            } else {
                arr[idx] = nums[l];
                l++;
            }
            idx++;
        }
        while (l <= mid) {

            arr[idx] = nums[l];
            l++;
            idx++;
        }
        while (r <= right) {

            arr[idx] = nums[r];
            r++;
            idx++;
        }

        for (int i = left; i <= right; i++) {
            nums[i] = arr[i - left];
        }
    }

    public void divide(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;

        divide(nums, left, mid);
        divide(nums, mid + 1, right);
        mergeSort(nums, left, right, mid);
        return;
    }

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }
}
