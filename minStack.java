设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

思路：创建两个栈，一个普通的栈，一个存放最小元素的栈，入栈时，先放到普通栈，若入栈的元素小于等于最小栈
的栈顶元素，则将这个元素也放入最小栈。出栈时先将普通栈弹出，入弹出的元素等于最小栈的栈顶元素，则最小栈也弹出；

class MinStack {

    private Stack<Integer> nomalStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public MinStack() {

    }
    
    public void push(int x) {
        nomalStack.push(x);
        if(minStack.empty()) {
            minStack.push(x);
        }else {
            if(x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        int x = nomalStack.pop();
        if(x == minStack.peek()) {
            minStack.pop();
        }
    }
    //这个和最小栈没有关系
    public int top() {
        return nomalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}