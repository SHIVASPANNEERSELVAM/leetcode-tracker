// Last updated: 7/14/2026, 11:04:16 PM
1class Solution {
2    public List<Integer> grayCode(int n) {
3        int size = 1 << n;
4        List<Integer> result = new ArrayList<>();
5        for(int i = 0; i < size; i++) result.add(i ^ (i >> 1));
6        return result;
7    }
8}