
public class StackDemo {
    private int[] elem;
    private int top;//既可以代表下标：这个位置就是当前可以存放数据的下标
    // 也可以代表当前有多少个元素

    public StackDemo() {
        this.elem = new int[10];//默认栈的大小为10
    }

    public boolean isFull() {//判断栈是否满了
        return this.top == this.elem.length;
    }

    public int push(int item) {
        if(isFull()) {
            throw new RuntimeException("栈为满");
        }
        this.elem[this.top] = item;
        this.top++;
        return this.elem[this.top-1];
    }

    /**
     * 弹出栈顶元素 并且删除
     * @return
     */
    public int pop() {
        if(empty()) {
            //return -1;
            throw new RuntimeException("栈为空");
        }
        this.top--;
        return this.elem[this.top];
    }

    /**
     * 拿到栈顶元素不删除
     * @return
     */
    public int peek() {
        if(empty()) {
            //return -1;
            throw new RuntimeException("栈为空");
        }
        return this.elem[this.top-1];
    }

    public boolean empty() {
        return this.top == 0;
    }

    public int size() {
        return this.top;
    }
}
