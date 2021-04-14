package edu.hit;

/**
 * 子数组的最大累加和
 *
 * https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd?tpId=117&tqId=37797&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC19 {

    public int maxsumofSubarray (int[] arr) {
        // dp[i]表示以第i个元素结尾的子数组的最大和
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1;i < arr.length;i++){
            if(dp[i - 1] + arr[i] >= arr[i]){
                dp[i] = dp[i - 1] + arr[i];
            }else{
                dp[i] = arr[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NC19 nc19 = new NC19();
        int[] arr = {1, -2, 3, 5, -2, 6, -1, 2};
        System.out.println(nc19.maxsumofSubarray(arr));
    }
}
