// Last updated: 7/9/2026, 10:06:40 AM
import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {

        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);

        int maxGap = 0;

        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap,
                              nums[i] - nums[i - 1]);
        }

        return maxGap;
    }
}