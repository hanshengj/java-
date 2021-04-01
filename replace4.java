
一个长度为n-1的递增排序数组中的所有数字都是唯一的，
并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。


class Solution {
    public int missingNumber(int[] nums) {
        //方法一，暴力法
        // for (int i=0;i<nums.length;i++){
        //     if(nums[i]!=i){
        //         return i;
        //     }
        // }
        // return nums.length;

        // //方法二，异或法
        // int ret=0;
        // for (int i=0;i<nums.length;i++){
        //     ret^=nums[i] ^ (i+1);
        // }
        // return ret;

        // 方法三，等差数列求和法
        int sum=(0+nums.length)*(1+nums.length)/2;
        for(int x: nums){
            sum-=x;
        }
        return sum;
        

    }
}