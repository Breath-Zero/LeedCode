import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 原题要求：
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * <p>
 * 解题思路：
 * 非递归
 * 根据后序遍历的顺序，先访问左子树，再访问右子树，后访问根节点，而对于每个子树来说，
 * 又按照同样的访问顺序进行遍历，后序遍历的非递归的实现相对来说要难一些，要保证根节
 * 点在左子树和右子树被访问后才能访问，思路如下：
 * <p>
 * 对于任一节点P，
 * 1）先将节点P入栈；
 * 2）若P不存在左孩子和右孩子，或者P存在左孩子或右孩子，但左右孩子已经被输出，则可
 * 以直接输出节点P，并将其出栈，将出栈节点P标记为上一个输出的节点，再将此时的
 * 栈顶结点设为当前节点；
 * 3）若不满足2）中的条件，则将P的右孩子和左孩子依次入栈，当前节点重新置为栈顶结点，
 * 之后重复操作2）；
 * 4）直到栈空，遍历结束。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-13 20:19
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root != null) {
            // 双端队列，当作栈来使用
            Deque<TreeNode> deque = new LinkedList<>();
            // 指向前一个处理的结点
            TreeNode prev = null;
            // 指向当前处理的结点
            TreeNode curr;
            // 根结点入栈
            deque.addLast(root);
            // 栈非空
            while (!deque.isEmpty()) {
                // 获取栈顶元素（不删除）
                curr = deque.getLast();
                if ((curr.left == null && curr.right == null) // 当前元素无左右子树
                        // prev == null && curr.left == prev，当前结点只有左子树，并且左子树已经遍历完
                        // prev == null && curr.right == prev，当前结点有左右子树，并且左右子树已经遍历完
                        || (prev != null && (curr.left == prev || curr.right == prev))) {
                    // 删除栈顶元素
                    curr = deque.removeLast();
                    // 结点值入栈
                    list.add(curr.val);
                    // 更新上一个处理的结点
                    prev = curr;
                } else {

                    // 左右子树未遍历完，将非空左右子树入栈

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }
                }
            }
        }

        return list;
    }
}

public class Main {
}
