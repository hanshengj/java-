
import java.util.Random;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-03-24
 * Time: 19:17
 */
public class Calculatus01 {
    public static void main(String[] args) {
        //给定一个数组大小为1001，里面放了1-1000这1000个数，另外给一个1-1000的随机数，求这个数组中出现两次的数字
        int n = 1001;
        int[] arr = new int[n];
        //将1-1000这1000个数放到数组当中
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        //赋值最后一个随机数
        arr[arr.length - 1] = new Random().nextInt(n - 1) + 1;
        //将最后一个随机数放到任意的位置
        int index = new Random().nextInt(n);
        int temp = arr[index];
        arr[index] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        for (int x : arr) {
            System.out.print(x + " ");
        }
        //先给结果变量异或一遍1-1000，因为这样那个重复的数字就相当于有三个，其他的数字有两个
        int ret = 0;
        for (int i = 1; i <= n - 1; i++) {
            ret = ret ^ i;

        }
        //遍历数组，找到重复的那个数
        for (int i = 0; i < n; i++) {
            ret = ret ^ arr[i];
        }
        System.out.println();
        System.out.println(ret);
        //return ret;

        //方法二、利用辅助空间，遍历数组，将每次遍历的数组元素值作为辅助数组的下标，
        // 每存一次，辅助数组元素加一，最后哪个数组下标对应的值为2，说明他出现了两次，返回下标即可


        //定义辅助数组
        int auxiliaryArray[] = new int[n];
        for (int i = 0; i < n; i++) {
            auxiliaryArray[arr[i]]++;
        }
        System.out.println("-------");
        for (int i = 0; i < n; i++) {
            if (auxiliaryArray[i] == 2) {
                System.out.println(i);
                //return i;
                break;
            }

        }
    }
}
