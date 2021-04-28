package edu.hit;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
 *
 * https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729?tpId=117&tqId=37835&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC111 {
    public String solve (int[] nums) {
        // 转化为字符串
        String[] strs = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        // 排序
        // 顺序是: 相邻两个数组合结果更大时的顺序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1.concat(o2);
                String temp2 = o2.concat(o1);
                if(temp1.compareTo(temp2) > 0){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        // 全为0的情况
        if(strs[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NC111 nc111 = new NC111();
        int[] arr = {0,0};
        System.out.println(nc111.solve(arr));
    }
}
