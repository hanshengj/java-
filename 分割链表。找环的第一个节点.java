分割链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
创建一个低于x的链表和一个高于x的链表，然后合并两个链表
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode highHead=new ListNode(0);
        ListNode lowHead=new ListNode(0);
        ListNode low=lowHead;
        ListNode high=highHead;
        while (head!=null){
            if(head.val<x){
                low.next=head;
                head=head.next;
                low=low.next;
            }else{
                high.next=head;
                head=head.next;
                high=high.next;
            }
        }
        high.next=null;
        low.next=highHead.next;
        return lowHead.next;
    }
}

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，
则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

先判断是否有环，在给慢指针赋值head，快慢指针同时往后移动一步/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        //判断是否有环
        while (fast!=null &&fast.next!=null){
            fast= fast.next.next;
            slow= slow.next;
            if(slow==fast){
                break;
            }
        }

        //没有环
        if(fast==null || fast.next==null){
            return null;
        }
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;

            }
            return slow;
    }
}
