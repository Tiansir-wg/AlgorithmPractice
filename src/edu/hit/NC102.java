package edu.hit;

/**
 * 最近公共祖先
 * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=117&tqId=37826&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC102 {

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        TreeNode commonAncestor = commonAncestor(root, o1, o2);
        return commonAncestor != null ? commonAncestor.val : -1;
    }

    private TreeNode commonAncestor(TreeNode root, int o1, int o2){
        if(root == null || root.val == o1 || root.val == o2) return root;
        TreeNode left = commonAncestor(root.left,o1,o2);
        TreeNode right = commonAncestor(root.right,o1,o2);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
