import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原题要求：
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 思路：
 * 1.排序2.查找
 * 如果我们对数组进行排序后，就可以比较相邻的两个元素，筛掉相同的元素
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-01 12:29
 **/

// 方法1：时间复杂度：n^2 (n*m)
class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List list = new ArrayList();
        Arrays.sort(nums1); // 对nums1排序
        Arrays.sort(nums2); // 对nums2排序
        for (int i = 0; i <= nums1.length - 1; i++) {
            while (i + 1 <= nums1.length - 1 && nums1[i] == nums1[i + 1]) { // 排除相同元素
                i++;
            }
            for (int j = 0; j <= nums2.length - 1; j++) {
                while (j + 1 <= nums2.length - 1 && nums2[j] == nums2[j + 1]) { // 排除相同元素
                    j++;
                }
                if (nums1[i] == nums2[j]){ // 如果两个元素相等
                    list.add(nums1[i]);
                }
            }
        }
        int[] num = new int[list.size()]; // 定义一个新的数组
        for (int i = 0; i < num.length; i++) {
            num[i] = (Integer) list.get(i);
        }
        return num;
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List list = new ArrayList();
        Arrays.sort(nums1); // 对nums1排序
        Arrays.sort(nums2); // 对nums2排序
        for (int i = 0; i <= nums1.length - 1; i++) {
            while (i + 1 <= nums1.length - 1 && nums1[i] == nums1[i + 1]) { // 排除相同元素
                i++;
            }
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0) {
                list.add(nums1[i]);
            }
        }
        int[] num = new int[list.size()]; // 定义一个新的数组
        for (int i = 0; i < num.length; i++) {
            num[i] = (Integer) list.get(i);
        }
        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,3,4,2,5};
        int[] nums2 = new int[]{2,3,4,5,6,6,7};
        Solution solution = new Solution();
        int[] num = solution.intersection(nums1,nums2);
        for (int temp : num){
            System.out.print(temp + " ");
        }
    }
}
