package edu.hit;

/**
 * 在两个长度相同的排序数组中找中位数
 *
 * https://www.nowcoder.com/practice/6fbe70f3a51d44fa9395cfc49694404f?tpId=117&tqId=37808&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC36 {
    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        int left1 = 0, right1 = arr1.length - 1;
        int left2 = 0, right2 = arr2.length - 1;
        while(left1 < right1 && left2 < right2){
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = left2 + (right2 - left2) / 2;
            // 等于1表示奇数个
            boolean flag = (((right1 - left1 + 1) & 1) == 1);
            if(arr1[mid1] == arr2[mid2]){
                return arr1[mid1];
            }else if(arr1[mid1] < arr2[mid2]){
                if(flag){
                    left1 = mid1;
                    right2 = mid2;
                }else{
                    // 要保持两个数组去掉的部分长度相等
                    left1 = mid1 + 1;
                    right2 = mid2;
                }
            }else{
                if(flag){
                    right1 = mid1;
                    left2 = mid2;
                }else{
                    left2 = mid2 + 1;
                    right1 = mid1;
                }
            }
        }
        return Math.min(arr1[left1], arr2[left2]);
    }

    public static void main(String[] args) {
        NC36 nc36 = new NC36();
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        System.out.println(nc36.findMedianinTwoSortedAray(arr1, arr2));
    }
}
