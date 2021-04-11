package edu.hit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=117&tqId=37723&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC15 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(0);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 1;
        ArrayList<Integer> layer = new ArrayList<>(1);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            layer.add(cur.val);
            cnt --;
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }

            if(cnt == 0){
                cnt = queue.size();
                ret.add(layer);
                layer = new ArrayList<>(cnt);
            }
        }
        return ret;
    }
}
