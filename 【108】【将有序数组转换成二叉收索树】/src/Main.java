/**
 * 原题要求：
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * 思路：
 * 采用递归分治法
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-12 19:13
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

    public TreeNode sortedArrayToBST(int[] nums) {
        // 参数检验
        if (nums == null || nums.length < 1) {
            return null;
        }

        // 递归分治法求解
        return solve(nums, 0, nums.length - 1);
    }

    /**
     * 递归分治求解方法
     *
     * @param nums  升序排序数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 根结点
     */
    public TreeNode solve(int[] nums, int start, int end) {
        // 还有未处理的数据
        if (start <= end) {
            // 找蹭位置
            int mid = start + ((end - start) >> 1);
            // 构造根结点
            TreeNode root = new TreeNode(nums[mid]);
            // 求左子树
            root.left = solve(nums, start, mid - 1);
            // 求右子树
            root.right = solve(nums, mid + 1, end);
            // 返回结果
            return root;
        }

        return null;
    }
}

public class Main {
}
