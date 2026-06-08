public class leetcode_1392 {
    public String longestPrefix(String s) {
        int length = s.length();
        int[] lps = new int[length];
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < length) {
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        // use lps for comparism
        return s.substring(0, lps[length - 1]);
    }
}