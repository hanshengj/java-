判断环形链表
给定一个链表，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没
有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。
public class Solution {
    public boolean hasCycle(ListNode head) {
        //若只有一个节点或者没有节点则肯定不存在环
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow=head;//慢指针
        ListNode fast= head.next;//快指针
        while (slow!=fast){
            if( fast.next==null||fast.next.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return true;
    }
}

判断链表回文
对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
先找中间节点，在将后半部分反转，再进行比较判断回文
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
       ListNode fast=A;
        ListNode slow=A;
        //找出中间节点
        while( fast.next!=null &&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next==null){
            slow=slow.next;
        }
        //找中间节点在这里结束
        ListNode reverse1=reverse(slow);//调用反转函数，反转后半个链表
        //开始比较，判断是否为回文串
        while (reverse1!=null&&A!=null){
            if (A.val!=reverse1.val){
                return false;
            }else{
                A=A.next;
                reverse1=reverse1.next;
            }
        }
        return true;
    }
    //自己写反转函数
        public ListNode reverse(ListNode A){
            if(A==null){
                return null;
            }
            ListNode cur=A;
            ListNode prev=null;
            ListNode newHead=null;
            while(cur!=null){
                ListNode curNext=cur.next;
                if (curNext==null){
                    newHead=cur;
                }
                cur.next=prev;
                prev=cur;
                cur=curNext;
                
            }
            return newHead;
        }
    }
