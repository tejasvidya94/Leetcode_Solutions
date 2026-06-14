public class leetcode_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean dfsRecursion(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }
        // LEFT RECURSION
        if (!dfsRecursion(root.left, min, Math.min(max, root.val)))
            return false;
        // RIGHT RECURSION
        if (!dfsRecursion(root.right, Math.max(min, root.val), max))
            return false;

        return true;

    }

    public boolean isValidBST(TreeNode root) {
        return dfsRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
