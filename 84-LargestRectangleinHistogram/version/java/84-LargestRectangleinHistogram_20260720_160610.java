// Last updated: 7/20/2026, 4:06:10 PM
1// Java
2class Solution {
3    public int largestRectangleArea(int[] heights) {
4        int n = heights.length;
5        int[] left = new int[n];
6        int[] right = new int[n];
7        Stack<Integer> stack = new Stack<>();
8
9        // Nearest Smaller to Left
10        for (int i = 0; i < n; i++) {
11            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
12            left[i] = stack.isEmpty() ? -1 : stack.peek();
13            stack.push(i);
14        }
15
16        stack.clear(); // Reuse stack
17
18        // Nearest Smaller to Right
19        for (int i = n - 1; i >= 0; i--) {
20            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
21            right[i] = stack.isEmpty() ? n : stack.peek();
22            stack.push(i);
23        }
24
25        int maxArea = 0;
26        for (int i = 0; i < n; i++) {
27            int width = right[i] - left[i] - 1;
28            maxArea = Math.max(maxArea, heights[i] * width);
29        }
30        return maxArea;
31    }
32}