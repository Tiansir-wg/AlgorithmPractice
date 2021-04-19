package edu.hit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 合并K个有序链表
 *
 * https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=117&tqId=37747&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class NC51 {
    /**
     * 基于优先级队列实现
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_v1(ArrayList<ListNode> lists) {
        // 空数组的情况
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);

        // 小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 头节点加入小根堆，注意不是所有节点
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(-1), end = dummy;
        // 小根堆的根节点是最小值
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            end.next = temp;
            end = end.next;
            // 当前节点所在链表的下一个节点入小根堆
            if(temp.next!=null){
                queue.add(temp.next);
            }
        }
        return dummy.next;
    }

    /**
     * 分治法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 空数组的情况
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        return mergeKList(lists,0, lists.size() - 1);
    }

    private ListNode mergeKList(ArrayList<ListNode> lists,int left,int right){
        if(left == right) {
            return lists.get(left);
        }else if(left > right){
            return null;
        }else{
            int mid = left + (right - left) / 2;
            ListNode list1 = mergeKList(lists,left,mid);
            ListNode list2 = mergeKList(lists,mid + 1, right);
            return mergeTwoList(list1,list2);
        }
    }

    // 合并两个链表
    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode node1 = list1, node2 = list2;
        ListNode dummy = new ListNode(-1), end = dummy;
        while (node1 != null && node2 != null){
            if(node1.val <= node2.val){
                end.next = node1;
                node1 = node1.next;
            }else{
                end.next = node2;
                node2 = node2.next;
            }
            end = end.next;
        }

        if(node1 != null){
            end.next = node1;
        }

        if(node2 != null){
            end.next = node2;
        }
        return dummy.next;
    }

}
