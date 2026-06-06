import java.util.HashMap;

public class leetcode_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seenDiff = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int val = nums[index];
            int diff = target - val;
            if (seenDiff.containsKey(diff)) {
                return new int[] { seenDiff.get(diff), index };
            }
            seenDiff.put(val, index);
        }
        return new int[] {};
    }
}
