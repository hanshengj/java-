用队列实现栈：
请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
实现 MyStack 类：
void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false
 思想 ：入栈时，哪个队列不为空，就放在哪个队列里面，若都为空，则默认放在队列1里，出栈时，将不为空的队列里的
size减1个元素放到空队列里，然后将最后一个元素弹出队列；

class MyStack {
    private Queue<Integer> qu1 = new LinkedList<>();
    private Queue<Integer> qu2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
    }
    /** Push element x onto stack. */
    public void push(int x) {
        //谁不为空入到哪个队列当中
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else{
            qu1.offer(x);//指定存放到了qu1
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        //每次出不为空的队列，出size-1个 到另外一个为空的队列，最后弹出剩余的那一个元素
        if(!qu1.isEmpty()) {
            int size =  qu1.size();
            for(int i = 0;i < size -1;i++) {
               qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }else {
            int size =  qu2.size();
            for(int i = 0;i < size -1;i++) {
               qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        //每次出不为空的队列，出size个 到另外一个为空的队列，最后弹出剩余的那一个元素
        if(!qu1.isEmpty()) {
            int size =  qu1.size();
            int cur = -1;
            for(int i = 0;i < size;i++) {
               cur = qu1.poll();
               qu2.offer(cur);
            }
            return cur;
        }else {
            int size =  qu2.size();
            int cur = -1;
            for(int i = 0;i < size;i++) {
                cur = qu2.poll();
                qu1.offer(cur);
            }
            return cur;
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
用栈实现队列
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false


思想栈1用来入队，即将入队的元素都放到栈1里，出队时先看栈2是否为空，栈2不为空则直接弹出，若为空，
则将栈1里的所有元素都放到栈2里，在弹出；

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();//入队
    private Stack<Integer> s2 = new Stack<>();//出队
    public MyQueue() {

    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
     
        return s2.pop();
    }
    
    public int peek() {
        if(empty()) {
            return -1;
        }
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();        
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

