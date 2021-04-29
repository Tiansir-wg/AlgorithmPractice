package edu.hit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 有重复项数字的所有排列
 *
 * https://www.nowcoder.com/practice/a43a2b986ef34843ac4fdd9159b69863?tpId=117&tqId=37739&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC43 {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null || num.length == 0) return new ArrayList<>(0);
        // 升序排序
        Arrays.sort(num);
        // 记录num对应位置的数是否已经使用
        boolean[] used = new boolean[num.length];
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        helper(num,used,ret,new ArrayList<>());
        return ret;
    }

    private void helper(int[] num, boolean[] used, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> sequence){
        // 形成一个序列
        if(sequence.size() == num.length){
            ret.add(new ArrayList<>(sequence));
        }else{
            for(int i = 0;i < num.length;i++){
                if(used[i] == false){
                    sequence.add(num[i]);
                    // 标记为已使用
                    used[i] = true;
                    // 处理序列的下一个数
                    helper(num,used,ret,sequence);
                    // 还原
                    used[i] = false;
                    sequence.remove(sequence.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        NC43 nc43 = new NC43();
        int[] arr = {1,2,3};
        for (ArrayList<Integer> arrayList : nc43.permute(arr)) {
            for (Integer integer : arrayList) {
                System.out.println(integer);
            }
            System.out.println("-----");
        }
    }
}
