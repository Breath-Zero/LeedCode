/**
 * 原题要求：
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 思路
 * 递归求解，递归公式
 * f(n) = 0; n=null,
 * f(n) = 1+ max(f(n左)， f(n右))
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-05 19:33
 **/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int left_height = maxDepth(root.left); // 左树的高度
            int right_height = maxDepth(root.right); // 右树的高度
            return 1 + (left_height > right_height ? left_height : right_height); // 取得最高的+1（根）
        }
    }
}
