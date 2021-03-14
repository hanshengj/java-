给定数组，建一个大堆，实现插入弹出等操作

import java.util.Arrays;

public class HeapDemo {

    public int[] elem;
    public int usedSize;

    public HeapDemo() {
        this.elem = new int[10];
    }


    /**
     * 在这里  为什么可以传len
     * 是因为每棵树的结束位置 实际上都是一样的
     * @param parent
     * @param len   假设长度为10  len 就是10
     *              时间复杂度：O(logn)
     */
    public void adjustDown(int parent,int len) {
        int child = 2*parent+1;//下标从零开始
        //child < len 说明有左孩子
        while (child < len) {
            //child+1 < len 判断的是 当前是否  有右孩子
            if(child+1 < len && this.elem[child] < this.elem[child+1]) {
                child++;//选出左右孩子的最大值
            }
            //child 下标 一定是 左右孩子的最大值下标
            if(this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
             
                // this.elem[child] <= this.elem[parent]   后续就不需要循环了
                //后面的都已经是大根堆了
                break;
            }
        }
    }
    //时间复杂度：nlogn
    public void crateBigHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //elem当中已经存放了元素
        for(int i = (this.usedSize-1-1) /2; i>= 0;i--) {
            adjustDown(i,this.usedSize);
        }
    }


    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    /**
     * 逻辑：放到数组的最后一个位置
     * 然后向上调整
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            this.elem =Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;

        adjustUp(this.usedSize-1);
    }

    /**
     * 第一个 和 最后一个换
     * 向下调整 0下标这棵树
     * @return
     */
    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int ret = this.elem[0];
        //删除
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;//9
        adjustDown(0,this.usedSize);
        return ret;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return this.elem[0];
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
        System.out.println();
    }

}

