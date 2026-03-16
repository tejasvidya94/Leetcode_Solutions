import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void recursion(int i, int[] arr, List<Integer> temp, int sum){
        // if array is empty.
        if(i == arr.length){
            return;
        }
        // if current sum == 0;
        if(sum == 0){
            // note : Do not pass the reference to actual object. pass copy of the list.
            result.add(new ArrayList<>(temp));
            return;
        }
        // if sum is negative;
        if(sum < 0){
            return;
        }
        // do not include current val;
        recursion(i+1, arr, temp,sum);
        // include current val;
        temp.add(arr[i]);
        sum = sum - arr[i];
        recursion(i, arr, temp, sum);
        // note : do not miss to remove previously added elemnt after recursion ( in the backtracking step. )
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] arr, int sum) {
        List<Integer> temp = new ArrayList<>();
        recursion(0,arr,temp,sum);
        return result;
    }
}