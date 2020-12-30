import java.util.Arrays;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-30
 * Time: 13:25
 */
public class SeqList {

    private int usedSize = 0;
    public int[] elem;

    public SeqList() {
        this.elem = new int[5];
    }

    public SeqList(int capacity) {
        this.elem = new int[capacity];
    }

    //打印顺序表
    public void display() {
        if (this.usedSize <= 0) {
            System.out.println("链表为空");
            return;
        }
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //判断链表是否为满
    public boolean isFull() {
        if (this.elem.length == this.usedSize) {
            return true;
        }
        return false;
    }

    //给链表的pos位置添加元素
    public void add(int pos, int data) {
        //判断链表是否为满
        if (isFull()) {
            System.out.println("链表已经满了，正在扩容");
            reSize();
        }
        //判断输入位置是否合法
        if (pos < 0 || pos > usedSize) {
            System.out.println("输入位置不合法");
            return;
        }
        //移动元素
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //默认在链表末尾插入元素
    public void addLast(int data) {
        if (isFull()) {
            System.out.println("链表已经满了，正在扩容");
            reSize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    //查找链表中是否存在该元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素在链表中的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    //获取链表长度
    public int getSize() {
        return this.usedSize;
    }

    //重置链表的大小
    public void reSize() {
        this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
    }

    //获取链表给定位置的元素
    public int getNumber(int pos) {
        //判断输入位置是否合法
        if (pos < 0 || pos > usedSize) {
            System.out.println("输入位置不合法");
            return -1;
        }
        return this.elem[pos];
    }

    //将pos位置的元素改为data
    public void sets(int pos, int data) {
        if (pos < 0 || pos > usedSize) {
            System.out.println("输入位置不合法");
            return;
        }
        this.elem[pos] = data;
    }

    //删除第一次出现的关键字key
    public void delete(int key) {
        int index = search(key);
        if (index == -1) {
            System.out.println("链表中没有该元素");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    //清空链表
    public void clean() {
        this.usedSize = 0;
    }
}

