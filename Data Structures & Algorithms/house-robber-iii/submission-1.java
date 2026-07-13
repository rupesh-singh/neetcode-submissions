/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(memo.containsKey(root))
            return memo.get(root);
        else {
            int res = root.val;

            if(root.left != null){
                res = res + rob(root.left.left) + rob(root.left.right);
            }

            if(root.right != null){
                res = res + rob(root.right.right) + rob(root.right.left);
            }

            res = Math.max(res, rob(root.left) + rob(root.right));
            memo.put(root, res);
            return res;
        }
    }
}