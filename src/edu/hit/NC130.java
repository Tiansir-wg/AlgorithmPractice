package edu.hit;

import java.util.Arrays;

/**
 * 分糖果问题
 *
 * https://www.nowcoder.com/practice/76039109dd0b47e994c08d8319faa352?tpId=117&tqId=37806&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC130 {
    public int candy (int[] arr) {
        int sum = 0;
        if(arr == null || arr.length == 0) return sum;
        int len = arr.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        for(int i = 1;i < len;i++){
            if(arr[i] > arr[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = len - 1;i > 0;i--){
            if(arr[i - 1] > arr[i]){
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }
        for(int i = 0;i < len;i++){
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        NC130 nc130 = new NC130();
        System.out.println(nc130.candy(arr));
    }
}
