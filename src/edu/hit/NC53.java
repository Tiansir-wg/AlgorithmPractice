package edu.hit;

/**
 * 删除链表的倒数第K个节点
 *
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=117&tqId=37750&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey * */
public class NC53 {

    static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 头结点为空
        if(head == null) return head;

        // 添加头结点防止删除head的情况
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        ListNode fast = head;
        // 慢指针指向待删除节点的前一个
        ListNode slow = head;
        // 快指针移动n位
        while(n > 0){
            fast = fast.next;
            if(fast == null){
                return head;
            }
            n--;
        }
        // 快指针到达尾部时慢指针指向待删除节点的前一个节点
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        NC53 nc53 = new NC53();
        nc53.removeNthFromEnd(new ListNode(),1);
    }
}
