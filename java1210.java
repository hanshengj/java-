import java.util.Arrays;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2020-12-10
 * Time: 23:19
 */

////给定一个整形数组和一个整数，求数组中两数之和等于这个整数的下标
//public class java1210 {
//    public static void main(String[] args) {
//        int[] arr = {1, 5, 3, 6, 7, 12, 4, 5};
//        int[] arr1 = twoSum(arr, 17);
//        for (int x : arr1) {
//            System.out.println(x + " ");
//        }
//    }
//
//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//
//    }
//}

//数组中占比超过一半的元素称之为主元素，给定一个整数数组，找到它的主元素，若没有，则返回-1
class java1210 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 5, 12, 4, 5,5,5,5};
        int num = majorityElement(arr);
        System.out.println(num);
    }
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i <= len/2;i++) {
            for(int j = i+len/2; j < len;j++) {
                if(nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}

