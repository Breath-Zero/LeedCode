import java.util.ArrayList;
import java.util.List;

/**
 * 原题要求：
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 思路：
 * 对树进行层序遍历，每层的结果放在结果链表的头部。
 * <p>
 * 使用LinkedList queue=new LinkedList()。因为LinkedList具有队列的性质，即先进先出规则。
 * 然后统计每一层的节点个数，然后在每层从左到右输出节点。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-05 19:30
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> list = new LinkedList<>();
//         if (root == null) {
//             return list;
//         }

//         Deque<TreeNode> cur = new LinkedList<>();
//         Deque<TreeNode> nxt = new LinkedList<>();
//         Deque<TreeNode> exc = new LinkedList<>();

//         TreeNode tmp;

//         cur.add(root);
//         while (!cur.isEmpty()) {
//             List<Integer> layout = new ArrayList<>();

//             while (!cur.isEmpty()) {
//                 tmp = cur.remove();

//                 if (tmp.left != null) {
//                     nxt.add(tmp.left);
//                 }

//                 if (tmp.right != null) {
//                     nxt.add(tmp.right);
//                 }

//                 layout.add(tmp.val);
//             }

//             exc = cur;
//             cur = nxt;
//             nxt = exc;

//             list.add(0, layout);
//         }

//         return list;


        List<List<Integer>> lists = new ArrayList<>();
        func(lists, 0, root);
        for (int i = 0, j = lists.size() - 1; i < j; i++, j--) {
            List<Integer> temp = lists.get(i);
            lists.set(i, lists.get(j));
            lists.set(j, temp);
        }
        return lists;
    }

    private void func(List<List<Integer>> lists, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (lists.size() == level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        } else {
            lists.get(level).add(root.val);
        }
        func(lists, level + 1, root.left);
        func(lists, level + 1, root.right);

    }
}