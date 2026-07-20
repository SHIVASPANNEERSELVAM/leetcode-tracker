// Last updated: 7/20/2026, 4:22:56 PM
1class Solution {
2    public int rangeBitwiseAnd(int left, int right) {
3        int cnt = 0;
4        while (left != right) {
5            left >>= 1;
6            right >>= 1;
7            cnt++;
8        }
9        return (left << cnt);
10    }
11}
12