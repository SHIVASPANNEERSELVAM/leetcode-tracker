// Last updated: 7/9/2026, 10:06:11 AM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getLength(int[] nums) {
        int[] dremovical = nums;
        int n = dremovical.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> countOfFreq = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int val = dremovical[j];
                int oldFreq = freq.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;

                freq.put(val, newFreq);

                if (oldFreq > 0) {
                    countOfFreq.put(oldFreq, countOfFreq.get(oldFreq) - 1);
                    if (countOfFreq.get(oldFreq) == 0) {
                        countOfFreq.remove(oldFreq);
                    }
                }
                countOfFreq.put(newFreq, countOfFreq.getOrDefault(newFreq, 0) + 1);

                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                }

                // If all elements have the exact same frequency, it's only valid 
                // if there is exactly 1 unique element type (e.g., [5, 5, 5])
                if (countOfFreq.size() == 1) {
                    if (freq.size() == 1) {
                        ans = Math.max(ans, j - i + 1);
                    }
                } else if (countOfFreq.size() == 2) {
                    int firstFreq = -1, secondFreq = -1;
                    for (int f : countOfFreq.keySet()) {
                        if (firstFreq == -1) firstFreq = f;
                        else secondFreq = f;
                    }

                    int highFreq = Math.max(firstFreq, secondFreq);
                    int lowFreq = Math.min(firstFreq, secondFreq);

                    if (highFreq == 2 * lowFreq && highFreq == maxFreq) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
        }

        return ans;
    }
}