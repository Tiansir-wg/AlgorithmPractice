package edu.hit;

import java.util.Stack;

/**
 * 二叉树的所有路径之和
 *
 * https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=117&tqId=37715&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC5 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int sumNumbers (TreeNode root) {
        if(root == null) return 0;
        return helper(root,0);
    }

    private int helper(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }else{
            int ret = 0;
            if(root.left != null){
                ret += helper(root.left,sum * 10 + root.val);
            }
            if(root.right != null){
                ret += helper(root.right, sum * 10 + root.val);
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
//        TreeNode node3 = new TreeNode(0);
        node1.left = node2;
//        node1.right = node3;
        NC5 nc5 = new NC5();
        System.out.println(nc5.sumNumbers(node1));
    }
}
