package edu.hit;

/**
 * 寻找第K大
 * https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=117&tqId=37791&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC88 {
    public int findKth(int[] a, int n, int K) {
        return find(a,0,n - 1, K);
    }

    int find(int[] a,int i, int j,int k){
        int temp = a[i];
        int left = i,right = j;
        while(left < right){
            while(left < right && a[right] <= temp) right--;
            a[left] = a[right];
            while(left < right && a[left] >= temp) left++;
            a[right] = a[left];
        }
        a[left] = temp;

        if(left == k - 1){
            return a[left];
        }else if(left < k - 1){
            return find(a,left + 1,j, k);
        }else{
            return find(a,i,left - 1, k);
        }
    }
}
