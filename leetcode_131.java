import java.util.ArrayList;
import java.util.List;

class leetcode_131 {
    public boolean isPalindrom(StringBuilder sb) {
        int l = 0;
        int r = sb.length() - 1;
        while (l <= r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void recursion(String s, int i, List<List<String>> ans, List<String> list, StringBuilder sb) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        sb.append(s.charAt(i));
        if (isPalindrom(sb)) {
            list.add(new String(sb));
            // empty sb here.
            recursion(s, i + 1, ans, list, new StringBuilder());
            list.remove(list.size() - 1);
        }
        if (i + 1 == s.length()) {
            list = new ArrayList<>();
            return;
        }
        recursion(s, i + 1, ans, list, sb);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recursion(s, 0, ans, list, sb);
        return ans;
    }
}