package edu.hit;

/**
 * 在转动过的有序数组中寻找目标值
 *
 * https://www.nowcoder.com/practice/7cd13986c79d4d3a8d928d490db5d707?tpId=117&tqId=37744&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC48 {
    public int search (int[] A, int target) {
        if(A == null || A.length == 0) return -1;

        // 二分查找
        for(int left = 0, right = A.length - 1;left <= right;){
            int mid = left + (right - left) / 2;
            // 找到目标元素
            if(A[mid] == target) return mid;
            // 左侧有序
            if(A[mid] >= A[left]){
                // 在范围内
                if(A[left] <= target && A[mid] > target){
                    right = mid - 1;
                }
                // 不在范围内
                else{
                    left = mid + 1;
                }
            }
            // 右侧有序
            else{
                if(A[mid] < target && A[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
