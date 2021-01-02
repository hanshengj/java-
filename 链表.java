
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL输出: 5->4->3->2->1->NULL

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
      if (head==null){
          return null;
      }
      ListNode cur=head;
      ListNode prev=null;
      ListNode newHead=null;
      while (cur!=null){
          ListNode curNext=cur.next;
          if (curNext==null){
              newHead=cur;
          }
          cur.next=prev;
          prev=cur;
          cur= curNext;
      }
      return newHead;

    }
}
方法二头插法
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode();
        while (head != null){
            ListNode q = new ListNode();
            q.val= head.val;
            q.next = p.next;
            p.next = q;
            head = head.next;
        }
        return p.next;
    }
}

作删除链表中等于给定值 val 的所有节点。
示例:
输入: 1->2->6->3->4->5->6, val = 6输出: 1->2->3->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head ==null){
            return null;
        }
        ListNode prev=head;
        ListNode cur=head.next;
         while(cur!=null){
     if (cur.val==val){
        prev.next=cur.next;
        cur=cur.next;
    }else {
        prev=cur;
        cur=cur.next;
    }
    
}
if (head.val==val){
    head=head.next;
}
return head;
    }
}

给定一个头结点为 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
       
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast.next==null){
            return slow;
        }else {
            return slow.next;
        }
         //return slow;
    }
}


输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
public ListNode FindKthToTail(ListNode head,int k) {
//判断链表是否为空
        if(head==null){
            return null;
        }

//判断输入位置是否合法
     int count1=0;
        ListNode number=head;
        while(number!=null){
count1++;
        number=number.next;}
        if(k>count1){
            return null;
        }
    ListNode fast=head;
    ListNode slow=head;
    int count=1;
        
    while (count<=k){
     fast=fast.next;
        count ++;
      }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur= new ListNode();
        ListNode head = cur;
         if(l1==null){
            return l2;
        } 
        if(l2==null) {
            return l1;
        }
       while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;

            } else {
                cur.next = l1;
                l1 = l1.next;
            }

           cur=cur.next;

       }
       if(l1==null){
           cur.next=l2;
       }else {
           cur.next=l1;
       }
        return head.next;
        }
}
