/**
 * 原题要求：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *  解题思路
 *  通过求余数求商法进行操作。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-17 21:36
 **/

class Solution {
    public int reverse(int x) {
        long tmp = x;
        // 防止结果溢出
        long result = 0;

        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }

        return (int) result;
    }
}

public class Main {
}
