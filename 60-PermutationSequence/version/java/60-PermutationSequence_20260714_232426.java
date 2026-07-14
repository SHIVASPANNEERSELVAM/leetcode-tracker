// Last updated: 7/14/2026, 11:24:26 PM
1class Solution {
2    public int uniquePaths(int m, int n) {
3        //Create DP
4        int[][] dp=new int[m][n];
5        //Fill first row with 1
6        for(int i=0;i<n;i++)
7        {
8            dp[0][i]=1;
9        }
10        //Fill first column with 1
11        for(int j=0;j<m;j++)
12        {
13            dp[j][0]=1;
14        }
15
16        //Fill remaining cells in a grid
17        for(int i=1;i<m;i++)
18        {
19            for(int j=1;j<n;j++)
20            {
21                dp[i][j]=dp[i][j-1]+dp[i-1][j];
22            }
23        }
24        //Return the final answer in the m-1 and n-1 cell
25        return dp[m-1][n-1];
26    }
27}