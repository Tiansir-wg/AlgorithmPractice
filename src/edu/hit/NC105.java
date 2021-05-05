package edu.hit;

import com.sun.scenario.effect.Brightpass;

/**
 * 二分查找2
 *
 * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=117&tqId=37829&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC105 {
    public int search (int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        NC105 nc105 = new NC105();
        int[] arr = {1,4,4,4,5};
        System.out.println(nc105.search(arr, 4));
    }
}
