package edu.hit;

import java.util.ArrayList;

/**
 * 实现二叉树的前序、中序和后序遍历
 * https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=117&tqId=37819&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey * */
public class NC45 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root) {
        if(root == null) return new int[0][0];
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(list,root);
        int[] pre = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            pre[i] = list.get(i);
        }

        int[] in = new int[list.size()];
        list.clear();
        inOrder(list,root);
        for(int i = 0;i < list.size();i++){
            in[i] = list.get(i);
        }

        int[] post = new int[list.size()];
        list.clear();
        postOrder(list,root);
        for(int i = 0;i < list.size();i++){
            post[i] = list.get(i);
        }

        int[][] ret = new int[3][list.size()];
        ret[0] = pre;
        ret[1] = in;
        ret[2] = post;
        return ret;
    }

    private void preOrder(ArrayList<Integer> list, TreeNode root){
        if(root == null){
            return;
        }else{
            list.add(root.val);
            preOrder(list,root.left);
            preOrder(list,root.right);
        }
    }

    private void inOrder(ArrayList<Integer> list, TreeNode root){
        if(root == null){
            return;
        }else{
            inOrder(list,root.left);
            list.add(root.val);
            inOrder(list,root.right);
        }
    }

    private void postOrder(ArrayList<Integer> list, TreeNode root){
        if(root == null){
            return;
        }else{
            postOrder(list,root.left);
            postOrder(list,root.right);
            list.add(root.val);
        }
    }
}
