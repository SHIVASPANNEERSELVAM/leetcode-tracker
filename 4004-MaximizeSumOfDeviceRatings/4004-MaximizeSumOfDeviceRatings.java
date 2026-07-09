// Last updated: 7/9/2026, 10:06:12 AM
import java.util.Arrays;

class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        
        long totalBaseRating = 0;
        long globalMin = Long.MAX_VALUE;
        
        long sumSecondSmallest = 0;
        long minSecondSmallest = Long.MAX_VALUE;
        
        for (int i = 0; i < m; i++) {
            Arrays.sort(units[i]);
            
            long smallest = units[i][0];
            long secondSmallest = (units[i].length > 1) ? units[i][1] : 0;
            
            totalBaseRating += smallest;
            globalMin = Math.min(globalMin, smallest);
            
            sumSecondSmallest += secondSmallest;
            minSecondSmallest = Math.min(minSecondSmallest, secondSmallest);
        }
        
        if (m == 1) {
            return totalBaseRating;
        }
        
        long optionB = sumSecondSmallest - minSecondSmallest + globalMin;
        
        return Math.max(totalBaseRating, optionB);
    }
}