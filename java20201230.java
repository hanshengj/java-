/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-30
 * Time: 10:30
 */
public class java20201230 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 4, 5, 3, 7, 9, 5, 5, 8, 4};
//        int[] arr1 = new int[]{9, 4, 3, 7, 9, 7, 8};
//        //swap(arr);
//        swapArray(arr,arr1);
//        for (int x : arr) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        for (int x : arr1) {
//            System.out.print(x + " ");
//        }
//        System.out.println("韩宝骏");
        SeqList list1 = new SeqList(9);
        list1.addLast(10);
        list1.addLast(14);
        list1.addLast(8);
        list1.addLast(14);
        list1.addLast(17);
        list1.display();
        list1.contains(6);
        list1.display();
        list1.addLast(98);
        list1.addLast(98);
        list1.addLast(98);
        list1.addLast(98);
        list1.addLast(98);
        list1.addLast(98);
        list1.display();
    }

    //交换两个数组的内容
    public static void swapArray(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
    }

    //将数组中的奇数放到数组后面，偶数放在前面
    public static void swap(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //从左到右找奇数
            while (left < right & array[left] % 2 == 0) {
                left++;
            }
            if (left >= right) {
                return;
            } else {
                //从右往左找偶数
                while (left < right & array[right] % 2 != 0) {
                    right--;
                }
                if (left >= right) {
                    return;
                } else {
                    //奇数放后，偶数放前
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;

                }
            }
        }
    }

}
