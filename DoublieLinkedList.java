/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-07
 * Time: 19:46
 */
public class DoublieLinkedList {
    public static void main(String[] args) {
        DoublieLinkedList1 l1 = new DoublieLinkedList1();
        l1.addFirst(10);
        l1.addFirst(9);
        l1.addFirst(9);
        l1.addFirst(8);
        l1.addFirst(7);
        l1.addFirst(7);
        l1.addFirst(7);
        l1.addLast(99);
        l1.addLast(99);
        l1.addLast(99);
        l1.addLast(99);
        System.out.println(l1.size());
        l1.display();
        //l1.addIndex(4,100);
        //l1.remove(99);
        l1.removeAllKey(9);
        l1.display();
        System.out.println(l1.contains(111));
        l1.clear();
        l1.display();
    }

}

class ListNode {
    private int val;
    private ListNode next;

    public int getVal() {

        return val;
    }

    public void setVal(int val) {

        this.val = val;
    }

    public void setNext(ListNode next) {

        this.next = next;
    }

    public void setPrev(ListNode prev) {

        this.prev = prev;
    }

    public ListNode getNext() {

        return next;
    }

    public ListNode getPrev() {

        return prev;
    }

    private ListNode prev;

    //alt+insert   ->   Constructor
    public ListNode(int val) {

        this.val = val;
    }
}

class DoublieLinkedList1 {

    private ListNode head;//头
    private ListNode last;//尾


    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            head = node;
            last = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            head = node;
            last = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(index<0||index>size()){
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        ListNode cur=this.head;
        while(index!=0){
            index--;
            cur=cur.getNext();
        }
        ListNode node=new ListNode(data);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.getPrev().setNext(node);
        cur.setPrev(node);
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        if(this.head==null){
            return false;
        }
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.getVal()==key){
                return true;
            }
            cur=cur.getNext();
        }
        return false;
    }



    //查找关键字key节点，并返回该节点
    public ListNode containsKeyNode(int key) {
        if(this.head==null){
            return null;
        }
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.getVal()==key){
                return cur;
            }
            cur=cur.getNext();
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode text=containsKeyNode(key);
        if(text==null){
            System.out.println("该节点不存在");
            return ;
        }
        if(text==head){
            head=head.getNext();
            head.setPrev(null);
            return ;
        }else if(text==last){
            last=last.getPrev();
            last.setNext(null);
        }else {
            text.getPrev().setNext(text.getNext());
            text.getNext().setPrev(text.getPrev());
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode text = containsKeyNode(key);
        if (text == null) {
            System.out.println("该节点不存在");
        }
        while (text != null) {
            if (text.getVal() == key) {
                if (text == head) {
                    head = head.getNext();
                    head.setPrev(null);
                } else if (text == last) {
                    last = last.getPrev();
                    last.setNext(null);
                } else {
                    text.getPrev().setNext(text.getNext());
                    text.getNext().setPrev(text.getPrev());
                }
            }
            text = text.getNext();
        }
    }




    //得到单链表的长度
    public int size() {
        if(this.head==null){
            return 1;
        }
        ListNode cur=this.head;
        int count =0;
        while(cur!=null){
            count++;
            cur=cur.getNext();
        }
        return count;
    }


    //打印链表
    public void display() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public void clear() {
        ListNode cur=this.head;
        while(cur!=null){
            ListNode curNext=cur.getNext();
            cur.setPrev(null);
            cur.setNext(null);
            cur=curNext;
        }
       this.head=null;
        this.last=null;
    }
}