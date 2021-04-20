package edu.hit;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 输出二叉树的右视图
 *
 * https://www.nowcoder.com/practice/c9480213597e45f4807880c763ddd5f0?tpId=117&tqId=37848&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC136 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    // 层序遍历，只返回每一层最右边的节点
    private ArrayList<Integer> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>(0);
        // 返回
        ArrayList<Integer> ret = new ArrayList<>();

        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 记录每一层的节点数
        int layerCnt = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            layerCnt --;

            // 子节点入队列
            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }

            // 当前处理的节点是该层最后一个节点
            if(layerCnt == 0) {
                ret.add(temp.val);
                layerCnt = queue.size();
            }

        }
        return ret;
    }

    private TreeNode rebuild(int[] xianxu, int xStart, int[] zhongxu,int zStart, int zEnd){
        if(zStart > zEnd){
            return null;
        }
        // 先序序列的第一个节点作为根结点
        TreeNode root = new TreeNode(xianxu[xStart]);

        // 找到根节点在中序数组的位置
        int i;
        for(i = zStart;i <= zEnd;i++){
            if(xianxu[xStart] == zhongxu[i]){
                break;
            }
        }

        // 重建左右子树
        root.left = rebuild(xianxu,xStart + 1,zhongxu,zStart,i - 1);
        root.right = rebuild(xianxu,xStart + (i - zStart) + 1,zhongxu, i + 1, zEnd);
        return root;
    }

    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = rebuild(xianxu,0,zhongxu,0,zhongxu.length - 1);
        ArrayList<Integer> arr = levelOrder(root);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3};
        int[] in = {4,2,5,1,3};
        NC136 nc136 = new NC136();
        nc136.solve(pre,in);
    }
}
