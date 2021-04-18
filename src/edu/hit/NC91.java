package edu.hit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=117&tqId=37796&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC91 {

    // 动态规划方法
    // 复杂度为N^2,运行超时
    public int[] LIS_v1 (int[] arr) {
        if(arr == null || arr.length == 0) return new int[0];
        // 初始值
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);

        // 最长子序列长度
        int maxLen = 1;

        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        int[] ret = new int[maxLen];
        for(int k = arr.length - 1;k >= 0;k--){
            if(dp[k] == maxLen){
                ret[--maxLen] = arr[k];
            }
        }
        return ret;
    }


    // 贪心 + 二分查找方式
    public int[] LIS (int[] arr) {
        if(arr == null || arr.length == 0) return new int[0];
        // dp[i]表示以arr[i]结尾的元素的最长子序列长度
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);

        // 临时记录最长子序列
        int[] res = new int[arr.length];
        // res数组实际的长度
        int resLen = 1;
        res[0] = arr[0];

        for(int i = 1;i < arr.length;i++){
            // 当前值比序列最后一个值大，直接加入
            if(arr[i] > res[resLen - 1]){
                res[resLen++] = arr[i];
                dp[i] = resLen;
            }
            else{
                // 二分查找找到第一个大于等于arr[i]的元素位置
                int left = 0, right = resLen - 1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    // 注意等于的位置
                    if(res[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                // left就是第一个大于等于arr[i]的位置，替换该位置不会影响目前得到的最长子序列的长度，但是是另一个最长子序列
                res[left] = arr[i];
                dp[i] = left + 1;
            }
        }

        int[] ret = new int[resLen];
        for(int k = arr.length - 1;k >= 0;k--){
            if(dp[k] == resLen){
                ret[--resLen] = arr[k];
            }
        }
        return ret;

    }


    public static void main(String[] args) {
        NC91 nc91 = new NC91();
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(nc91.LIS(arr));
    }
}
