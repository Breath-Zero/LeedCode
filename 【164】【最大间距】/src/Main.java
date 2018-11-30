import java.util.Arrays;

/**
 *
 * 思路：
 * 1.利用桶排序的思想，先求出原数组从最小值Min到最大值Max的单位区间长度d，d=(Max-Min)/n。
 * 算出d的作用是为了后续确定各个桶的区间范围划分。
 *
 * 2.创建一个长度是N+1的数组Array，数组的每一个元素都是一个List，代表一个桶。
 *
 * 3.遍历原数组，把原数组每一个元素插入到新数组Array对应的桶当中，进入各个桶的条件是根据不同的数值区间
 * （数值区间如何划分，看后面的图就明白了）。由于桶的总数量是N+1，所以至少有一个桶是空的。
 *
 * 4.遍历新数组Array，计算每一个空桶右端非空桶中的最小值，与空桶左端非空桶的最大值的差，
 * 数值最大的差即为原数组排序后的相邻最大差值。
 *
 * 该解法的时间复杂度为O（n），空间复杂度同样是O（n）。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-30 16:14
 **/


// 方法1

//class Solution {
//    public int maximumGap(int[] nums) {
//        if(nums.length<2||nums==null){
//            return 0;
//        }
//        Arrays.sort(nums);
//        int maxGap=Integer.MIN_VALUE;
//        for(int i=0;i<nums.length-1;i++){
//            maxGap=Math.max(maxGap, nums[i+1]-nums[i]);
//        }
//        return maxGap;
//    }
//}

    // 方法2
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        // 找最大值和最小值
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(max, nums[i]);
        }
        if (max == min) {
            return 0;
        }
        int num = n + 1; // 用 n+1 个桶来存放
        int[] mins = new int[num]; // 保存每个桶的最小值
        int[] maxs = new int[num]; // 保存每个桶的最大值
        boolean[] hasNum = new boolean[num]; // 用来标记对应下标的桶中是否为空
        for (int i = 0; i < n; i++) {
            int tag = bucket(nums[i], n, max, min);
            mins[tag] = hasNum[tag] ? Math.min(mins[tag], nums[i]) : nums[i];
            maxs[tag] = hasNum[tag] ? Math.max(maxs[tag], nums[i]) : nums[i];
            hasNum[tag] = true;
        }

////      放好元素后，开始计算最大的差值
//        int gap = 0;
//        int preMax = 0;//记录前一个桶中的最大值
//        int aftMin = 0;//记录后一个桶中的最小值
//        int i = 0;
//        while (i < num) {   //在n+1 个桶中循环更新 gap的值，每次只在空桶两侧更新，因为首先n个元素，n+1个桶，保证了肯定有空桶，并且最大的差值肯定出现在空桶的两侧非空桶中元素的差值中
//            while (i < num && hasNum[i]) {   //寻找第一个空桶，因为n+1 个桶存放 n 个元素，肯定会有空桶存在，而最大值，就会出现在空桶中相邻两个桶中元素的差值
//                i++;
//            }
//            if (i >= num)
//                break;
//            preMax = maxs[--i];
//            i++;
//            while (i < num && !hasNum[i]) { //在上次找到了空桶的基础上，继续循环，空桶之后的下一个非空的桶，此处因为我们把最大的元素放到了最后一个桶中，所以不用担找不到下一个非空的桶
//                i++;
//            }
//            aftMin = mins[i];
//            gap = gap > (aftMin - preMax) ? gap : (aftMin - preMax);
//        }


        int gap = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= n; i++) {
            if (hasNum[i]) {
                gap = Math.max(gap, mins[i] - lastMax);  //计算每个相邻的非空桶差值
                lastMax = maxs[i];
            }
        }
        return gap;
    }

    private int bucket(long value, long num, long max, long min) {
        //int tag = (int) ((value-min)/((max-min)/(num-1)));  应该避免这种连续除法的表达式，因为每次处的时候都会舍，到最后结果会相差很大
        int tag = (int) ((value - min) * num / (max - min));
        return tag;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{3, 6, 9, 1};
        int[] nums = new int[]{15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.println(solution.maximumGap(nums));
    }
}





















