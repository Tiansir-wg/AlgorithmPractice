package edu.hit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树所有根节点到叶节点的路径和
 *
 * https://www.nowcoder.com/practice/840dd2dc4fbd4b2199cd48f2dadf930a?tpId=117&tqId=37718&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC8 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    // 存放最终返回结果
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    // 存放一条路径
    private ArrayList<Integer> oneSolution = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        if(root == null) return new ArrayList<>(0);
        helper(root,sum,0);
        return ret;
    }

    private void helper(TreeNode root,int sum, int cnt){
        oneSolution.add(root.val);
        cnt += root.val;
        if(root.left == null && root.right == null){
            if(cnt == sum){
                ret.add(new ArrayList<>(oneSolution));
            }
        }else{
            if(root.left!=null){
                helper(root.left,sum,cnt);
            }
            if (root.right != null){
                helper(root.right,sum,cnt);
            }
        }
        cnt -= root.val;
        oneSolution.remove(oneSolution.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        NC8 nc8 = new NC8();
        System.out.println(nc8.pathSum(root, 1));
    }
}
