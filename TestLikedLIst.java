/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-31
 * Time: 10:50
 */
public class TestLikedLIst {
    public static void main(String[] args) {
        SingleLikedList1 myList = new SingleLikedList1();
        myList.sddFirst(19);
        myList.sddFirst(10);
        myList.sddFirst(5);
        myList.sddFirst(10);
        myList.printLinkedList();
        myList.addLast(2);
        myList.addLast(2);
        myList.addLast(2);
        myList.printLinkedList();
        System.out.print("链表大小为：");
        System.out.println(myList.size());
        myList.addIndex(2,99);
        myList.printLinkedList();
        System.out.println("是否存在5节点：" + myList.contains(5));
        System.out.println("是否存在100节点：" + myList.contains(100));
        Node  node1=myList.searchLastNode();
        System.out.println(node1.data);
        myList.removeKey(5);
        myList.printLinkedList();
        //myList.addLast(9);
        myList.removeAllKey(2);
        myList.printLinkedList();
        myList.clean();
        myList.printLinkedList();

    }
}
