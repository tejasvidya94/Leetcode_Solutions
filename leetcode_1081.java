import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode_1081 {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        boolean[] isPresent = new boolean[26];
        Arrays.fill(isPresent, false);
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (isPresent[s.charAt(i) - 'a']) {
                continue;
            }
            while (!st.isEmpty() && st.peek() > s.charAt(i) && lastIdx[st.peek() - 'a'] > i) {
                isPresent[st.peek() - 'a'] = false;
                st.pop();
            }
            char ch = s.charAt(i);

            st.push(ch);
            isPresent[ch - 'a'] = true;
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;

    }
}
