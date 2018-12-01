/**
 * 原题要求：
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 思路：
 * 采用快排的思想，小于1的放左边，大于1的放右边
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-01 14:11
 **/

class Solution {
    public void sortColors(int[] nums) {
        int start = 0; // 最左边的下标为0
        int end = nums.length - 1; // 最右边的下标
        int i = 0;
        while (i <= end) {
            if (nums[i] < 1) { // 如果元素小于1，放在最左边，start++，跟新i
                swap(nums, start, i);
                start++;
                i++;
            } else if (nums[i] > 1) { // 如果元素大于1，放在最右边end--，此时i不需要更新
                swap(nums, end, i);
                end--;
            } else { // 如果等于中间值，不需要交换，只需要更新i
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 1, 0, 0, 2};
        Solution solution = new Solution();
        solution.sortColors(nums);
        for (int temp : nums) {
            System.out.print(temp + " ");
        }
    }
}
