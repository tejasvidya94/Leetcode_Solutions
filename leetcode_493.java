class leetcode_493 {
    private void conquer(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    private int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > (long) 2 * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        return count;

    }

    private int divide(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = 0;

        count += divide(nums, left, mid);
        count += divide(nums, mid + 1, right);
        count += countPairs(nums, left, mid, right);

        conquer(nums, left, mid, right);

        return count;

    }

    public int reversePairs(int[] nums) {
        // merge sort is used inside this type of questions.
        if (nums.length == 0) {
            return 0;
        }

        return divide(nums, 0, nums.length - 1);
    }
}