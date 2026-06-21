import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    List<List<Integer>> ans = new ArrayList<>();

    public void recursion(int[] nums, int currIdx, List<Integer> list) {
        if (currIdx >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[currIdx]);
        recursion(nums, currIdx + 1, list);
        list.remove(list.size() - 1);
        recursion(nums, currIdx + 1, list);
        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        recursion(nums, 0, new ArrayList<Integer>());
        return ans;
    }
}
