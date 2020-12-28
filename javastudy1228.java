///**
// * Crtated with IntelliJ IDEA.
// * Destcription:
// * User: hp
// * Date: 2020-12-28
// * Time: 21:22
// */
//public class javastudy1228 {
//    public static void main(String[] args) {
//        int []arr = {1,2,3,6,4,7};
//        System.out.println(find(arr,3));
//    }
//    //给定一个数组，给定一个元素，找出这个元素在数组中的位置
//    public static int find (int []arr, int toFind){
//        for ( int i= 0;i <arr.length;i++){
//            if ( arr[i]==toFind){
//                return i;
//            }
//        }
//        return -1;
//    }
//}
//针对有序数组, 可以使用更高效的二分查找.
//  啥叫有序数组?
//        有序分为 "升序" 和 "降序" 如 1 2 3 4 , 依次递增即为升序. 如 4 3 2 1 , 依次递减即为降序.
//        以升序数组为例, 二分查找的思路是先取中间位置的元素, 看要找的值比中间元素大还是小. 如果小, 就去左边找; 否
//        则就去右边找.
public class javastudy1228 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 9};
        System.out.println(binarySearch(arr, 6));
    }

    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
