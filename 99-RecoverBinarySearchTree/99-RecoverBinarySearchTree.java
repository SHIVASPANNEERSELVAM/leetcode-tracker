// Last updated: 7/9/2026, 10:07:33 AM
class Solution {

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null && prev.val > node.val) {

            if (first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        inorder(node.right);
    }
}