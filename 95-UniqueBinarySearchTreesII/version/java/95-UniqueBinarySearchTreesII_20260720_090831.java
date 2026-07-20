// Last updated: 7/20/2026, 9:08:31 AM
1class Solution {
2    public List<TreeNode> generateTrees(int n) {
3        if (n == 0) {
4            return new ArrayList<>();
5        }
6        
7        Map<String, List<TreeNode>> memo = new HashMap<>();
8
9        return generateTreesHelper(1, n, memo);        
10    }
11
12    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> memo) {
13        String key = start + "-" + end;
14        if (memo.containsKey(key)) {
15            return memo.get(key);
16        }
17        
18        List<TreeNode> trees = new ArrayList<>();
19        if (start > end) {
20            trees.add(null);
21            return trees;
22        }
23        
24        for (int rootVal = start; rootVal <= end; rootVal++) {
25            List<TreeNode> leftTrees = generateTreesHelper(start, rootVal - 1, memo);
26            List<TreeNode> rightTrees = generateTreesHelper(rootVal + 1, end, memo);
27            
28            for (TreeNode leftTree : leftTrees) {
29                for (TreeNode rightTree : rightTrees) {
30                    TreeNode root = new TreeNode(rootVal);
31                    root.left = leftTree;
32                    root.right = rightTree;
33                    trees.add(root);
34                }
35            }
36        }
37        
38        memo.put(key, trees);
39        return trees;
40    }
41}