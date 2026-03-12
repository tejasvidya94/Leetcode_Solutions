class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0 || chars.length == 1) {
            return chars.length;
        }
        int charIdx = 0;
        int count = 1;
        int i = 1;
        while (i < chars.length) {
            if (chars[i] != chars[charIdx]) {
                if (count == 1) {
                    charIdx++;
                    chars[charIdx] = chars[i];
                } else {
                    if (count < 10) {
                        chars[charIdx + 1] = (char) (count + '0');
                        charIdx = charIdx + 2;
                        chars[charIdx] = chars[i];
                        count = 1;

                    } else {
                        charIdx++;
                        String value = Integer.toString(count);
                        for (char c : value.toCharArray()) {
                            chars[charIdx] = c;
                            charIdx += 1;
                        }
                        chars[charIdx] = chars[i];
                        count = 1;
                    }
                }
            } else {
                count++;
            }
            i++;
        }
        if (count != 1) {
            charIdx++;
            String value = Integer.toString(count);
            for (char c : value.toCharArray()) {
                chars[charIdx] = c;
                charIdx += 1;
            }
        } else {
            charIdx++;
        }
        return charIdx;
    }
}