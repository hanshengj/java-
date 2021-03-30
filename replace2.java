输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
则最小的4个数字是1、2、3、4。

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //建立大根堆，
         Queue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int i;
        for( i=0;i<k;i++){
            bigHeap.offer(arr[i]);
        }
        for(;i<arr.length;i++){
            Integer top=bigHeap.peek();
            if(top!=null){
                if(top>arr[i]){
                    bigHeap.poll();
                    bigHeap.offer(arr[i]);
                }
            }
        }
        //将结果存在数组中
        int [] ret=new int[k];
        for(int j=0;j<k;j++){
            ret[j]=bigHeap.poll();
        }
        return ret;

    }
}