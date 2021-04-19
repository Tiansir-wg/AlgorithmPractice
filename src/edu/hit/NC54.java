package edu.hit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数组中相加和为0的三元组
 *
 * https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=117&tqId=37751&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // 空数组的情况
        if(num == null || num.length < 3) return new ArrayList<>(0);
        // 排序
        Arrays.sort(num);
        // 第一个数大于0则三个数的何必不可能等于0
        if(num[0] > 0) return new ArrayList<>(0);
        // 最后的返回结果
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        // 第一个数只能不能取最后两个
        for(int i = 0;i < num.length - 2;i++){
            // 第二个数,第三个数,后两个数之和
            int j = i + 1, k = num.length - 1,target = -num[i];
            // 第二个数在第三个数前面
            while(j < k){
                // 三数之和等于0
                if(num[j] + num[k] == -num[i]){
                    ArrayList<Integer> temp = new ArrayList<>(3);
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[k]);
                    ret.add(temp);
                    // 第二个数重复，跳过,j + 1 < k而不是j < k是因为只有两个数还有数时才需要跳过
                    while(j + 1 < k && num[j] == num[j + 1]) j++;
                    // 第三个数重复，跳过
                    while(j + 1 < k && num[k] == num[k - 1]) k++;
                    j++;
                    k--;
                }else if(num[j] + num[k] < -num[i]){
                    j++;
                }else{
                    k--;
                }
            }
            // 第一个数重复，跳过
            while (i + 1 < num.length - 2 && num[i] == num[i+1]) i++;
        }
        return ret;
    }
}
