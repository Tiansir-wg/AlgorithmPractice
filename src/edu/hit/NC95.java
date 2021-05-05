package edu.hit;

import java.util.Arrays;

/**
 * 数组中最长连续子序列的长度
 *
 * https://www.nowcoder.com/practice/eac1c953170243338f941959146ac4bf?tpId=117&tqId=37810&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC95 {
    public int MLS (int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        // 当前最长连续序列长度
        int maxLS = 1;
        // 当前长度
        int len = 1;
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i + 1] - arr[i] == 0){
                continue;
            }else if(arr[i + 1] - arr[i] == 1){
                len++;
            }else{
                len = 1;
            }
            maxLS = maxLS > len ? maxLS : len;
        }
        return maxLS;
    }

    public static void main(String[] args) {
        NC95 nc95 = new NC95();
        int[] arr= {100,4,200,1,3,2};
        System.out.println(nc95.MLS(arr));
    }
}
