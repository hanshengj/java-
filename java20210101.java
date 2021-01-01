/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-01
 * Time: 10:55
 */
public class java20210101 {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.addLAst(1);
        list.addLAst(2);
        list.addLAst(3);
        list.printLinkedLast();
        list.addFirst(10);
        list.printLinkedLast();
        list.addPOs(2,5);
        System.out.print("链表大小为：");
        System.out.println(list.size());
        list.printLinkedLast();
        list.addPOs(-1,10);
        System.out.println( list.contains(52));
        System.out.println(list.findLastNode().data);
        System.out.println(list.findTwoLastNode().data);
        list.addLAst(9);
        list.addLAst(9);
        list.addLAst(9);
        list.printLinkedLast();
        list.removeKey(2);
        list.printLinkedLast();
        list.addFirst(10);
        list.addFirst(10);
        list.printLinkedLast();
        list.removeAllKey(10);
        list.printLinkedLast();
        System.out.println("四号位置节点为：" + list.findPos(4).data);
        list.clean();
        list.printLinkedLast();
    }
}

class myLinkedList {
    public  Node head=null;//设置头节点

    //求链表的大小方法
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    //打印链表
    public void printLinkedLast() {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println("打印完了");
    }


    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        //如果插入的不是头节点
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }

    //尾插法
    public void addLAst(int data) {
        Node node = new Node(data);
        //若链表为空
        if (this.head == null) {
            this.head = node;
        }else {
            //链表不为空，找尾巴
            Node index = findIndex();//调用找尾巴方法findIndex()
            index.next = node;
        }
    }

    //找尾巴方法
    public Node findIndex() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //在给定位置插入节点
    public void addPOs(int pos, int data) {
        if (pos < 0 || pos > size()) {
            System.out.println("输入位置不合法");
            return;
        }
        //头插法
        if (pos == 0) {
            addFirst(data);
            return;
        }
        //尾插法
        if (pos == size()) {
            addLAst(data);
            return;
        }
        //中间插入
        Node node = new Node(data);
        Node index = findPrev(pos);//找插入位置的前一个节点
        node.next = index.next;
        index.next = node;
    }

    //找插入位置的前一个节点，从0开始
    public Node findPrev(int pos) {
        Node cur = this.head;
        int count = 0;//从0开始
        while (count != pos - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找链表中是否含有值为key的节点
    public boolean contains(int key) {

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找链表最后一个节点
    public Node findLastNode() {
        if (this.head == null) {
            System.out.println("链表为空");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //查找链表倒数第二个节点
    public Node findTwoLastNode() {
        if (this.head == null) {
            System.out.println("链表为空");
            return null;
        }
        if (this.head.next == null) {
            System.out.println("链表只有一个节点");
            return null;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //查找位置为pos的节点
    public Node findPos(int pos) {
        if (this.head == null) {
            System.out.println("链表为空");
            return null;
        }
        if (pos < 0 || pos > size()) {
            System.out.println("输入位置不合法");
            return null;
        }
        Node cur = this.head;
        int count = 0;
        while (count != pos) {
            count++;
            cur = cur.next;
        }
        return cur;
    }


    //删除值为key的节点
    public void removeKey(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        //删除的为头结点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //找key的前驱节点
        Node index = findKeyIndex(key);
        if (index == null) {
            System.out.println("该节点的前驱不存在");
            return;
        }
        index.next = index.next.next;
    }

    //找key的前驱节点
    public Node findKeyIndex(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //清空链表
    public void clean() {
        this.head = null;
    }


}

class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}