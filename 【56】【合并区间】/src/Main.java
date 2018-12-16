import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 原题要求：
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 思路：
 * 先对区间进行排序，按开始点进行排序，再一个一个进行合并
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-12-16 19:59
 **/

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();

        if (intervals == null || intervals.size() < 1) {
            return result;
        }

        // 先对区间进行排序，使用一个匿名内部类
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // 排序后，后一个元素（记为next）的start一定是不小于前一个（记为prev）start的，
        // 对于新添加的区间，如果next.start大于prev.end就说明这两个区间是分开的，要添
        // 加一个新的区间，否则说明next.start在[prev.start, prev.end]内，则只要看
        // next.end是否是大于prev.end，如果大于就要合并区间（扩大）
        Interval prev = null;
        for (Interval item : intervals) {

            if (prev == null || prev.end < item.start) {
                result.add(item);
                prev = item;
            } else if (prev.end < item.end) {
                prev.end = item.end;
            }
        }

        return result;
    }
}


public class Main {
}
