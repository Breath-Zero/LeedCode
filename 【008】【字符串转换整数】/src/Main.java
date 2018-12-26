/**
 * 原题要求：
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 * <p>
 * 解题思路
 * 前导字符是+或-或者没有，接下来输入的是数字，数字不能整数能表示的最大或最小数。
 * 如果超过就返回对应的最小或者最小的值。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-26 22:35
 **/


class Solution {
    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            //throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }

        // 如果字符串以空格开始
        int start = 0; //从开始找第一个不是空格的数
        boolean positive = true; // 是否为正数默认为true

        if (str.charAt(start) == ' ') {
            while (str.charAt(start) == ' ') {
                start++;
                if (start >= str.length()) { // 输入的全是空格
                    //throw new NumberFormatException("Invalid input string: " + str);
                    return 0;
                }
            }
        }

        if (str.charAt(start) == '-') { // 第一个非空白字符中-
            positive = false;
            start++;
        } else if (str.charAt(start) == '+') {// 第一个非空白字符是+
            start++;
        } else if (str.charAt(start) >= '0' && str.charAt(start) <= '9') { // 第一个非空白字符是数字
            return cal(str, start, true);
        } else { // 其它情况就抛出异常
            //throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }


        if (start >= str.length()) { // 第一个非空白字符是+或者-但也是最后一个字符
            //  throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        }

        if (str.charAt(start) > '9' || str.charAt(start) < '0') { // +或者-后面接的不是数字
            //  throw new NumberFormatException("Invalid input string: " + str);
            return 0;
        } else {
            return cal(str, start, positive);
        }
    }

    private int cal(String str, int start, boolean positive) {

        long result = 0;
        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
            result = result * 10 + (str.charAt(start) - '0');

            if (positive) { // 如果是正数
                if (result > Integer.MAX_VALUE) {
                    // throw new NumberFormatException("Invalid input string: " + str);
                    return Integer.MAX_VALUE;
                }

            } else {
                if (-result < Integer.MIN_VALUE) {
                    // throw new NumberFormatException("Invalid input string: " + str);
                    return Integer.MIN_VALUE;
                }
            }

            start++;
        }

        if (positive) {
            return (int) result;
        } else {
            return (int) -result;
        }
    }
}

public class Main {
}
