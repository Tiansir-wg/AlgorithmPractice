package edu.hit;

/**
 * 删除有序链表中重复出现的元素
 *
 * https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=117&tqId=37729&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC24 {
    public ListNode deleteDuplicates (ListNode head) {
        if(head == null || head.next == null) return head;

        // 伪头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 前面的节点和当前节点
        ListNode pre = dummy, cur = dummy.next;
        while(cur != null && cur.next != null){
            // 当前节点和后面的节点不相等时开始处理下一个节点
            if(cur.val != cur.next.val){
                cur = cur.next;
                pre = pre.next;
            }else{
                ListNode temp = cur.next;
                // 找到第一个和当前节点不等的节点
                while(temp != null && temp.val == cur.val){
                    temp = temp.next;
                }
                // 剪除之间的节点
                pre.next = temp;
                cur = temp;
            }
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
