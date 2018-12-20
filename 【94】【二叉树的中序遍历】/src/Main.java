import java.util.LinkedList;
import java.util.List;

/**
 * 原题要求：
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-20 22:35
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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.removeLast();
                result.add(node.val);
                node = node.right;
            }
        }

        System.out.println(result);
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(n1);
        System.out.println(result);
    }
}
