import java.util.HashMap;
import java.util.Map;

public class leetcode_3843 {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int value : freq.values()) {
            freqCount.put(value, freqCount.getOrDefault(value, 0) + 1);
        }

        for (int elem : nums) {
            if (freqCount.get(freq.get(elem)) == 1) {
                return elem;
            }
        }
        return -1;
    }
}
