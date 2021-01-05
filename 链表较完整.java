
public class java20210101 {
       public static void main1(String[] args) {
        myLinkedList list = new myLinkedList();
        list.addLAst(1);
        list.addLAst(2);
        list.addLAst(3);
        list.printLinkedList();
        list.addFirst(10);
        list.printLinkedList();
        list.addPOs(2,5);
        System.out.print("链表大小为：");
        System.out.println(list.size());
        list.printLinkedList();
        list.addPOs(-1,10);
        System.out.println( list.contains(52));
        System.out.println(list.findLastNode().data);
        System.out.println(list.findTwoLastNode().data);
        list.addLAst(9);
        list.addLAst(9);
        list.addLAst(9);
        list.printLinkedList();
        list.reSetPos(4,666);
        list.printLinkedList();
        list.reSetKey(9,999);
        list.printLinkedList();
        list.printLinkedList();
        list.removeKey(2);
        list.printLinkedList();
        list.addFirst(10);
        list.addFirst(10);
        list.reSetAllKey(10,111);
        list.printLinkedList();
        list.removeAllKey(10);
        list.printLinkedList();
        System.out.println("四号位置节点为：" + list.findPos(4).data);
        list.clean();
        list.printLinkedList();
    }

    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.addLAst(1);
        list.addLAst(2);
        list.addLAst(3);
        list.addFirst(17);
        list.addFirst(17);
        list.addFirst(17);
        list.addFirst(17);
        list.addPOs(2, 6);
        list.printLinkedList();
        list.diviteList(3);
        list.printLinkedList();
        myLinkedList list1 = new myLinkedList();
        list1.addFirst(49);
        list1.addFirst(41);
        list1.addFirst(17);
        list1.addFirst(9);
        System.out.println("链表1为：");
        list1.printLinkedList();
        Node one=list1.head;
        myLinkedList list2 = new myLinkedList();
        list2.addFirst(95);
        list2.addFirst(88);
        list2.addFirst(37);
        System.out.println("链表2为：");
        list2.printLinkedList();
        Node two=list2.head;
        list.mergeTwoList(one,two);
        list.printLinkedList();
        System.out.println("倒数第二个节点的值为" + list.findKData(2));
        System.out.println("中间节点的值为：" + list.findMiddle());
        System.out.println("链表反转");
        list.reverse();
        list.printLinkedList();
        list.addPOs(5,41);
        System.out.println("删除链表中所以职位key的节点");
        list.removeAllKey(41);
        list.printLinkedList();
        //list.deleteRepete();
        //list.printLinkedList();
    }
}

//链表类
class myLinkedList {
    public Node head = null;//设置头节点

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
    public void printLinkedList() {
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
        } else {
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


    //删除值为key的第一个节点
    public void removeKey(int key) {
        //判断链表是否为空
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
        Node prev = this.head;//当前节点的前一个节点
        Node cur = this.head.next;//当前节点
        while (cur != null) {
            //当前节点的值为key
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                //当前节点的值不为key
                prev = cur;
                cur = cur.next;
            }
        }
        //判断头节点的值是否为key
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }


    //删除链表中的重复值
    public void deleteRepete() {
        if (this.head == null || this.head.next == null) {
            return;
        }
        // 自己构建辅助头结点
        Node head1 = new Node();
        head1.next = this.head;
        Node pre = head1;
        Node cur = this.head;
        //循环遍历，直到链表为空
        while (cur != null) {
            //如果是重复值
            if (cur.next != null && cur.next.data == cur.data) {
                // 相同结点一直往后移动
                while (cur.next != null && cur.next.data == cur.data) {
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续往后遍历
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            } else {
                //else表示值不相等即不重复时
                pre = cur;
                cur = cur.next;
            }
        }
        this.head = head1.next;
    }

    //清空链表
    public void clean() {
        this.head = null;
    }

    //链表分割
    public void diviteList(int k) {

        Node highHead=new Node();
        Node slowHead=new Node();
        Node high=highHead;
        Node slow=slowHead;
        while(this.head!=null){
            if(this.head.data<k){
                slow.next=this.head;
                this.head=this.head.next;
                slow=slow.next;
            }else{
                high.next=this.head;
                this.head=this.head.next;
                high=high.next;
            }
        }
        high.next=null;
        slow.next=highHead.next;
        this.head=slowHead.next;
    }


    //合并两个有序链表
    public void mergeTwoList(Node l1,Node l2){
        Node head1=new Node();
        Node head2=head1;
        while (l1!=null&&l2!=null){
            if (l1.data<l2.data){
                head2.next=l1;
                l1=l1.next;
            }else{
                head2.next=l2;
                l2=l2.next;

            }
            head2=head2.next;
        }
        if (l1==null){
            head2.next=l2;
        }else{
            head2.next=l1;
        }
        this.head =head1.next;
    }




    //修改pos位置的值
    public void reSetPos(int pos, int data) {
        Node node = findPos(pos);
        node.data = data;
    }


    //修改值为key的第一个节点
    public void reSetKey(int key1, int key2) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key1) {
                cur.data = key2;
                return;
            }
            cur = cur.next;
        }
    }

    //修改值为key的所有节点
    public void reSetAllKey(int key1, int key2) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key1) {
                cur.data = key2;
            }
            cur = cur.next;
        }
    }

    //链表反转
    public void reverse() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        this.head= newHead;
    }

    //求链表的中间节点,返回节点的值
    public int findMiddle() {
        //如果链表为空，则返回null
        if (head==null){
            return -1;
        }
        Node fast=head;//快指针
        Node slow =head;//慢指针
        //通过快指针判断循环的条件
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;//快指针，每次往后走两步
            slow=slow.next;//慢指针，每次往后走一步
        }
        //奇数个节点时，返回slow
        if (fast.next==null){
            return slow.data;
        }else{
            return slow.next.data;//偶数个节点时返回slow.next
        }

    }


    //找链表倒数第k个节点,返回该节点的值
    public int findKData (int k){
        int count=1;
        Node fast=head;
        while(count<=k){
            fast=fast.next;
            count++;
        }
        Node slow=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }

}

//定义节点类
class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}