import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-30 17:11
 **/

//class Solution {
//    public String largestNumber(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i; j++) {
//                if (nums[j] < nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
//        String[] str = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//
//        if (str[0].equals("0"))
//            return "0";
//
//        String ret = "";
//        for (int i = 0; i < str.length; i++)
//            ret += str[i];
//        return ret;
//    }
//}

class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if((s1+s2).compareTo(s2+s1)>0){
                    return -1;
                }else if((s1+s2).compareTo(s2+s1)<0){
                    return 1;
                }else if((s1+s2).compareTo(s2+s1)==0){
                    return 0;
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for(String i:strNums){
            res.append(i);
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 2};
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(nums));
    }
}







