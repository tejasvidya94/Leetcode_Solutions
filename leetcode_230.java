public class leetcode_230 {

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

    class Solution {
        public int counter = 0;

        public int inorder(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }
            int ans = -1;
            ans = inorder(root.left, k);
            if (ans != -1) {
                return ans;
            }
            counter++;
            if (counter == k) {
                return root.val;
            }
            ans = inorder(root.right, k);
            if (ans != -1) {
                return ans;
            }
            return ans;

        }

        public int kthSmallest(TreeNode root, int k) {
            return inorder(root, k);
        }
    }
}
