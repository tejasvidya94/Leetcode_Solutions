import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_90 {
    List<List<Integer>> ans = new ArrayList<>();

    public void recursion(int[] nums, int currIdx, List<Integer> list) {
        if (currIdx >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[currIdx]);
        recursion(nums, currIdx + 1, list);
        list.remove(list.size() - 1);

        int next = currIdx + 1;
        while (next > 0 && next < nums.length && nums[next] == nums[next - 1]) {
            next++;
        }

        recursion(nums, next, list);
        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursion(nums, 0, new ArrayList<Integer>());
        return ans;
    }
}
