package edu.hit;

/**
 * 容器盛水问题
 *
 * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=117&tqId=37802&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC128 {
    /**
     * 首先求容器边界,
     * 然后使用双指针,
     * 分别从两边往中间扫描,
     * 当左边的高度小于右边的高度时,左指针++,
     * 如果此时当前位置的高度小于容器的边界高度,这个位置上方有水,进行水量累加。
     * 反之，则右指针向左扫描-1。
     * @param arr
     * @return
     */
    public long maxWater (int[] arr) {
        if(arr == null || arr.length < 3) return 0L;
        int left = 0, right = arr.length - 1;
        long waterCnt = 0;
        int min = Math.min(arr[left],arr[right]);
        while(left < right){
            if(arr[left] < arr[right]){
                left ++;
                if(arr[left] < min){
                    waterCnt += (min - arr[left]);
                }else{
                    min = Math.min(arr[left],arr[right]);
                }
            }else{
                right--;
                if(arr[right] < min){
                    waterCnt += (min - arr[right]);
                }else{
                    min = Math.min(arr[left],arr[right]);
                }
            }
        }
        return waterCnt;
    }
}
