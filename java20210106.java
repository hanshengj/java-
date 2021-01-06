/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-01-06
 * Time: 13:08
 */
public class java20210106 {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 45, 34, 21, 87, 67};
        int[] sortafter = bubbleSort(arrays);
        System.out.print("冒泡排序后：");
        for (int x : sortafter) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[] arrays1 = new int[]{1, 45, 34, 21, 87, 67};
        int[] sortafter1 = choiceSort(arrays);
        System.out.print("选择排序后：");
        for (int x : sortafter) {
            System.out.print(x + " ");
        }

    }

    //冒泡排序
    static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        //控制趟数
        for (int i = 0; i < len - 1; i++) {
            boolean isSort=true;//判断是否有顺序，默认为有序
            //从0号位置开始遍历数组，找出最大值，放在数组最后
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSort=false;//发生交换，说明是无序的
                }
            }
            if(isSort){
                break;
            }
        }
        return arr;
    }

    //选择排序
    static int[] choiceSort(int[] arrays) {
        int len = arrays.length;
        int index;
        //控制趟数
        for (int i = 0; i < len - 1; i++) {
            index = 0;
            //从0号位置开始遍历数组，找出最大值的下标
            for (int j = 0; j <= len - i - 1; j++) {
                if (arrays[index] < arrays[j]) {
                    index = j;
                }
            }
            //交换最大值与最后位置的值
            int temp = arrays[len - 1 - i];
            arrays[len - 1 - i] = arrays[index];
            arrays[index] = temp;
        }
        return arrays;
    }

}

