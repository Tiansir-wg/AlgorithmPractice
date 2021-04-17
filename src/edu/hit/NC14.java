package edu.hit;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的之字形遍历
 * <p>
 * https://www.nowcoder.com/practice/47e1687126fa461e8a3aff8632aa5559?tpId=117&tqId=37722&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}


public class NC14 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(0);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        // 初始保存第一层
        LinkedList<Integer> layer = new LinkedList<>();
        // 每一层的节点数
        int nodeCnt = 1;
        // 奇数层还是偶数层
        boolean odd = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            nodeCnt --;
            // 当前奇数层, 尾插法
            if(odd){
                layer.addLast(temp.val);
            }
            // 当前偶数层, 头插法
            else{
                layer.addFirst(temp.val);
            }
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
            if(nodeCnt == 0){
                ret.add(new ArrayList<>(layer));
                nodeCnt = queue.size();
                layer = new LinkedList<>();
                odd = !odd;
            }
        }
        return ret;
    }
}
