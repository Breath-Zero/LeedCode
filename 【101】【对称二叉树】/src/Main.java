import java.util.Arrays;

/**
 * 原题要求：
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 解题思路
 * 创建一个辅助类数组，对辅助类进行排序，使用两个指针，开始时分别指向数组的两端，看这两个下标对应的值是否
 * 等于目标值，如果等于就从辅助类中找出记录的下标，构造好返回结果，返回。如果大于就让右边的下标向左移，
 * 进入下一次匹配，如果小于就让左边的下标向右移动，进入下一次匹配，直到所有的数据都处理完
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-05 18:47
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

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            return isSame(root.left, root.right);
        }
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        } else {
            return left.val == right.val && isSame(left.left, right.right)
                    && isSame(left.right, right.left);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode T1 = new TreeNode(2);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(3);
        TreeNode T4 = new TreeNode(3);
        root.left = T1;
        root.right = T2;
        T1.left = null;
        T1.right = T3;
        T2.left = null;
        T2.right = T4;
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}

