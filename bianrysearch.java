
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int middle=0;
        while(left<=right){
            middle=(left+right)/2;
            if(nums[middle]==target){
                return middle;
            }else {
                if(nums[middle]<target){
                    left=++middle;
                }else {
                    right=--middle;
                }
            }
        }

          return -1;
    }
}