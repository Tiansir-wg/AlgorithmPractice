package edu.hit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断树是否是搜索二叉树和完全二叉树
 * <p>
 * https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97?tpId=117&tqId=37822&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC60 {

    public boolean[] judgeIt(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return new boolean[]{true, true};
        boolean bst = isBST(root);
        boolean completed = isCompletedTree(root);
        return new boolean[]{bst, completed};
    }

    // 判断是否是搜索二叉树
    private boolean isBST(TreeNode root) {
        ArrayList<Integer> sequence = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                sequence.add(temp.val);
                temp = temp.right;
            }
        }
        // 中序遍历序列是否为升序序列
        int ssize = sequence.size();
        for (int i = 1; i < ssize; i++) {
            if (sequence.get(i) < sequence.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 判断是否是完全二叉树
    private boolean isCompletedTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前节点不空就将其全部子节点入队列
        while (queue.peek() != null) {
            TreeNode temp = queue.poll();
            queue.add(temp.left);
            queue.add(temp.right);
        }
        // 如果空节点后面还有非空节点则不是完全二叉树
        while(!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        NC60 nc60 = new NC60();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        boolean[] bools = nc60.judgeIt(node1);
        for (boolean b : bools) {
            System.out.println(b);
        }
    }

static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
}
