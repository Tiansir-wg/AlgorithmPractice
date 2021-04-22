package edu.hit;

/**
 * 二叉树的最大深度
 *
 * https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=117&tqId=37721&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC13 {
    public int maxDepth (TreeNode root) {
        if(root == null) return 0;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }
}
