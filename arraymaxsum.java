输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
求所有子数组的和的最大值。

要求时间复杂度为O(n)。

class Solution {
    public int maxSubArray(int[] nums) {
        //暴力法
    //   int len = nums.length;
    //   int maxSum = Integer.MIN_VALUE;
    //   int sum = 0;
    //   for (int i = 0; i < len; i++) {
    //     sum = 0;
    //     for (int j = i; j < len; j++) {
    //       sum += nums[j];
    //       maxSum = Math.max(maxSum, sum);
    //     }
    //   }
    //   return maxSum;

    //动态规划
     int currMaxSum = nums[0];
     int maxSum = nums[0];
     for (int i = 1; i < nums.length; i++) {
       currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
       maxSum = Math.max(maxSum, currMaxSum);
     }
     return maxSum;

    }
}