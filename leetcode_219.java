import java.util.HashSet;
import java.util.Set;

public class leetcode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return false;
        }
        // if(k > len-1){
        // return false;
        // }
        // Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right;
        for (right = 0; right < len && right <= k; right++) {
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
        }

        while (right < len) {
            set.remove(nums[left++]);
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right++]);
        }
        return false;
    }
}
