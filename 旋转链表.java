通过上面的示例我们可以发现，当旋转步数大于链表长度时，
其实是做了个循环，如链表的长度为3，旋转步数为4，相当
于只旋转了1步，旋转步数为7也相当于1步，所以我们可以
得到当k>len(链表长度时)，k=K%len;同时也可以发现，旋转
k步，相当于链表往后遍历len-k步，此时的节点便是新头，如
果链表是个环，我们只需要从新头出断开环便可；所以我们
需要做的可以分为以下几步：
1、求出链表的大小，
2、将链表连接成一个环
3、求出旋转步数k，和链表往后遍历的步数k=len-k;
4、链表遍历K步，并将此节点作为新头
5、再遍历链表，找到新头的前一个节点，并从此处断开环
6、返回新头
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //判断链表是否为空
     if(head==null){
         return null;
     }
     //输入是否合法
     if(k<=0){
         return head;
     }
     ListNode cur=head;
     int count=1;
     //遍历链表，求链表长度
     while(head.next!=null){
         head=head.next;
         count ++;
     }
     head.next=cur;//将链表首尾相连，形成环
     //求得旋转的步数
     //若旋转的步数小于链表长度，
     if(k<=count){
         k=count-k;
     }else{
         //若旋转的步数大于链表长度，
         k=k%count;
         k=count-k;
     }
     //链表从头开始往后遍历k步
     while((k--)>0){
         cur=cur.next;
     }
     ListNode newHead=cur;//得到新的链表头
     //再遍历一遍，找到链表头的前驱，断开链表
     //因为之前我们将链表连接成了一个环
     while(cur.next!=newHead){
         cur=cur.next;
     }
     cur.next=null;//断开链表，使链表不在是环
     return newHead;//返回新头
    }
}