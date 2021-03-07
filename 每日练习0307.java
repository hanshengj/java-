设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用
循环队列，我们能使用这些空间去存储新的值。

要求：
MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。


class MyCircularQueue {

    private int front;
    private int rear;//代表当前可以存放数据元素的下标
    private int[] elem;

    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     * (rear+1)  % len
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        //放到数组的rear下标  rear往后走
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        return true;
    }

    /**
     * 队列是否为满
     * @return
     */
    public boolean isFull() {
        return (this.rear+1)%this.elem.length == this.front;
    }

    /**
     * 出队
     * @return
     */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        //只需要挪动front这个下标就好了
        this.front = (this.front+1) % this.elem.length;
        return true;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 得到队头元素
     * @return
     */
    public int Front() {
        //只需要返回front下标的元素就好了
        if(isEmpty()) {
            return -1;
        }
        int ret = this.elem[this.front];
        return ret;
    }

    /**
     * 得到队尾元素
     * @return
     */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = -1;
        if(this.rear == 0) {
            index = this.elem.length-1;
        }else {
            index = this.rear-1;
        }
        return this.elem[index];
    }
}

