/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-31
 * Time: 10:49
 */
public class SingleLikedList1 {
    public Node head;

    //求链表的长度
    public int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    //头插法插入元素
    public void sddFirst(int data){
        //先创建一个节点
        Node node = new Node(data);
        //判断链表是否为空
        if (this.head != null) {
            node.next = this.head;
        }
        this.head=node;

    }


    //尾插法插入元素
    public void addLast(int data){
        //先创建一个节点
        Node node = new Node(data);
        Node cur = head;
        //判断链表是否为空
        if (this.head==null){
            this.head=node;
        }else {
            while(cur.next!=null){////////////////
                cur=cur.next;
            }
            cur.next=node;
        }
    }


    //指定位置插入元素
    public void addIndex(int pos,int data){
        //判断位置是否合法
        if (pos<0 || pos>size()){
            System.out.println("您输入的位置不合法");
            return ;
        }
        if(pos ==0){
            //头插法
            sddFirst(data);
        } else if(pos==size()){
            //尾插法
            addLast(data);
        }else {
            //找位置，即所插入位置的前一个位置
            Node index= findPosLowOne(pos);
            Node node = new Node(data);
            node.next=index.next;
            index.next=node;
        }
    }

    //寻扎给定的位置的前一个位置
    public Node findPosLowOne(int pos){
        int count =0;
        Node cur =this.head;
        while( count!= pos-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }



    //查找最后一个节点
    public Node searchLastNode(){
        //若链表没有节点
        if (this.head==null){
            System.out.println("不好意思，该链表为空");
            return null;
        }
        Node cur = this.head;
        while ( cur.next !=null){
            cur =cur.next;
        }
        return cur;
    }

    //查找倒数第二个节点
    public Node searchLastTwoNode(){
        if (this.head==null){
            System.out.println("不好意思，该链表为空");
            return null;
        }
        if (this.head.next==null){
            System.out.println("不好意思，该链表只有一个节点");
            return null;
        }
        Node cur = this.head;
        while ( cur.next.next!=null){
            cur=cur.next;
        }
        return cur ;
    }

    //查找给定位置的节点
    public Node searchPos(int pos){
        if (this.head ==null){
            System.out.println("链表为空");
            return null;
        }
        if (pos<0){
            System.out.println("输入位置太小，不合法");
            return null;
        }
        if (pos>size()){
            System.out.println("输入位置太大，不合法");
            return null;
        }
        int count =1;
        Node cur = this.head;
        while (count != pos){
            cur = cur.next;
            count++;

        }
        return cur;
    }

    //打印链表
    public void printLinkedList(){
        if (this.head==null){
            System.out.println("链表 为空");
        }
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找关键字key是否在链表中
    public boolean contains(int key){
        Node cur =this.head;
        while(cur!=null){
          if (cur.data==key){
              return true;
          }
          cur=cur.next;
        }
        return false;
    }


    //查找要删除关键字的前一个节点
    public Node searchPrev(int key){
        Node cur =this.head;
        while (cur.next!=null){
          if(cur.next.data==key){
              return cur;
          }
          cur=cur.next;
        }
        return null;
    }


    //删除第一次出现关键字key的节点
    public void removeKey (int key){
        Node cur = this.head;
        //删除的节点如果是头结点
        if(this.head.data==key){
           this.head=this.head.next;
           return ;
        }
        //查找删除节点的前驱，找不到返回null
        Node prev= searchPrev(key);
        if(prev==null){
            System.out.println("没有你要删除的节点");
            return;
        }
        prev.next= prev.next.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
      try {
          while (cur.next != null) {
              //删除的节点如果是头结点
              if (this.head.data == key) {
                  this.head = this.head.next;
              }

              if (cur.next.data == key) {//////////////////////////////////
                  cur.next = cur.next.next;
              }
              cur = cur.next;
          }
      }catch (NullPointerException e){

          }

    }

    //清除链表
    public void clean(){
        this.head=null;
    }
}


class Node {
    public int data;
    public Node next;
    public Node (){

    }
    public Node (int data){
        this.data=data;
    }
}