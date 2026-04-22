import java.util.ArrayList;
import java.util.List;

class leetcode_131 {
    public boolean isPalindrom(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void recursion(String s, List<List<String>> ans, List<String> partitions) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(partitions));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrom(s.substring(0, i + 1))) {
                partitions.add(s.substring(0, i + 1));
                recursion(s.substring(i + 1), ans, partitions);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        recursion(s, ans, partitions);
        return ans;
    }
}