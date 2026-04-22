import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_40 {
    public void recursion(int[] arr, int target, int i, List<List<Integer>> ans, List<Integer> comb) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        ;
        if (i == arr.length)
            return;
        if (arr[i] > target)
            return;

        // include
        comb.add(arr[i]);
        recursion(arr, target - arr[i], i + 1, ans, comb);
        // skip duplicate
        while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
            i++;
        }
        // exclude
        comb.remove(comb.size() - 1); // remove last;
        recursion(arr, target, i + 1, ans, comb);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        recursion(candidates, target, 0, ans, comb);
        return ans;
    }
}