输入两个链表，找出它们的第一个公共节点。
//快慢指针
 public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) {
                return null;
            }
            int lenA = 0;//链表A的长度
            int lenB = 0;//链表B的长度
            ListNode pl = headA;//永远指向最长的链表
            ListNode ps = headB;//永远指向最短的链表
            //统计链表A的长度
            while(pl != null) {
                pl = pl.next;
                lenA++;
            }
             //统计链表B的长度
            while(ps != null) {
                ps = ps.next;
                lenB++;
            }
            //遍历完后，ps,pl都指向了链表的末尾，这里
            //需要重新指回来
            pl = headA;
            ps = headB;
            //计算长链表比短链表长的值
            int len = lenA - lenB;
            if(len < 0) {
                pl = headB;
                ps = headA;
                len = lenB-lenA;
            }
            //快指针先走差值步
            while(len != 0) {
                pl = pl.next;
                len--;
            }
         //快慢指针一起往后遍历，直到找到相交节点
            while(pl != ps) {
                pl = pl.next;
                ps = ps.next;
            }
            //pl == ps，返回pl,ps都一样
            return pl;
        }
    }

//合并链表法
public class Solution {
 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA=headA;
        ListNode pB=headB;
        while(pA!=pB){
        //pA若没遍历完，继续往后遍历，遍历完则遍历pB
            pA= pA==null ? headB :pA.next;
            //pB若没遍历完，继续往后遍历，遍历完则遍历pA
            pB= pB==null ? headA :pB.next;
        }
        return pA;
    }
}