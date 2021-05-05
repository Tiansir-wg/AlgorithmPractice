package edu.hit;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 加起来和目标值的组合
 *
 * https://www.nowcoder.com/practice/75e6cd5b85ab41c6a7c43359a74e869a?tpId=117&tqId=37742&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC46 {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null || num.length == 0) return new ArrayList<>(0);
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        helper(ret, new ArrayList<Integer>(),num, 0, target);
        return ret;
    }

    private void helper(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> sequence,int[] num,int startIndex, int target){
        // 找到一组符合的组合
        if(target == 0){
            ret.add(new ArrayList<>(sequence));
            return;
        }
        // 这里使用一个索引值startIndex表示前面的已访问，不能使用标记数组，因为组合内部是有序的
        for(int i = startIndex;i < num.length;i++){
            // 去重
            if(i > startIndex && num[i] == num[i - 1]) continue;
            // 剪枝
            if(target >= num[i]){
                sequence.add(num[i]);
                helper(ret,sequence,num,i + 1,target - num[i]);
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NC46 nc46 = new NC46();
        int[] arr = {100,10,20,70,60,10,50};
        ArrayList<ArrayList<Integer>> ret = nc46.combinationSum2(arr,80);
        System.out.println();
    }
}
